package com.bridgelabz.invoiceservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, ArrayList<Ride>> userRide = null;

    public RideRepository() {
        userRide = new HashMap<>();
    }

    /**
     * @param userId
     * @return Array of Ride to Invoice Generator
     */
    public Ride[] getRides(String userId) {
        return this.userRide.get(userId).toArray(new Ride[0]);
    }

    /**
     * @param userId
     * @param rides  Method to Add rides to ArrayList rideList
     */
    public void addRides(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.userRide.get(userId);
        if (rideList == null) {
            rideList = new ArrayList<>(Arrays.asList(rides));
            this.userRide.put(userId, rideList);
        }
    }


}
