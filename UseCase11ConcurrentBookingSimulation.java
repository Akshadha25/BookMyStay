import java.util.*;

public class UseCase11ConcurrentBookingSimulation {
    public static void main(String[] args) throws InterruptedException {
        // Initial room inventory
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Single", 3);
        inventory.put("Double", 2);

        ConcurrentBookingProcessor processor = new ConcurrentBookingProcessor(inventory);

        // Simulate 5 concurrent booking requests
        String[] reservations = {"R101", "R102", "R103", "R104", "R105"};
        for(String res : reservations) {
            processor.submitBooking(res);
        }

        // Threads for processing
        Thread t1 = new Thread(() -> processor.processBookings("Single"));
        Thread t2 = new Thread(() -> processor.processBookings("Single"));
        Thread t3 = new Thread(() -> processor.processBookings("Double"));

        t1.start(); t2.start(); t3.start();
        t1.join(); t2.join(); t3.join();

        System.out.println("\nFinal Allocations:");
        processor.getAllocations().forEach((res, room) -> 
            System.out.println(res + " -> " + room)
        );

        System.out.println("\nRemaining Inventory:");
        inventory.forEach((room, count) -> 
            System.out.println(room + ": " + count)
        );
    }
}
