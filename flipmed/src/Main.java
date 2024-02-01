package src;

import src.enums.Speciality;
import src.model.Doctor;
import src.model.Patient;
import src.model.TimeSlot;
import src.service.DoctorService;
import src.service.PatientService;
import src.strategy.SortByTime;

public class Main {
    public static  void main(String[] args) throws Exception {
        DoctorService doctorService = DoctorService.getInstance();
        PatientService patientService = PatientService.getInstance();

        Doctor d1 = doctorService.addDoctor("d1", "d1", Speciality.Cardiologist);
        Doctor d5 = doctorService.addDoctor("d4", "d4", Speciality.Cardiologist);
        Doctor d2 = doctorService.addDoctor("d2", "d2", Speciality.Orthopedic);
        Doctor d3 = doctorService.addDoctor("d3", "d3", Speciality.Dermatologist);
        Doctor d4 = doctorService.addDoctor("d5", "d5", Speciality.GeneralPhysician);

        Patient p1 = patientService.register("p1", "p1");
        Patient p2 = patientService.register("p2", "p2");

        doctorService.addSlot(d1, new TimeSlot(900, 930));
        doctorService.addSlot(d2, new TimeSlot(1230, 1300));
        doctorService.addSlot(d1, new TimeSlot(930, 1000));
        doctorService.addSlot(d2, new TimeSlot(1500, 1530));
        doctorService.addSlot(d3, new TimeSlot(900, 930));

        patientService.bookSlot(p1, d1, new TimeSlot(900, 930));
//        patientService.bookSlot(p2, d1, new TimeSlot(900, 930));
//        patientService.bookSlot(p1, d2, new TimeSlot(900, 930));
//        patientService.bookSlot(p1, d3, new TimeSlot(1000, 1030));

        patientService.cancelSlot(p1, new TimeSlot(900, 930));
        patientService.bookSlot(p1, d3, new TimeSlot(900, 930));

        patientService.showAllBookings(p1);
        doctorService.showSchedule(d1);

        patientService.search(Speciality.Cardiologist, new SortByTime());
    }
}
