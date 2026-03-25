import java.util.Scanner;
import java.util.List;

public class UseCase7AddOnServiceSelection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AddOnServiceManager manager = new AddOnServiceManager();

        // Sample services
        Service breakfast = new Service("Breakfast", 10);
        Service spa = new Service("Spa", 50);
        Service airportPickup = new Service("Airport Pickup", 30);

        Service[] availableServices = { breakfast, spa, airportPickup };

        System.out.print("Enter Reservation ID: ");
        String reservationId = sc.nextLine();

        System.out.println("Available Add-On Services:");
        for (int i = 0; i < availableServices.length; i++) {
            System.out.println((i + 1) + ". " + availableServices[i]);
        }

        System.out.println("Select services by number separated by spaces (e.g., 1 3):");
        String[] selections = sc.nextLine().split(" ");

        for (String sel : selections) {
            try {
                int idx = Integer.parseInt(sel) - 1;
                if (idx >= 0 && idx < availableServices.length) {
                    manager.addService(reservationId, availableServices[idx]);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: " + sel);
            }
        }

        List<Service> chosenServices = manager.getServices(reservationId);
        System.out.println("\nSelected services for Reservation " + reservationId + ":");
        chosenServices.forEach(s -> System.out.println("- " + s));

        System.out.println("Total additional cost: $" + manager.calculateTotalCost(reservationId));
    }
}