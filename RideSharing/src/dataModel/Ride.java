package dataModel;

import enums.RideStatus;
import enums.VehicleType;

import java.util.Set;

public class Ride {
    private int id;
    private String userName;
    private String origin, destination;
    private int seatsAvailable;
    private VehicleType vehicleType;
    private String regNo;
    private RideStatus rideStatus;

    private Set<String> usersTakenRide;

    public Ride(int id, String userName, String origin, String destination, int seatsAvailable,
                VehicleType vehicleType, String regNo) {
        this.id = id;
        this.userName = userName;
        this.origin = origin;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
        this.vehicleType = vehicleType;
        this.regNo = regNo;
        this.rideStatus = RideStatus.ONGOING;
    }

    public String getUserName() {
        return userName;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public int getId() {
        return id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegNo() {
        return regNo;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }
    public RideStatus updateRideStatus(RideStatus rideStatus) {
        this.rideStatus = rideStatus;
        return this.rideStatus;
    }

    public void decreaseSeats() {
        this.seatsAvailable -= 1;
    }

}
