package src.model;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Floor {
    int floorNumber;
    int trucks;
    int bikes;
    int cars;
    PriorityQueue<Slot> carSlots;
    PriorityQueue<Slot> bikeSlots;
    PriorityQueue<Slot> truckSlots;

    public Floor(int floorNumber, int trucks, int bikes, int cars) {
        this.floorNumber = floorNumber;
        this.trucks = trucks;
        this.bikes = bikes;
        this.cars = cars;
        this.carSlots = new PriorityQueue<>();
        this.bikeSlots = new PriorityQueue<>();
        this.truckSlots = new PriorityQueue<>();
        fillSlots();
    }

    private void fillSlots() {
        int i = 1;
        for(; i<=trucks ; i++)
            truckSlots.add(new Slot(i, this.floorNumber, true));
        for(; i<=trucks+bikes ; i++)
            bikeSlots.add(new Slot(i, this.floorNumber, true));
        for(; i<=trucks+bikes+cars ; i++)
            carSlots.add(new Slot(i, this.floorNumber, true));
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getTrucks() {
        return trucks;
    }

    public void setTrucks(int trucks) {
        this.trucks = trucks;
    }

    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }

    public int getCars() {
        return cars;
    }

    public void setCars(int cars) {
        this.cars = cars;
    }

    public PriorityQueue<Slot> getCarSlots() {
        return carSlots;
    }

    public void setCarSlots(PriorityQueue<Slot> carSlots) {
        this.carSlots = carSlots;
    }

    public PriorityQueue<Slot> getBikeSlots() {
        return bikeSlots;
    }

    public void setBikeSlots(PriorityQueue<Slot> bikeSlots) {
        this.bikeSlots = bikeSlots;
    }

    public PriorityQueue<Slot> getTruckSlots() {
        return truckSlots;
    }

    public void setTruckSlots(PriorityQueue<Slot> truckSlots) {
        this.truckSlots = truckSlots;
    }

    public Slot removeCarSlot() {
        return carSlots.remove();
    }

    public Slot removeBikeSlot() {
        return bikeSlots.remove();
    }

    public Slot removeTruckSlot() {
        return truckSlots.remove();
    }

    public void addCarSlot(Slot slot) {
        carSlots.add(slot);
    }

    public void addBikeSlot(Slot slot) {
        bikeSlots.add(slot);
    }

    public void addTruckSlot(Slot slot) {
        truckSlots.add(slot);
    }
}
