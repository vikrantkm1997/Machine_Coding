package Strategy;

import dataModel.Ride;

import java.util.List;

public interface RideStrategy {
    public Ride getRide(List<Ride> rideList);
}
