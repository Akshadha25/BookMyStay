import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CancellationService {
    private Map<String, Reservation> confirmedReservations; // reservationID -> Reservation
    private RoomInventory inventory;
    private Stack<String> rollbackStack; // stores recently freed room IDs

    public CancellationService(RoomInventory inventory) {
        this.inventory = inventory;
        confirmedReservations = new HashMap<>();
        rollbackStack = new Stack<>();
    }

    // Add a confirmed reservation (from Booking)
    public void addConfirmedReservation(Reservation reservation) {
        confirmedReservations.put(reservation.getReservationID(), reservation);
    }

    // Cancel a reservation safely
    public boolean cancelReservation(String reservationID) {
        if (!confirmedReservations.containsKey(reservationID)) {
            System.out.println("Cancellation failed: Reservation ID not found.");
            return false;
        }

        Reservation reservation = confirmedReservations.get(reservationID);
        String roomType = reservation.getRoomType();

        // Undo allocation: increment inventory
        inventory.incrementRoom(roomType);

        // Add roomID to rollback stack (for potential undo of cancellations)
        rollbackStack.push(reservation.getRoomID());

        // Remove reservation from confirmed list
        confirmedReservations.remove(reservationID);

        System.out.println("Reservation " + reservationID + " cancelled successfully. Room released: " + reservation.getRoomID());
        return true;
    }

    // Optional: View rollback stack
    public void printRollbackStack() {
        System.out.println("Rollback Stack: " + rollbackStack);
    }
}