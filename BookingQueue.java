import java.util.LinkedList;
import java.util.Queue;

public class BookingQueue {

    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println(reservation.getGuestName() + " added to queue for " + reservation.getRoomType());
    }

    public void displayQueue() {
        System.out.println("\n===== Booking Queue =====");

        for (Reservation r : queue) {
            System.out.println(r.getGuestName() + " -> " + r.getRoomType());
        }
    }
}