package src.model;

public class Player {
    String name;
    int position;
    boolean status;

    public Player(String name) {
        this.name = name;
        position = 0;
        status = false;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isStatus() {
        return status;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
