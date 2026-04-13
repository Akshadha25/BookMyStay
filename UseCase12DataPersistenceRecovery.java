public class UseCase12DataPersistenceRecovery {
    public static void main(String[] args) {

        // Load previous state
        Object[] state = PersistenceService.loadState();
        BookingHistory history = (BookingHistory) state[0];
        RoomInventory inventory = (RoomInventory) state[1];

        System.out.println("Current bookings: " + history);
        System.out.println("Current inventory: " + inventory);

        // Example: Add a booking
        Reservation r = new Reservation("R1001", "Single", "GuestA");

        if (inventory.allocateRoom(r.getRoomType())) {
            history.addReservation(r);
            System.out.println("Booking confirmed: " + r);
        } else {
            System.out.println("No rooms available for type: " + r.getRoomType());
        }

        // Save state before exit
        PersistenceService.saveState(history, inventory);
    }
}
