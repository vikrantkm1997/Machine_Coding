package dataModel;

import enums.VehicleStatus;
import enums.VehicleType;

public class Vehicle {
    private String ownerName;
    private VehicleType vehicleType;
    private String regNo;
    private VehicleStatus vehicleStatus;

    public Vehicle(String ownerName, VehicleType vehicleType, String regNo) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.regNo = regNo;
        this.vehicleStatus = VehicleStatus.IDLE;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getRegNo() {
        return regNo;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }
}
