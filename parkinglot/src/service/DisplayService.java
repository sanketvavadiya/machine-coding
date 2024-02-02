package src.service;

import src.enums.CommandType;
import src.enums.DisplayCommand;
import src.enums.VehicleType;
import src.model.Floor;
import src.repository.FloorRepository;

public class DisplayService {
    private static  final DisplayService displayService =  new DisplayService();

    private DisplayService() {

    }

    public static DisplayService getInstance() {
        return displayService;
    }

    public static void display(DisplayCommand command, VehicleType vehilcleType, int floor) {
        if(vehilcleType.equals(VehicleType.CAR))
            displayCarSlots(command, floor);
        else if (vehilcleType.equals(VehicleType.BIKE))
            displayBikeSlots(command, floor);
        else if (vehilcleType.equals(VehicleType.TRUCK))
            displayTruckSlots(command, floor);
    }

    private static void displayBikeSlots(DisplayCommand command, int floorNumber) {
        Floor floor = FloorRepository.getFloor(floorNumber);
        if(command.equals(DisplayCommand.FREE_COUNT)) {
            System.out.println("No. of free slots for BIKE on Floor " + floorNumber + ": " + floor.getBikeSlots().size());
        } else if (command.equals(DisplayCommand.OCCUPIED_SLOTS)) {
            System.out.println("No. of free slots for BIKE on Floor " + floorNumber + ": " + (floor.getCars() - floor.getBikeSlots().size()));
        }
    }

    private static void displayCarSlots(DisplayCommand displayCommand, int floorNumber) {
        Floor floor = FloorRepository.getFloor(floorNumber);
        if(displayCommand.equals(DisplayCommand.FREE_COUNT)) {
            System.out.println("No. of free slots for CAR on Floor " + floorNumber + ": " + floor.getCarSlots().size());
        } else if (displayCommand.equals(DisplayCommand.OCCUPIED_SLOTS)) {
            System.out.println("No. of free slots for CAR on Floor " + floorNumber + ": " + (floor.getCars() - floor.getCarSlots().size()));
        }
        else {
            System.out.println("No display command found");
        }
    }

    private static void displayTruckSlots(DisplayCommand command, int floorNumber) {
        Floor floor = FloorRepository.getFloor(floorNumber);
        if(command.equals(DisplayCommand.FREE_COUNT)) {
            System.out.println("No. of free slots for TRUCK on Floor " + floorNumber + ": " + floor.getTruckSlots().size());
        } else if (command.equals(DisplayCommand.OCCUPIED_SLOTS)) {
            System.out.println("No. of free slots for TRUCK on Floor " + floorNumber + ": " + (floor.getCars() - floor.getTruckSlots().size()));
        }
    }
}
