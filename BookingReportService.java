import java.util.List;

public class BookingReportService {

    public void generateReport(BookingHistory history) {
        List<Reservation> reservations = history.getAllReservations();
        System.out.println("===== Booking Report =====");
        if (reservations.isEmpty()) {
            System.out.println("No confirmed bookings yet.");
        } else {
            for (Reservation res : reservations) {
                System.out.println(res);
            }
            System.out.println("Total confirmed bookings: " + reservations.size());
        }
        System.out.println("==========================");
    }
}