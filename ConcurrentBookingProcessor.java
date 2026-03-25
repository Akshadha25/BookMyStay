import java.util.*;
import java.util.concurrent.*;

public class ConcurrentBookingProcessor {
    private final Map<String, Integer> roomInventory; // roomType -> available count
    private final Queue<String> bookingQueue; // reservation IDs
    private final Map<String, String> allocations; // reservationID -> roomType
    private final Object lock = new Object();

    public ConcurrentBookingProcessor(Map<String, Integer> roomInventory) {
        this.roomInventory = roomInventory;
        this.bookingQueue = new LinkedList<>();
        this.allocations = new HashMap<>();
    }

    // Add booking request to queue
    public void submitBooking(String reservationId) {
        synchronized(bookingQueue) {
            bookingQueue.add(reservationId);
        }
    }

    // Thread-safe allocation
    public void processBookings(String roomType) {
        while(true) {
            String reservationId;
            synchronized(bookingQueue) {
                reservationId = bookingQueue.poll();
            }
            if(reservationId == null) break;

            synchronized(lock) {
                int available = roomInventory.getOrDefault(roomType, 0);
                if(available > 0) {
                    roomInventory.put(roomType, available - 1);
                    allocations.put(reservationId, roomType);
                    System.out.println("Allocated " + roomType + " to " + reservationId);
                } else {
                    System.out.println("No " + roomType + " available for " + reservationId);
                }
            }
        }
    }

    public Map<String, String> getAllocations() {
        return allocations;
    }
}