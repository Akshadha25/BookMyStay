import java.util.LinkedList;
import java.util.Queue;

/**
 * Use Case 6: Room Allocation & Booking Confirmation
 */
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        // Step 1: Setup inventory
        RoomInventory inventory = new RoomInventory();
        inventory.addRoom("Single Room", 2);
        inventory.addRoom("Double Room", 1);
        inventory.addRoom("Suite Room", 1);

        // Step 2: Create booking queue
        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Akshadha", "Single Room"));
        bookingQueue.add(new Reservation("Rahul", "Double Room"));
        bookingQueue.add(new Reservation("Priya", "Suite Room"));
        bookingQueue.add(new Reservation("John", "Single Room"));
        bookingQueue.add(new Reservation("Anu", "Single Room")); // should fail

        // Step 3: Process bookings
        BookingService bookingService = new BookingService(inventory, bookingQueue);
        bookingService.processBookings();
    }
}