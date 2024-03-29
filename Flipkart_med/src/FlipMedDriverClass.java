import Entity.Booking;
import Entity.BookingTimeSlot;
import Entity.Doctor;
import Entity.Patient;
import Enums.Speciality;
import Exceptions.DoctorNotFoundException;
import IDGenerator.IDGenerator;
import Manager.DoctorManager;
import Manager.PatientManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class FlipMedDriverClass {
    private DoctorManager doctorManager;

    private PatientManager patientManager;

    private Map<Speciality, List<Doctor>> specialityListDoctorMap;
    private Map<Integer, ArrayList<Booking>> patientBookingsMap;

    public FlipMedDriverClass() {
        doctorManager = DoctorManager.getDriverManagerInstance();
        patientManager = PatientManager.getPatientManagerInstance();
        this.specialityListDoctorMap = new HashMap<>();
        this.patientBookingsMap = new HashMap<>();
    }

    public void registerDoctor(String name, Speciality speciality) {
        Doctor doc = doctorManager.addDoctor(name, speciality);

        if(specialityListDoctorMap.containsKey(doc.getSpeciality())) {
            specialityListDoctorMap.get(doc.getSpeciality()).add(doc);
        } else {
            List<Doctor> doctorsList = new ArrayList<>();
            doctorsList.add(doc);
            specialityListDoctorMap.put(doc.getSpeciality(), doctorsList);
        }

    }
    public void markDocAvail(String name, Map<Integer, Integer> timeSlots) {

        Boolean timeSlotValidation = validateTimeSlot(timeSlots);
        if(!timeSlotValidation)
        {
            System.out.println("Sorry "+name+ "time slots are only 60 min");
            return;
        }
        Map<Integer, Doctor> idToDoctorMap = doctorManager.getIdToDoctorMap();

        Doctor currentDoctor = idToDoctorMap.values().stream()
                .filter(doc -> doc.getName().equals(name))
                .findFirst()
                .orElse(null);
        if(currentDoctor!=null)
        {
            currentDoctor.addSlot(timeSlots);
            System.out.println("Done Doc");
        } else {
            throw new DoctorNotFoundException("Doctor with name " +name+" not found");
        }
    }
    Boolean validateTimeSlot(Map<Integer, Integer> timeSlots) {
       for(Map.Entry<Integer, Integer> entry : timeSlots.entrySet() )
       {
           if(entry.getValue() - entry.getKey() != 100)
               return false;
       }
       return true;
    }

    public void registerPatient(String name) {
        patientManager.registerNewPatient(name);
    }

    public void showBookingAppointMent(String patientName) {
        Patient patient = patientManager.getIdToPatientMap()
                .values()
                .stream()
                .filter(patient1 -> patient1.getPatientName().equals(patientName))
                .findFirst()
                .orElse(null);
        patientBookingsMap.get(patient.getPatientId()).forEach(booking ->{
                Doctor doctor = doctorManager.getDoctor(booking.getDocId());
                System.out.println("BookingId: "+booking.getBookingId()+ ":"+doctor.getName()+" "+booking.getStartTime());
        });
    }

    public void getBookingBySpeciality(Speciality speciality) {
        List<Doctor> specialityDoctorsList = specialityListDoctorMap.get(speciality);
        specialityDoctorsList.forEach(doc -> {
                List<BookingTimeSlot> bookingTimeSlots = doc.getAvailableTimeSlotMap();
                AtomicBoolean anySlotsAvailable = new AtomicBoolean(false);
                bookingTimeSlots.
                    forEach(bookingTimeSlot -> {
                        anySlotsAvailable.set(true);
                        System.out.println
                            (doc.getName() + " :(" + bookingTimeSlot.getStartTime() + " " + bookingTimeSlot.getEndTime()+")");
                        }
                    );
                if(!anySlotsAvailable.get())
                    System.out.println(doc.getName()+": No slots available");
                }
        );
    }

    public void bookAppointMent(String patName, String docName, int startTime) {
        Doctor doctor = doctorManager.getDoctorByName(docName);

        Patient patient = patientManager.getPatientByName(patName);
        if(patient == null)
        {
            patient = patientManager.registerNewPatient(patName);
        }
        Boolean isBooked = doctor.bookSlot(startTime);
        Booking booking = null;
        if(isBooked) {
            booking = new Booking(
                IDGenerator.getBookingId(),
                doctor.getId(),
                patient.getPatientId(),
                startTime,
                startTime+100
                );
        }

        if(booking!= null) {
            ArrayList<Booking> bookingListPerPatient = patientBookingsMap
                .getOrDefault(
                    patient.getPatientId(),
                    new ArrayList <> (List.of(booking)) // new ArrayList<> (Array.asList())
                );
            bookingListPerPatient.add(booking);
            patientBookingsMap.put(patient.getPatientId(), bookingListPerPatient);
            System.out.println("Booked: Booking id: "+ booking.getBookingId());
        } else {
            System.out.println("Booking failure");
        }

    }
}
