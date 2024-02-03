package src.model;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Item {
    String id;
    String name;
    float price;

    public Item(String name, float price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
