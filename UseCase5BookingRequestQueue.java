public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        BookingQueue queue = new BookingQueue();

        // Simulating booking requests
        queue.addRequest(new Reservation("Alice", "Single Room"));
        queue.addRequest(new Reservation("Bob", "Double Room"));
        queue.addRequest(new Reservation("Charlie", "Suite Room"));

        // Display queue
        queue.displayQueue();
    }
}