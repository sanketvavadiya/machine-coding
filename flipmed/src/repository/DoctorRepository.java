package src.repository;

import src.enums.Speciality;
import src.model.Doctor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorRepository {
    public static Map<String, Doctor> doctorMap = new HashMap<>();

    public static void addDoctor(Doctor doctor) {
        doctorMap.put(doctor.getId(), doctor);
    }

    public static List<Doctor> getDoctorBySpeciality(Speciality speciality) {
        List<Doctor> doctors = new ArrayList<>();
        for(Map.Entry<String, Doctor> it : doctorMap.entrySet()) {
            Speciality currSpeciality = it.getValue().getSpeciality();
            if(currSpeciality.equals(speciality))
                doctors.add(it.getValue());
        }
        return doctors;
    }
}
