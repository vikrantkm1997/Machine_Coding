package Manager;

import Entity.Patient;
import Exceptions.PatientNotFound;
import IDGenerator.IDGenerator;

import java.util.HashMap;
import java.util.Map;

public class PatientManager {

    private Map<Integer, Patient> idToPatientMap;
    private IDGenerator idGenerator;

    private PatientManager()
    {
        this.idToPatientMap = new HashMap<>();
    }

    private static PatientManager patientManagerInstance;

    public static PatientManager getPatientManagerInstance()
    {
        if (patientManagerInstance == null)
        {
            patientManagerInstance = new PatientManager();
        }
        return patientManagerInstance;
    }

    public Patient getPatient(int patientId) {
        if(idToPatientMap.containsKey(patientId))
            return idToPatientMap.get(patientId);
        else
            throw new PatientNotFound(patientId);
    }

    public Patient registerNewPatient(String patientName)
    {
        int patId = IDGenerator.getPatientId();
        Patient patient = new Patient(patId, patientName);
        idToPatientMap.put(patId, patient);
        System.out.println(patientName+" registered Succesfully");
        return patient;
    }

    public Map<Integer, Patient> getIdToPatientMap() {
        return idToPatientMap;
    }

    public Patient getPatientByName(String patName) {
        return idToPatientMap.values()
            .stream()
            .filter(patient -> patient.getPatientName().equals(patName))
            .findFirst()
            .orElse(null);
    }
}
