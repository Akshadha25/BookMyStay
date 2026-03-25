public class UseCase2RoomInitialization {

    public static void main(String[] args) {

        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("===== Room Details =====");

        single.displayRoomDetails();
        System.out.println("Available: " + singleAvailable);

        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable);

        suite.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}