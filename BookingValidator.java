import java.util.HashSet;
import java.util.Set;

public class BookingValidator {
    private Set<String> validRoomTypes;

    public BookingValidator() {
        validRoomTypes = new HashSet<>();
        validRoomTypes.add("Single Room");
        validRoomTypes.add("Double Room");
        validRoomTypes.add("Suite");
    }

    public void validateReservation(String reservationId, String guestName, String roomType, int availableRooms) throws InvalidBookingException {
        if (reservationId == null || reservationId.isEmpty()) {
            throw new InvalidBookingException("Reservation ID cannot be empty.");
        }
        if (guestName == null || guestName.isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }
        if (!validRoomTypes.contains(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }
        if (availableRooms <= 0) {
            throw new InvalidBookingException("No rooms available for type: " + roomType);
        }
    }
}