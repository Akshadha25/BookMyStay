public class UseCase4RoomSearch {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();
        SearchService search = new SearchService(inventory);

        search.displayAvailableRooms();
    }
}