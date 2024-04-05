package dataModel.manager;

import dataModel.Ride;
import dataModel.Vehicle;
import enums.RideStatus;
import enums.VehicleType;
import utils.IdGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideManager {
    private Map<Integer, Ride> idToRideMap;

    private static RideManager rideManagerInstance;
    private RideManager() {
        this.idToRideMap = new HashMap<>();
    }
    public static RideManager getInstance() {
        if(rideManagerInstance == null) {
            rideManagerInstance = new RideManager();
        }
        return rideManagerInstance;
    }

    public Map<Integer, Ride> getRegNoToVehicle() {
        return idToRideMap;
    }

    public void createRide(String userName, String origin, String destination,
                           int seatsAvailable,
                           VehicleType vehicleType, String regNo) {
        Ride ride = new Ride(IdGenerator.getRideId(), userName, origin, destination, seatsAvailable, vehicleType, regNo);
        this.idToRideMap.put(ride.getId(), ride);
        System.out.println("Ride created ->"+ ride.getId()+" "+ride.getVehicleType()+" "+ride.getOrigin()+" "+ride.getDestination()+" "+ride.getRegNo());
    }

    public List<Ride> getRides() {
        return this.idToRideMap.values().stream()
            .filter(it -> it.getRideStatus()== RideStatus.ONGOING)
            .toList();
    }

    public Ride getRide(int id) {
        return idToRideMap.get(id);
    }

    public int getRideCntByUser(String username){
        return (int)idToRideMap.values().stream().filter(it -> it.getUserName().equals(username)).count();
    }
}
