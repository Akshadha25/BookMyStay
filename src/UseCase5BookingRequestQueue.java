import java.util.LinkedList;
import java.util.Queue;

public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        Queue<Reservation> bookingQueue = new LinkedList<>();

        bookingQueue.add(new Reservation("Akshadha", "Single Room"));
        bookingQueue.add(new Reservation("Rahul", "Double Room"));
        bookingQueue.add(new Reservation("Priya", "Suite Room"));

        System.out.println("=== Booking Request Queue ===");

        for (Reservation r : bookingQueue) {
            System.out.println("Guest: " + r.getGuestName() +
                               " | Room: " + r.getRoomType());
        }
    }
}