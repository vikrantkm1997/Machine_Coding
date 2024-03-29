package Entity;

import Enums.Speciality;
import Exceptions.TimeSlotNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Doctor {
    private int id;
    private String name;
    private Speciality speciality;


    Map<Integer, Integer> availableTimeSlotMap;

    List<BookingTimeSlot> doctorsBookingSlots;
    public Doctor(int id, String name, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.availableTimeSlotMap = new HashMap<>();
        this.doctorsBookingSlots = new ArrayList<>();
    }

    //TODO: timeSlotValidation
    public void addSlot(Map<Integer, Integer> slots)
    {
        availableTimeSlotMap.putAll(slots);
//        slots.forEach((key, val)-> {
//            BookingTimeSlot bookingTimeSlot = new BookingTimeSlot(this.id, key, val);
//            this.doctorsBookingSlots.add(bookingTimeSlot);
//            });
        slots.forEach((key, val) -> {
            doctorsBookingSlots
                    .add(new BookingTimeSlot(
                            this.id,
                            key,
                            val
                    ));
                });

    }

    public String getName() {
        return name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public List<BookingTimeSlot> getAvailableTimeSlotMap() {
//        return availableTimeSlotMap;
        return doctorsBookingSlots.stream().filter(slot -> !slot.getBooked()).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public Boolean bookSlot(int startTime) {
        BookingTimeSlot bookingTimeSlot = doctorsBookingSlots
            .stream()
            .filter(slot -> slot.getStartTime() == startTime)
            .findFirst()
            .orElse(null);

        if(bookingTimeSlot == null) {
            throw new TimeSlotNotFound(Integer.toString(startTime));
        }

        if(bookingTimeSlot.getBooked()) {
            return false;
        }
        return bookingTimeSlot.setBooked(true);
    }
}
