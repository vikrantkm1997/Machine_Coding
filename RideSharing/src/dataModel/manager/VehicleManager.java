package dataModel.manager;

import dataModel.User;
import dataModel.Vehicle;
import enums.Gender;
import enums.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class VehicleManager {
    private Map<String , Vehicle> regNoToVehicle;

    private static VehicleManager vehicleManagerInstance;
    private VehicleManager() {
        this.regNoToVehicle = new HashMap<>();
    }
    public static VehicleManager getInstance() {
        if(vehicleManagerInstance == null) {
            vehicleManagerInstance = new VehicleManager();
        }
        return vehicleManagerInstance;
    }

    public Map<String, Vehicle> getRegNoToVehicle() {
        return regNoToVehicle;
    }

    public void addVehicle(String ownerName, VehicleType vehicleType, String regNo) {
        Vehicle vehicle = new Vehicle(ownerName, vehicleType, regNo);
        this.regNoToVehicle.put(regNo, vehicle);
    }

    public Vehicle getVehicle(String regNo) {
        return regNoToVehicle.get(regNo);
    }
}
