public class BookRoomCommand implements Command {
    private Room room;
    private String time;
    private int duration;

    public BookRoomCommand(Room room, String time, int duration) {
        this.room = room;
        this.time = time;
        this.duration = duration;
    }

    @Override
    public void execute() {
        room.book(time, duration);
    }
}
