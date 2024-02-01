package src.service;

import src.enums.AppointmentStatus;
import src.enums.Speciality;
import src.exception.InvalidSlot;
import src.model.*;
import src.repository.PatientRecordRepository;
import src.repository.PatientRepository;
import src.strategy.SortByStrategy;

import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private DoctorService doctorService = DoctorService.getInstance();
    private static final PatientService patientService = new PatientService();

    private PatientService() {

    }

    public static PatientService getInstance() {
        return  patientService;
    }

    public Patient register(String id, String name) {
        Patient patient = new Patient(id, name);
        PatientRepository.patientMap.put(id, patient);
        return patient;
    }

    public void bookSlot(Patient patient, Doctor doctor, TimeSlot slot) throws Exception {
        if(hasAlreadyBooked(patient, slot))
            throw new InvalidSlot("Aloready booked");
        PatientRecord patientRecord = new PatientRecord(patient, slot, AppointmentStatus.WAITING, doctor);
        if(doctorService.bookSlot(doctor, slot)) {
            // book appointment
            patientRecord.setAppointmentStatus(AppointmentStatus.BOOKED);
            PatientRecordRepository.patientSheet.add(patientRecord);
            System.out.println("booked for: " + patient.getId() + " with doctor: " + doctor.getId() + " for slot " + slot.start + " to " + slot.end);
            return;
        }
        throw new InvalidSlot("Doctor unavailable");
    }

    public List<TimeDoctor> search(Speciality speciality, SortByStrategy sortByStrategy) {
        List<TimeDoctor> doctors = doctorService.search(speciality);
        sortByStrategy.sort(doctors);
        return doctors;
    }

    public boolean cancelSlot(Patient patient, TimeSlot slot) throws InvalidSlot {
        PatientRecord patientRecord = PatientRecordRepository.getPendingSlot(patient, slot);
        if(patientRecord != null) {
            patientRecord.setAppointmentStatus(AppointmentStatus.CANCELLED);
            doctorService.cancelSlot(patientRecord.getDoctor(), slot);
            System.out.println("Cancelled for: " + patient.getId() + " slot from: " + slot.start + " end " + slot.end);
            return true;
        }
        throw new InvalidSlot("No slots found");
    }

    public List<TimeDoctor> showAllBookings(Patient patient) {
        List<PatientRecord> patientRecords = PatientRecordRepository.getAllRecords(patient);
        List<TimeDoctor> res = new ArrayList<>();
        for(PatientRecord patientRecord : patientRecords) {
            TimeSlot slot = patientRecord.getSlot();
            Doctor doctor = patientRecord.getDoctor();
            res.add(new TimeDoctor(slot, doctor));
        }
        return res;
    }

    private boolean hasAlreadyBooked(Patient patient, TimeSlot slot) {
        List<TimeSlot> slots = PatientRecordRepository.getAllBookedSlots(patient);
        for(TimeSlot bookedSlot : slots) {
            if(bookedSlot.overlaps(slot))
                return true;
        }
        return false;
    }
}
