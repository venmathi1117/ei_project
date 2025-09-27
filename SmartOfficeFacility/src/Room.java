import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;

public class Room {
    private int id;
    private int capacity;
    private boolean booked;
    private String bookedTime;
    private int duration;
    private int occupants;
    private int totalBookings;
    private int totalOccupancy;
    private LocalDateTime lastOccupied;
    private List<Sensor> sensors = new ArrayList<>();
    private ScheduledFuture<?> autoReleaseTask;  // NEW
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public Room(int id) {
        this.id = id;
        this.capacity = 0;
        this.booked = false;
        this.occupants = 0;
    }

    public int getId() { return id; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int c) { this.capacity = c; }
    public int getTotalBookings() { return totalBookings; }
    public int getTotalOccupancy() { return totalOccupancy; }

    public void attachSensor(Sensor s) {
        sensors.add(s);
    }

    public void notifySensors(boolean occupied) {
        for (Sensor s : sensors) {
            s.update(occupied);
        }
    }

    public void setOccupancy(int count) {
        this.occupants = count;
        if (count >= 2) {
            System.out.println("Room " + id + " is now occupied by " + count + " persons.");
            totalOccupancy += count;
            notifySensors(true);
            lastOccupied = LocalDateTime.now();

            // Cancel auto-release if occupied
            if (autoReleaseTask != null && !autoReleaseTask.isDone()) {
                autoReleaseTask.cancel(false);
            }
        } else if (count == 0) {
            System.out.println("Room " + id + " is now unoccupied. AC and lights turned off.");
            notifySensors(false);
        } else {
            System.out.println("Room " + id + " occupancy insufficient to mark as occupied.");
        }
    }

    public boolean isBooked() { return booked; }

    public void book(String time, int dur) {
        if (booked) {
            System.out.println("Room " + id + " is already booked during this time. Cannot book.");
        } else {
            booked = true;
            bookedTime = time;
            duration = dur;
            totalBookings++;
            System.out.println("Room " + id + " booked from " + time + " for " + dur + " minutes.");

            // Schedule auto-release after 5 minutes if not occupied
            autoReleaseTask = scheduler.schedule(() -> {
                if (occupants < 2) {
                    booked = false;
                    System.out.println("Room " + id + " is now unoccupied. Booking released. AC and lights off.");
                    notifySensors(false);
                }
            }, 5, TimeUnit.MINUTES);
        }
    }

    public void cancel() {
        if (!booked) {
            System.out.println("Room " + id + " is not booked. Cannot cancel booking.");
        } else {
            booked = false;
            System.out.println("Booking for Room " + id + " cancelled successfully.");
            if (autoReleaseTask != null && !autoReleaseTask.isDone()) {
                autoReleaseTask.cancel(false);
            }
        }
    }
}
