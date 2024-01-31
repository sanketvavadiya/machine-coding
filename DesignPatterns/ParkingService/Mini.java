package ParkingService;

public class Mini extends ParkingSpot{
    @Override
    int cost(Ticket ticket) {
        return (ticket.outTime - ticket.inTime) * 10;
    }

    @Override
    void setAvailability() {

    }
}
