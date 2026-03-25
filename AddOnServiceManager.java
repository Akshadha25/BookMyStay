import java.util.*;

public class AddOnServiceManager {
    // Maps reservation ID to a list of selected services
    private Map<String, List<Service>> reservationServices;

    public AddOnServiceManager() {
        reservationServices = new HashMap<>();
    }

    // Add a service to a reservation
    public void addService(String reservationId, Service service) {
        reservationServices.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
    }

    // Get all services for a reservation
    public List<Service> getServices(String reservationId) {
        return reservationServices.getOrDefault(reservationId, Collections.emptyList());
    }

    // Calculate total additional cost
    public double calculateTotalCost(String reservationId) {
        return getServices(reservationId).stream()
                .mapToDouble(Service::getCost)
                .sum();
    }
}

