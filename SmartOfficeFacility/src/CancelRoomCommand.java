public class CancelRoomCommand implements Command {
    private Room room;

    public CancelRoomCommand(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        room.cancel();
    }
}
