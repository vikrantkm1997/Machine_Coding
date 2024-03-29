package Exceptions;

public class PatientNotFound extends RuntimeException{
    public PatientNotFound(int patient) {
        super("Patient creds not found "+patient);
    }
}
