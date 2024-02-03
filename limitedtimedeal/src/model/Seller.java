package src.model;

import java.util.List;
import java.util.UUID;

public class Seller {
    String id;
    String name;
    List<Item> items;

    public Seller(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

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
}
