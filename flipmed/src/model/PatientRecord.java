package src.model;

import src.enums.AppointmentStatus;

public class PatientRecord {
    Patient patient;
    TimeSlot slot;
    AppointmentStatus appointmentStatus;
    Doctor doctor;

    public PatientRecord(Patient patient, TimeSlot slot, AppointmentStatus appointmentStatus, Doctor doctor) {
        this.patient = patient;
        this.slot = slot;
        this.appointmentStatus = appointmentStatus;
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public TimeSlot getSlot() {
        return slot;
    }

    public void setSlot(TimeSlot slot) {
        this.slot = slot;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
