package Exceptions;

public class BidValidationFailed extends RuntimeException{
    public BidValidationFailed() {
        super("Bid validation failed");
    }
}
