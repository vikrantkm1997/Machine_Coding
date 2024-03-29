package Manager;

import Entity.Doctor;
import Enums.Speciality;
import Exceptions.DoctorNotFoundException;
import IDGenerator.IDGenerator;

import java.util.HashMap;
import java.util.Map;

public class DoctorManager {
    private Map<Integer, Doctor> idToDoctorMap;

    private IDGenerator idGenerator;
    private static DoctorManager doctorManager;

    private DoctorManager() {
        idToDoctorMap = new HashMap<>();
    }

    public static DoctorManager getDriverManagerInstance(){
        if(doctorManager == null)
        {
            doctorManager = new DoctorManager();
        }
        return doctorManager;
    }

    public Doctor addDoctor(String name, Speciality speciality) {
        int docId = IDGenerator.getDoctorId();
        Doctor doctor = new Doctor(docId, name, speciality);
        idToDoctorMap.put(docId, doctor);
        System.out.println("Welcome ."+name);
        return doctor;
    }

    public Doctor getDoctor(int docId) {
        if(idToDoctorMap.containsKey(docId))
            return idToDoctorMap.get(docId);
        else
            throw new DoctorNotFoundException("Doctor id Not present in Db");
    }

    public Map<Integer, Doctor> getIdToDoctorMap() {
        return idToDoctorMap;
    }

    public Doctor getDoctorByName(String docName) {
        return idToDoctorMap.values()
            .stream()
            .filter(doc -> doc.getName().equals(docName))
            .findFirst()
            .orElse(null);
    }
}
