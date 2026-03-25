public class SearchService {

    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void displayAvailableRooms() {

        System.out.println("===== Available Rooms =====");

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        displayIfAvailable("Single Room", single);
        displayIfAvailable("Double Room", doubleRoom);
        displayIfAvailable("Suite Room", suite);
    }

    private void displayIfAvailable(String type, Room room) {
        int available = inventory.getAvailability(type);

        if (available > 0) {
            room.displayRoomDetails();
            System.out.println("Available: " + available);
            System.out.println("----------------------");
        }
    }
}