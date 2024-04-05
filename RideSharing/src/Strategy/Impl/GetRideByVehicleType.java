package Strategy.Impl;

import Strategy.RideStrategy;
import dataModel.Ride;

import java.util.List;

public class GetRideByVehicleType implements RideStrategy {

    private String vehType;

    public GetRideByVehicleType(String vehType) {
        this.vehType = vehType;
    }
    @Override
    public Ride getRide(List<Ride> rideList) {
        return rideList.stream().filter(it -> it.getVehicleType().toString().equals(vehType)).findFirst().orElse(null);
    }


}
