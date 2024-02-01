package src.strategy;

import src.model.Doctor;
import src.model.TimeDoctor;
import src.model.TimeSlot;

import java.util.List;

public abstract class SortByStrategy {
    public abstract void sort(List<TimeDoctor> doctorList);
}
