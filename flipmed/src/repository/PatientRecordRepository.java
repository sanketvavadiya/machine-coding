package src.repository;

import src.enums.AppointmentStatus;
import src.model.Doctor;
import src.model.Patient;
import src.model.PatientRecord;
import src.model.TimeSlot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PatientRecordRepository {
    public static Set<PatientRecord> patientSheet = new HashSet<>();

    public static List<TimeSlot> getAllBookedSlots(Patient patient) {
        List<TimeSlot> bookedSlot = new ArrayList<>();
        for(PatientRecord patientRecord : patientSheet) {
            Patient curPatient = patientRecord.getPatient();
            if(curPatient == patient && patientRecord.getAppointmentStatus().equals(AppointmentStatus.BOOKED)) {
                bookedSlot.add(patientRecord.getSlot());
            }
        }
        return bookedSlot;
    }

    public static PatientRecord getPendingSlot(Patient patient, TimeSlot slot) {
        for(PatientRecord patientRecord : patientSheet) {
            Patient curPatient = patientRecord.getPatient();
            if(curPatient == patient
                    && (patientRecord.getAppointmentStatus().equals(AppointmentStatus.BOOKED)
                    || patientRecord.getAppointmentStatus().equals(AppointmentStatus.WAITING))
                    && slot.equals(patientRecord.getSlot())) {
                return patientRecord;
            }
        }
        return null;
    }

    public static List<PatientRecord> getAllRecords(Patient patient) {
        List<PatientRecord> patientRecords = new ArrayList<>();
        for(PatientRecord patientRecord : patientSheet) {
            if(patient == patientRecord.getPatient())
                patientRecords.add(patientRecord);
        }
        return  patientRecords;
    }

    public void addPatientRecord(Patient patient, Doctor doctor, TimeSlot timeSlot, AppointmentStatus appointmentStatus) {
        patientSheet.add(new PatientRecord(patient, timeSlot, appointmentStatus, doctor));
    }
}
