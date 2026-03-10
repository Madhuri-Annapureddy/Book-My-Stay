import java.util.HashMap;
import java.util.Map;

abstract class Room {
    protected int noOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int beds, int size, double price) {
        this.noOfBeds = beds;
        this.squareFeet = size;
        this.pricePerNight = price;
    }

    public int getBeds() {
        return noOfBeds;
    }

    public int getSize() {
        return squareFeet;
    }

    public double getPrice() {
        return pricePerNight;
    }
}

class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public int getAvailability(String roomType) {
        return roomAvailability.get(roomType);
    }
}

public class HotelBookingApp {

    public static void main(String[] args) {

        SingleRoom single = new SingleRoom();
        DoubleRoom dbl = new DoubleRoom();
        SuiteRoom suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();

        System.out.println("Hotel Room Inventory Status\n");

        System.out.println("Single Room:");
        System.out.println("Beds: " + single.getBeds());
        System.out.println("Size: " + single.getSize() + " sqft");
        System.out.println("Price per night: " + single.getPrice());
        System.out.println("Available Rooms: " + inventory.getAvailability("Single"));

        System.out.println();

        System.out.println("Double Room:");
        System.out.println("Beds: " + dbl.getBeds());
        System.out.println("Size: " + dbl.getSize() + " sqft");
        System.out.println("Price per night: " + dbl.getPrice());
        System.out.println("Available Rooms: " + inventory.getAvailability("Double"));

        System.out.println();

        System.out.println("Suite Room:");
        System.out.println("Beds: " + suite.getBeds());
        System.out.println("Size: " + suite.getSize() + " sqft");
        System.out.println("Price per night: " + suite.getPrice());
        System.out.println("Available Rooms: " + inventory.getAvailability("Suite"));
    }
}