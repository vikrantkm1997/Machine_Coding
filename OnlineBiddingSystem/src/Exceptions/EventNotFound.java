package Exceptions;

public class EventNotFound extends RuntimeException{
    public EventNotFound(String message) {
        super(message);
    }
}
