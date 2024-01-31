package ParkingService;

public abstract class ParkingSpot {
    int id;
    protected boolean isAvailable;
    abstract int cost(Ticket ticket);
    abstract void setAvailability();
}
