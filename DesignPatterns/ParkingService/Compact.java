package ParkingService;

public class Compact extends ParkingSpot{
    @Override
    int cost(Ticket ticket) {
        return (ticket.outTime - ticket.inTime) * 20;
    }

    @Override
    void setAvailability() {

    }
}
