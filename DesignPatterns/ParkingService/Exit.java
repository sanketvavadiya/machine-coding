package ParkingService;

public class Exit {
    int id;
    Floor floor;
    Exit(int id, Floor floor) {
        this.id = id;
        this.floor = floor;
    }

    boolean openExit(int id, Floor floor) {
        floor.setHasExit(true);
        return true;
    }

    boolean closeExit(int id, Floor floor) {
        floor.setHasExit(false);
        return true;
    }
}
