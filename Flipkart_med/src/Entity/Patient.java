package Entity;

public class Patient {
    int patientId;
    String patientName;

    public Patient(int patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getPatientId() {
        return patientId;
    }
}
