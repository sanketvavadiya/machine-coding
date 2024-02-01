package src.service;

import src.enums.Speciality;
import src.model.Doctor;
import src.model.TimeDoctor;
import src.model.TimeSlot;
import src.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    public static final DoctorService doctorService = new DoctorService();

    private DoctorService() {

    }

    public static DoctorService getInstance() {
        return  doctorService;
    }
    public Doctor addDoctor(String id, String name, Speciality speciality) {
        Doctor doctor = new Doctor(id, name, speciality);
        DoctorRepository.doctorMap.put(id, doctor);
        return doctor;
    }

    public boolean bookSlot(Doctor doctor, TimeSlot bookFor) {
        List<TimeSlot> slots = doctor.getSlotList();
        for(TimeSlot slot : slots) {
            if(slot.equals(bookFor) && slot.isBookable) {
                slot.isBookable = false;
                return true;
            }
        }
        return false;
    }

    public void addSlot(Doctor doctor, TimeSlot slot) {
        List<TimeSlot> slots = doctor.getSlotList();
        slots.add(slot);
    }


    public List<TimeDoctor> search(Speciality speciality) {
        List<TimeDoctor> availableSlots = new ArrayList<>();
        List<Doctor> doctors = DoctorRepository.getDoctorBySpeciality(speciality);
        for(Doctor doctor : doctors) {
            List<TimeSlot> slots = doctor.getSlotList();
            for(TimeSlot slot : slots)
                if(slot.isBookable)
                    availableSlots.add(new TimeDoctor(slot, doctor));
        }
        return availableSlots;
    }

    public List<TimeSlot> showSchedule(Doctor doctor) {
        return doctor.getSlotList();
    }

    public void cancelSlot(Doctor doctor, TimeSlot slot) {
        List<TimeSlot> timeSlots = doctor.getSlotList();
        for(TimeSlot timeSlot : timeSlots)
            if(timeSlot.equals(slot))
                timeSlot.isBookable = true;
    }
}
