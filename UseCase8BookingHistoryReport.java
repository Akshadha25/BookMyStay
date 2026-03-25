import java.util.Scanner;

public class UseCase8BookingHistoryReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookingHistory history = new BookingHistory();
        BookingReportService reportService = new BookingReportService();

        // Sample loop to simulate confirmed bookings
        while (true) {
            System.out.println("\n1. Add Confirmed Booking");
            System.out.println("2. Generate Booking Report");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Reservation ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Guest Name: ");
                    String guest = sc.nextLine();
                    System.out.print("Enter Room Type: ");
                    String room = sc.nextLine();

                    Reservation reservation = new Reservation(id, guest, room);
                    history.addReservation(reservation);
                    System.out.println("Booking confirmed and added to history!");
                    break;

                case 2:
                    reportService.generateReport(history);
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}