import java.util.HashMap;
import java.util.Map;

public class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite", 2);
    }

    public int getAvailableRooms(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void bookRoom(String roomType) {
        inventory.put(roomType, inventory.get(roomType) - 1);
    }
}