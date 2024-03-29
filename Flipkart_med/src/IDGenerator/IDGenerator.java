package IDGenerator;

public class IDGenerator {
    public static int doctorId = 0;
    public static int patientId = 0;

    public static int bookingId = 0;

    public static int getDoctorId() {
        return ++doctorId;
    }

    public static int getPatientId() {
        return ++patientId;
    }

    public static int getBookingId() {
        return ++bookingId;
    }
}
