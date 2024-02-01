package src.repository;

import src.model.Patient;

import java.util.HashMap;
import java.util.Map;

public class PatientRepository {
    public static Map<String, Patient> patientMap = new HashMap<>();

    public void addPatient(Patient patient) {
        patientMap.put(patient.getId(), patient);
    }
    public void removePatient(Patient patient) {
        patientMap.remove(patient.getId());
    }
}
