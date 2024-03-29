package Exceptions;

public class TimeSlotNotFound extends RuntimeException{
    public TimeSlotNotFound(String msg) {
        super(msg);
    }
}
