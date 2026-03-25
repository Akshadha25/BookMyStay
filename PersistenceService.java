import java.io.*;

public class PersistenceService {

    private static final String FILE_NAME = "system_state.ser";

    public static void saveState(BookingHistory history, RoomInventory inventory) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(history);
            out.writeObject(inventory);
            System.out.println("System state saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving system state: " + e.getMessage());
        }
    }

    public static Object[] loadState() {
        BookingHistory history = new BookingHistory();
        RoomInventory inventory = new RoomInventory();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            history = (BookingHistory) in.readObject();
            inventory = (RoomInventory) in.readObject();
            System.out.println("System state loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No previous state found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading system state: " + e.getMessage());
        }

        return new Object[]{history, inventory};
    }
}