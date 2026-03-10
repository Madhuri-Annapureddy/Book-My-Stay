import java.util.HashMap;
import java.util.Map;

class Room {
    private String type;
    private double price;
    public Room(String type, double price) {
        this.type = type;
        this.price = price;
    }
    public String getType() { return type; }
    public double getPrice() { return price; }

    public void displayDetails() {
        System.out.println("Room Type: " + type + " | Price: $" + price);
    }
}

class RoomInventory {
    private Map<String, Integer> roomCounts = new HashMap<>();
    public void setAvailability(String type, int count) {
        roomCounts.put(type, count);
    }
    public Map<String, Integer> getRoomAvailability() {
        return new HashMap<>(roomCounts);
    }
}

class RoomSearchService {
    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {
        Map<String, Integer> availability = inventory.getRoomAvailability();
        if (availability.getOrDefault("Single", 0) > 0) {
            singleRoom.displayDetails();
            System.out.println("  Availability: " + availability.get("Single") + " remaining");
        }
        if (availability.getOrDefault("Double", 0) > 0) {
            doubleRoom.displayDetails();
            System.out.println("  Availability: " + availability.get("Double") + " remaining");
        }
        if (availability.getOrDefault("Suite", 0) > 0) {
            suiteRoom.displayDetails();
            System.out.println("  Availability: " + availability.get("Suite") + " remaining");
        }
    }
}

public class HotelBookingApp {
    public static void main(String[] args) {
        Room single = new Room("Single", 100.0);
        Room doubleR = new Room("Double", 150.0);
        Room suite = new Room("Suite", 300.0);

        RoomInventory inventory = new RoomInventory();
        inventory.setAvailability("Single", 8);
        inventory.setAvailability("Double", 3);
        inventory.setAvailability("Suite", 0); // Not available, should not be displayed

        RoomSearchService searchService = new RoomSearchService();

        System.out.println("Executing Use Case 4: Room Search...");
        searchService.searchAvailableRooms(inventory, single, doubleR, suite);
    }
}