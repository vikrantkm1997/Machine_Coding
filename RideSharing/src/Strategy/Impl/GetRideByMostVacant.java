package Strategy.Impl;

import Strategy.RideStrategy;
import dataModel.Ride;

import java.util.Comparator;
import java.util.List;

public class GetRideByMostVacant implements RideStrategy {
    public Ride getRide(List<Ride> rideList) {
        return rideList.stream().max(Comparator.comparing(Ride::getSeatsAvailable)).orElse(null);
    }

}
