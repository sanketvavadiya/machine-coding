package src.model;

public class TimeDoctor {
    TimeSlot timeSlot;
    Doctor doctor;

    public TimeDoctor(TimeSlot timeSlot, Doctor doctor) {
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
