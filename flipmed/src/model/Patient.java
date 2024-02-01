package src.model;

public class Patient {
    String id;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
