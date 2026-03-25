public class UseCase10BookingCancellation {
    public static void main(String[] args) {
        // Setup inventory
        RoomInventory inventory = new RoomInventory();

        // Setup cancellation service
        CancellationService cancellationService = new CancellationService(inventory);

        // Simulate confirmed bookings
        Reservation r1 = new Reservation("RES1001", "Single Room", "S1");
        Reservation r2 = new Reservation("RES1002", "Double Room", "D1");

        cancellationService.addConfirmedReservation(r1);
        cancellationService.addConfirmedReservation(r2);

        // Show inventory before cancellation
        System.out.println("Available Single Rooms: " + inventory.getAvailableRooms("Single Room"));
        System.out.println("Available Double Rooms: " + inventory.getAvailableRooms("Double Room"));

        // Perform cancellations
        cancellationService.cancelReservation("RES1001");
        cancellationService.cancelReservation("RES9999"); // invalid ID

        // Show inventory after cancellation
        System.out.println("Available Single Rooms: " + inventory.getAvailableRooms("Single Room"));
        System.out.println("Available Double Rooms: " + inventory.getAvailableRooms("Double Room"));

        // Optional: print rollback stack
        cancellationService.printRollbackStack();
    }
}