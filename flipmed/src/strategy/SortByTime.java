package src.strategy;

import src.model.Doctor;
import src.model.TimeDoctor;
import src.model.TimeSlot;

import java.util.Collections;
import java.util.List;

public class SortByTime extends SortByStrategy {
    @Override
    public void sort(List<TimeDoctor> doctorList) {
        doctorList.sort((a, b) -> a.getTimeSlot().start - b.getTimeSlot().end);
    }
}
