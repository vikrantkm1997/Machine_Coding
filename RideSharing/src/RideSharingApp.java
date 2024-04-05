import Strategy.Impl.GetRideByMostVacant;
import Strategy.Impl.GetRideByVehicleType;
import Strategy.RideStrategy;
import dataModel.Ride;
import dataModel.User;
import dataModel.Vehicle;
import dataModel.manager.RideManager;
import dataModel.manager.UserManager;
import dataModel.manager.VehicleManager;
import enums.Gender;
import enums.RideStatus;
import enums.VehicleStatus;
import enums.VehicleType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideSharingApp {
    private RideManager rideInstance;
    private UserManager userInstance;
    private VehicleManager vehicleInstance;

    private Map<String, List<Ride>> ridesTakenByUser;

    public RideSharingApp() {
        this.rideInstance = RideManager.getInstance();
        this.userInstance = UserManager.getInstance();
        this.vehicleInstance = VehicleManager.getInstance();
        this.ridesTakenByUser = new HashMap<>();
    }

    public void addUser(String name, Gender gender, int age) {
        userInstance.addUser(name, gender, age);
    }

    public void addVehicle(String ownerName, VehicleType vehicleType, String regNo) {
        vehicleInstance.addVehicle(ownerName, vehicleType, regNo);
    }

    public void offerRide(String userName, String origin, String destination,
                          int seatsAvailable,
                          VehicleType vehicleType, String regNo) {
        try
        {
            Vehicle vehicle = vehicleInstance.getVehicle(regNo);
            if (vehicle.getVehicleStatus() == VehicleStatus.ON_RIDE)
                throw new RuntimeException("Vehicle not idle "+regNo);
            vehicle.setVehicleStatus(VehicleStatus.ON_RIDE);
            rideInstance.createRide(userName, origin, destination, seatsAvailable, vehicleType, regNo);

        } catch (Exception e) {
            System.out.println("Some error occured as "+ e.getMessage());
        }
    }

//    “Nandini, Origin=Bangalore, Destination=Mysore, Seats=1, Most Vacant”
    public void selectRide(String userName, String origin, String destination, int noOfSeats, String strategy) {
        try {
            RideStrategy rideStrategy;
            List<Ride> rideList = rideInstance.getRides().stream()
                                    .filter
                                        (it-> it.getOrigin().equals(origin)&&
                                            it.getDestination().equals(destination)&&
                                            it.getSeatsAvailable() >= noOfSeats
                                        ).toList();
            if(strategy.equals("Most Vacant")) {
                rideStrategy = new GetRideByMostVacant();
                Ride ride = rideStrategy.getRide(rideList);
                if(ride != null)
                {
                    ride.decreaseSeats();
                    List<Ride> ridesByUser = ridesTakenByUser.getOrDefault(userName, new ArrayList<>());
                    ridesByUser.add(ride);
                    ridesTakenByUser.put(userName, ridesByUser);
                    System.out.println("Ride assigned to user "+userName +" "+ride.getRegNo());
                }
                else {
                    throw new RuntimeException("Ride not possible by most vacant");
                }
            } else {
                String vehicleType = strategy.split("=")[1];
                String vehType = vehicleType.toUpperCase();
                rideStrategy = new GetRideByVehicleType(vehType);
                Ride ride = rideStrategy.getRide(rideList);
                if(ride != null)
                {
                    ride.decreaseSeats();
                    List<Ride> ridesByUser = ridesTakenByUser.getOrDefault(userName, new ArrayList<>());
                    ridesByUser.add(ride);
                    ridesTakenByUser.put(userName, ridesByUser);
                    System.out.println("Ride assigned to user "+ userName+" "+ride.getRegNo());
                }
                else {
                    throw new RuntimeException("No Rides found");
                }
            }
        } catch (Exception e) {
            System.out.println("Sorry can't select ride as "+ e.getMessage());
        }
    }

    public void endRide(int id) {
        try
        {
            Ride ride = rideInstance.getRide(id);
            ride.updateRideStatus(RideStatus.COMPLETED);
            Vehicle vehicle = vehicleInstance.getVehicle(ride.getRegNo());
            vehicle.setVehicleStatus(VehicleStatus.IDLE);
            System.out.println("Ride Ended "+ride.getRegNo()+" "+ride.getId());
        } catch (Exception e) {
            System.out.println("Couldn't end ride as "+e.getMessage());
        }
    }

    public void printRideStats() {
        List<User> userList = userInstance.getNameToUserMap().values().stream().toList();
        System.out.println("userList size "+userList.size());
        userList.forEach(user ->{
            int ridesOffered=0, ridesTaken=0;
            ridesOffered = rideInstance.getRideCntByUser(user.getName());
            if(ridesTakenByUser.containsKey(user.getName()))
                ridesTaken = ridesTakenByUser.get(user.getName()).size();
            System.out.println(user.getName()+ " rides taken:"+ ridesTaken+" rides offered:"+ ridesOffered);
        });
    }
}
