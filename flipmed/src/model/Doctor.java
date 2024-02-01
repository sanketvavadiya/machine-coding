package src.model;

import src.enums.Speciality;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    String id;
    String name;
    Speciality speciality;
    List<TimeSlot> slotList;

    public Doctor(String id, String name, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.slotList = new ArrayList<>();
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<TimeSlot> getSlotList() {
        return slotList;
    }

    public void setSlotList(List<TimeSlot> slotList) {
        this.slotList = slotList;
    }
}
