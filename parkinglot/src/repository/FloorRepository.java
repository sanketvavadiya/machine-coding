package src.repository;

import src.model.Floor;

import java.util.ArrayList;
import java.util.List;

public class FloorRepository {
    public static List<Floor> floors = new ArrayList<>();

    public static void addNFloor(int n, int slots) {
        for(int i=0 ; i<n ; i++)
            floors.add(new Floor(i+1, 1, 2, slots-3));
    }

    public static void addFloor(int slots) {
            floors.add(new Floor(floors.size(), 1, 2, slots-3));
    }

    public static Floor getFloor(int floor) {
        return floors.get(floor-1);
    }
}
