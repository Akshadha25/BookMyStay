import java.util.Scanner;

public class UseCase9ErrorHandlingValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoomInventory inventory = new RoomInventory();
        BookingValidator validator = new BookingValidator();

        while (true) {
            System.out.println("\n1. Make Booking");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 2) {
                System.out.println("Exiting...");
                break;
            }

            System.out.print("Enter Reservation ID: ");
            String reservationId = sc.nextLine();

            System.out.print("Enter Guest Name: ");
            String guestName = sc.nextLine();

            System.out.print("Enter Room Type (Single Room, Double Room, Suite): ");
            String roomType = sc.nextLine();

            try {
                int availableRooms = inventory.getAvailableRooms(roomType);
                validator.validateReservation(reservationId, guestName, roomType, availableRooms);

                Reservation reservation = new Reservation(reservationId, guestName, roomType);
                inventory.bookRoom(roomType);
                System.out.println("Booking successful: " + reservation);

            } catch (InvalidBookingException e) {
                System.out.println("Booking failed: " + e.getMessage());
            }
        }

        sc.close();
    }
}