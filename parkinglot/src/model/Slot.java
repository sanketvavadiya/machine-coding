package src.model;

public class Slot implements Comparable<Slot> {
    int number;
    int floor;
    boolean isAvailable;

    public Slot(int number, int floor, boolean isAvailable) {
        this.number = number;
        this.floor = floor;
        this.isAvailable = isAvailable;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public int compareTo(Slot o) {
        return Integer.compare(getNumber(), o.getNumber());
    }
}
