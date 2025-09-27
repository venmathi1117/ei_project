import java.util.*;

public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private List<Room> rooms;

    private OfficeConfiguration() {
        rooms = new ArrayList<>();
    }

    public static OfficeConfiguration getInstance() {
        if (instance == null) {
            instance = new OfficeConfiguration();
        }
        return instance;
    }

    public void configureRooms(int count) {
        rooms.clear();
        for (int i = 1; i <= count; i++) {
            rooms.add(new Room(i));
        }
        System.out.print("Office configured with " + count + " meeting rooms: ");
        for (int i = 1; i <= count; i++) {
            System.out.print("Room " + i + (i == count ? "." : ", "));
        }
        System.out.println();
    }

    public Room getRoomById(int id) {
        for (Room r : rooms) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
