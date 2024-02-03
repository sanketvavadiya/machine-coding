package src.model;

import java.util.UUID;

public class Buyer {
    String id;
    String name;
    String address;
    String contactNumber;

    public Buyer(String name, String address, String contactNumber) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
