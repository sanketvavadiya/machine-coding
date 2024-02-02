package src.model;

public class Ticket {
    Vehicle vehicle;
    Slot slot;
    boolean isPaid;

    public Ticket(Vehicle vehicle, Slot slot) {
        this.vehicle = vehicle;
        this.slot = slot;
        this.isPaid = false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
