package src.repository;

import src.model.Ticket;
import src.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    public static Map<String, Ticket> ticketMap = new HashMap<>();

    public static void createTicket(Ticket ticket) {
        Vehicle vehicle = ticket.getVehicle();
        ticketMap.put(vehicle.getNumber()+vehicle.getColor(), ticket);
    }
}
