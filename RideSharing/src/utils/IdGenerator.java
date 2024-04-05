package utils;

public class IdGenerator {
    public static int rideId;

    public IdGenerator() {
        rideId = 0;
    }

    public static int getRideId() {
        return ++rideId;
    }
}
