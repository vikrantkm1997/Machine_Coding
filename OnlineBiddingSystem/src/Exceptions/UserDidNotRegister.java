package Exceptions;

public class UserDidNotRegister extends RuntimeException{
    public UserDidNotRegister() {
        super("User did not register for the event");
    }
}
