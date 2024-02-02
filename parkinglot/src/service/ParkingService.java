package src.service;

import src.enums.CommandType;
import src.enums.VehicleType;
import src.model.Floor;
import src.model.Slot;
import src.model.Ticket;
import src.model.Vehicle;
import src.repository.FloorRepository;
import src.repository.TicketRepository;

public class ParkingService {
    public static ParkingService parkingService = new ParkingService();

    private ParkingService() {

    }

    public static ParkingService getInstance() {
        return parkingService;
    }

    public String park(String type, String number, String color) {
        Ticket ticket = switch (VehicleType.valueOf(type)) {
            case VehicleType.CAR -> parkCar(number, color);
            case VehicleType.BIKE -> parkBike(number, color);
            case VehicleType.TRUCK -> parkTruck(number, color);
            default -> null;
        };
        return ticket != null ? ticket.getVehicle().getNumber()+ticket.getVehicle().getNumber() : "Parking is full";
    }

    public void unPark(String ticketId) {
        Ticket ticket = TicketRepository.ticketMap.get(ticketId);
        Vehicle vehicle = ticket.getVehicle();
        Slot slot = ticket.getSlot();
        if(TicketRepository.ticketMap.containsKey(vehicle.getNumber() + vehicle.getColor())) {
            ticket.setPaid(true);
            int floorNumber = slot.getFloor();
            Floor floor = FloorRepository.getFloor(floorNumber);
            switch (vehicle.getType()) {
                case CAR -> floor.addCarSlot(slot);
                case BIKE -> floor.addBikeSlot(slot);
                case TRUCK -> floor.addTruckSlot(slot);
            }
        }
        else
            System.out.println("Invalid ticket");
    }

    private Ticket parkTruck(String number, String color) {
        if(isAvailable(VehicleType.TRUCK)) {
            Vehicle vehicle = new Vehicle(VehicleType.TRUCK, number, color);
            Slot slot = getNearestSlot(VehicleType.TRUCK);
            return new Ticket(vehicle, slot);
        }
        return null;
    }

    private Ticket parkBike(String number, String color) {
        if(isAvailable(VehicleType.BIKE)) {
            Vehicle vehicle = new Vehicle(VehicleType.BIKE, number, color);
            Slot slot = getNearestSlot(VehicleType.BIKE);
            return new Ticket(vehicle, slot);
        }
        return null;
    }

    private Ticket parkCar(String number, String color) {
        if(isAvailable(VehicleType.CAR)) {
            Vehicle vehicle = new Vehicle(VehicleType.CAR, number, color);
            Slot slot = getNearestSlot(VehicleType.CAR);
            Ticket ticket = new Ticket(vehicle, slot);
            TicketRepository.createTicket(ticket);
            return ticket;
        }
        return null;
    }

    private boolean isAvailable(VehicleType vehicleType) {
        for(Floor floor : FloorRepository.floors) {
            if(vehicleType.equals(VehicleType.CAR) && !floor.getCarSlots().isEmpty())
                return true;
            if(vehicleType.equals(VehicleType.BIKE) && !floor.getBikeSlots().isEmpty())
                return true;
            if(vehicleType.equals(VehicleType.TRUCK) && !floor.getTruckSlots().isEmpty())
                return true;
        }
        return false;
    }

    private Slot getNearestSlot(VehicleType vehiclType) {
        for(Floor floor : FloorRepository.floors) {
            if(vehiclType.equals(VehicleType.CAR) && !floor.getCarSlots().isEmpty()) {
                return floor.removeCarSlot();
            }
            if(vehiclType.equals(VehicleType.BIKE) && !floor.getBikeSlots().isEmpty()) {
                return floor.removeBikeSlot();
            }
            if(vehiclType.equals(VehicleType.TRUCK) && !floor.getTruckSlots().isEmpty()) {
                return floor.removeTruckSlot();
            }
        }
        return null;
    }
}
