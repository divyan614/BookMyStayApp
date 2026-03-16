import java.util.HashMap;
import java.util.Map;

public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== Hotel Room Inventory Status =====");

        // Room objects (domain model)
        Room single = new SingleRoom();
        Room doub = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Centralized Inventory
        RoomInventory inventory = new RoomInventory();

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("\nSingle Room:");
        single.displayRoomDetails();
        System.out.println("Available Rooms: " + availability.get("Single"));

        System.out.println("\nDouble Room:");
        doub.displayRoomDetails();
        System.out.println("Available Rooms: " + availability.get("Double"));

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();
        System.out.println("Available Rooms: " + availability.get("Suite"));
    }
}

/* ================= DOMAIN MODEL ================= */

abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int beds, int size, double price) {
        this.numberOfBeds = beds;
        this.squareFeet = size;
        this.pricePerNight = price;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
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

/* ================= INVENTORY CLASS ================= */

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

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}