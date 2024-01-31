package ParkingService;

public class Large extends ParkingSpot{
    @Override
    int cost(Ticket ticket) {
        return (ticket.outTime - ticket.inTime) * 30;
    }

    @Override
    void setAvailability() {

    }
}
