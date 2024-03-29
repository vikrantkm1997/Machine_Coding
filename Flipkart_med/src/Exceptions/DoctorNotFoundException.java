package Exceptions;

public class DoctorNotFoundException extends RuntimeException{
    public DoctorNotFoundException(String errorMsg){
        super(errorMsg);
    }
}
