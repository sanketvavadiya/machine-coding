package src.model;

import java.util.List;
import java.util.UUID;

public class Deal {
    String id;
    TimeSlot timeSlot;
    Item item;
    float dealPrice;
    int maxAllowed;
    boolean isActive;
    Seller seller;

    public Deal(Seller seller, TimeSlot timeSlot, Item item, float dealPrice, int maxAllowed) {
        this.id = UUID.randomUUID().toString();
        this.seller = seller;
        this.timeSlot = timeSlot;
        this.item = item;
        this.dealPrice = dealPrice;
        this.maxAllowed = maxAllowed;
        this.isActive = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Item getItem() {
        return item;
    }

    public int getMaxAllowed() {
        return maxAllowed;
    }

    public void setMaxAllowed(int maxAllowed) {
        this.maxAllowed = maxAllowed;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public float getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(float dealPrice) {
        this.dealPrice = dealPrice;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
