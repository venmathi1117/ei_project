import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OfficeConfiguration office = OfficeConfiguration.getInstance();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Smart Office Facility ===");
        if (!Authentication.login()) return;

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Configure Rooms");
            System.out.println("2. Set Room Capacity");
            System.out.println("3. Book Room");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Add Occupants");
            System.out.println("6. View Room Statistics");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number of rooms: ");
                    int count = sc.nextInt();
                    office.configureRooms(count);
                    break;
                case 2:
                    System.out.print("Enter room ID and capacity: ");
                    int rId = sc.nextInt();
                    int cap = sc.nextInt();
                    Room capRoom = office.getRoomById(rId);
                    if (capRoom == null) {
                        System.out.println("Invalid room number. Please enter a valid room number.");
                    } else if (cap <= 0) {
                        System.out.println("Invalid capacity. Please enter a valid positive number.");
                    } else {
                        capRoom.setCapacity(cap);
                        System.out.println("Room " + rId + " maximum capacity set to " + cap);
                    }
                    break;
                case 3:
                    System.out.print("Enter room ID, start time (HH:MM), and duration (minutes): ");
                    int bookId = sc.nextInt();
                    String time = sc.next();
                    int dur = sc.nextInt();
                    Room bookRoom = office.getRoomById(bookId);
                    if (bookRoom == null) {
                        System.out.println("Invalid room number. Please enter a valid room number.");
                    } else {
                        new BookRoomCommand(bookRoom, time, dur).execute();
                    }
                    break;
                case 4:
                    System.out.print("Enter room ID to cancel booking: ");
                    int cancelId = sc.nextInt();
                    Room cancelRoom = office.getRoomById(cancelId);
                    if (cancelRoom == null) {
                        System.out.println("Invalid room number. Please enter a valid room number.");
                    } else {
                        new CancelRoomCommand(cancelRoom).execute();
                    }
                    break;
                case 5:
                    System.out.print("Enter room ID and number of occupants: ");
                    int roomId = sc.nextInt();
                    int occupants = sc.nextInt();
                    Room room = office.getRoomById(roomId);
                    if (room == null) {
                        System.out.println("Room " + roomId + " does not exist.");
                    } else {
                        room.attachSensor(new LightControl());
                        room.attachSensor(new AirConditionControl());
                        room.setOccupancy(occupants);
                    }
                    break;
                case 6:
                    System.out.println("=== Room Usage Statistics ===");
                    for (Room r : office.getRooms()) {
                        System.out.println("Room " + r.getId() + 
                                ": Capacity=" + r.getCapacity() +
                                ", Total Bookings=" + r.getTotalBookings() +
                                ", Total Occupancy=" + r.getTotalOccupancy());
                    }
                    break;
                case 7:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
