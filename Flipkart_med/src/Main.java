import Enums.Speciality;

import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        FlipMedDriverClass flipMedDriverClass = new FlipMedDriverClass();
        flipMedDriverClass.registerDoctor("Dr. Curious", Speciality.CARDIOLOGIST);
        Thread.sleep(1000);
        flipMedDriverClass.markDocAvail("Dr. Curious", Map.of(900, 1030));
        Thread.sleep(1000);
        flipMedDriverClass.markDocAvail("Dr. Curious", Map.of(900, 1000,
            1200,1300,
            1600,1700
        ));
        Thread.sleep(1000);
        flipMedDriverClass.registerDoctor("Dr. Dreadful", Speciality.DERMATOLOGIST);
        Thread.sleep(1000);
        flipMedDriverClass.markDocAvail("Dr. Dreadful", Map.of(900,1000,
            1100,1200,
            1300,1400
        ));
        Thread.sleep(1000);
        flipMedDriverClass.getBookingBySpeciality(Speciality.CARDIOLOGIST);
        Thread.sleep(1000);
        flipMedDriverClass.registerPatient("Patient A");
        Thread.sleep(1000);
        flipMedDriverClass.bookAppointMent("Patient A", "Dr. Curious", 1200);
        Thread.sleep(1000);
        flipMedDriverClass.registerDoctor("Dr. Daring", Speciality.DERMATOLOGIST);
        Thread.sleep(1000);
        flipMedDriverClass.markDocAvail("Dr. Daring", Map.of(1100,1200,1400,1500));
        Thread.sleep(1000);
        flipMedDriverClass.getBookingBySpeciality(Speciality.DERMATOLOGIST);
        Thread.sleep(1000);
        flipMedDriverClass.bookAppointMent("Patient F","Dr. Daring",1100);
        Thread.sleep(1000);
        flipMedDriverClass.bookAppointMent("Patient A","Dr. Curious",1200);
        Thread.sleep(1000);
        flipMedDriverClass.bookAppointMent("Patient F","Dr. Curious", 900);
        Thread.sleep(1000);
        flipMedDriverClass.bookAppointMent("Patient C","Dr. Curious",1600);
        Thread.sleep(1000);
        flipMedDriverClass.getBookingBySpeciality(Speciality.CARDIOLOGIST);
        Thread.sleep(1000);
        flipMedDriverClass.showBookingAppointMent("Patient F");
    }
}