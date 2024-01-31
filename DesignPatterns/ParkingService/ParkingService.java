package ParkingService;

import java.util.HashSet;
import java.util.Set;

public class ParkingService {
    Floor floor1 = new Floor(1);
    Floor floor2 = new Floor(2);
    Floor floor3 = new Floor(3);
    Floor floor4 = new Floor(4);
    Entrance entrance1 = new Entrance(1, floor1);
    Entrance entrance2 = new Entrance(2, floor2);
    Entrance entrance3 = new Entrance(4, floor4);
    Set<Entrance> entrances;
    Set<Floor> floors;
    Set<Exit> exits;
    ParkingService() {
        entrances = new HashSet<Entrance>();
        floors = new HashSet<Floor>();
        exits = new HashSet<Exit>();
    }

    public void addEntrance(Floor floor) {
        if(floors.contains(floor))
                floor.setHasEntrance(true);
    }

    public void removeEntrance(Floor floor) {
        if(floors.contains(floor))
            floor.setHasEntrance(false);
    }

    public  void addExit(Floor floor) {
        if(floors.contains(floor))
            floor.setHasExit(true);
    }

    public void removeExit(Floor floor) {
        if(floors.contains(floor))
            floor.setHasExit(false);
    }

    public Ticket generateTicket(Floor floor, String carType, FindSpotStrategy findSpotStrategy) {
        if(floor.hasEntrance) {
            Ticket ticket = floor.generateTicket(carType, findSpotStrategy);
            ticket.spot.setAvailability();
            return ticket;
        }
        return null;
    }

    public int calculateCost(Ticket ticket) {
        int charge = ticket.spot.cost(ticket);
        ticket.spot.setAvailability();
        return charge;
    }
}
