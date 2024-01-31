package ParkingService;

public class Entrance {
    int id;
    Floor floor;
    Entrance(int id, Floor floor) {
        this.id = id;
        this.floor = floor;
    }

    boolean openEntrance(int id, Floor floor) {
        floor.setHasEntrance(true);
        return true;
    }

    boolean closeEntrance(int id, Floor floor) {
        floor.setHasEntrance(false);
        return true;
    }
}
