public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("===== Welcome to Book My Stay =====");

        Room single = new SingleRoom();
        Room doub = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("\n--- Single Room ---");
        single.displayRoomDetails();
        System.out.println("Available : " + singleAvailable);

        System.out.println("\n--- Double Room ---");
        doub.displayRoomDetails();
        System.out.println("Available : " + doubleAvailable);

        System.out.println("\n--- Suite Room ---");
        suite.displayRoomDetails();
        System.out.println("Available : " + suiteAvailable);

        System.out.println("\nSystem Ready...");
    }
}

abstract class Room {

    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Beds : " + numberOfBeds);
        System.out.println("Size : " + squareFeet + " sq.ft");
        System.out.println("Price : ₹" + pricePerNight);
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