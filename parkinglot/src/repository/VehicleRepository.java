package src.repository;

import src.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    public  static List<Vehicle> vehicleList = new ArrayList<>();

    public static void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }
}
