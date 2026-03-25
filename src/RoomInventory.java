import java.util.HashMap;

public class RoomInventory {

    private HashMap<String, Integer> inventory;

    // Constructor
    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Add room type with count
    public void addRoom(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Get availability
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability
    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    // Display inventory
    public void displayInventory() {
        System.out.println("=== Current Inventory ===");
        for (String type : inventory.keySet()) {
            System.out.println(type + " : " + inventory.get(type));
        }
    }
}