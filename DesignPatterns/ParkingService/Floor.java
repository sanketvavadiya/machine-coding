package ParkingService;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    int floorNumber;
    boolean hasEntrance;
    boolean hasExit;
    List<ParkingSpot> miniList;
    List<ParkingSpot> compactList;
    List<ParkingSpot> largeList;
    Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        miniList = new ArrayList<>();
        compactList = new ArrayList<>();
        largeList = new ArrayList<>();
    }

    public void setHasEntrance(boolean hasEntrance) {
        this.hasEntrance = hasEntrance;
    }

    public void setHasExit(boolean hasExit) {
        this.hasExit = hasExit;
    }

    public void addMiniSpot(Mini mini) {
        miniList.add(mini);
    }

    public void addCompactSpot(Compact compact) {
        compactList.add(compact);
    }

    public void addLargeSpot(Large large) {
        largeList.add(large);
    }

    public Ticket generateTicket(String carType, FindSpotStrategy findSpotStrategy) {
        if(carType.equals("mini"))
            findSpotStrategy.findSpot(this);
        else if(carType.equals("compact"))
            findSpotStrategy.findSpot(this);
        else
            findSpotStrategy.findSpot(this);
        return new Ticket();
    }
}
