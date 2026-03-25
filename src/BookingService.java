import java.util.*;

/**
 * Handles booking confirmation and room allocation
 */
public class BookingService {

    private RoomInventory inventory;
    private Queue<Reservation> bookingQueue;

    // Stores allocated room IDs (prevents duplicates)
    private Set<String> allocatedRoomIds;

    // Maps room type -> assigned room IDs
    private Map<String, Set<String>> roomAllocations;

    public BookingService(RoomInventory inventory, Queue<Reservation> bookingQueue) {
        this.inventory = inventory;
        this.bookingQueue = bookingQueue;
        this.allocatedRoomIds = new HashSet<>();
        this.roomAllocations = new HashMap<>();
    }

    public void processBookings() {

        System.out.println("\n=== Processing Bookings ===");

        while (!bookingQueue.isEmpty()) {

            Reservation request = bookingQueue.poll();
            String roomType = request.getRoomType();

            int available = inventory.getAvailability(roomType);

            if (available > 0) {

                // Generate unique room ID
                String roomId = generateRoomId(roomType);

                // Store globally (prevent duplicates)
                allocatedRoomIds.add(roomId);

                // Store per room type
                roomAllocations
                        .computeIfAbsent(roomType, k -> new HashSet<>())
                        .add(roomId);

                // Update inventory
                inventory.updateAvailability(roomType, available - 1);

                System.out.println("Booking Confirmed: "
                        + request.getGuestName()
                        + " | Room Type: " + roomType
                        + " | Room ID: " + roomId);

            } else {
                System.out.println("Booking Failed (No Availability): "
                        + request.getGuestName()
                        + " | Room Type: " + roomType);
            }
        }
    }

    private String generateRoomId(String roomType) {

        String prefix = roomType.replaceAll(" ", "").substring(0, 2).toUpperCase();
        String roomId;

        do {
            roomId = prefix + new Random().nextInt(1000);
        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }
}