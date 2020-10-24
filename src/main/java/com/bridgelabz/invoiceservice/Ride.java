package com.bridgelabz.invoiceservice;

public class Ride {
    private final int time;
    private final double distance;
    private final RideCategory rideCategory;

    public Ride(double distance, int time, RideCategory rideCategory) {
        this.distance = distance;
        this.time = time;
        this.rideCategory = rideCategory;
    }

    public int getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }

    public RideCategory getRideCategory() {
        return rideCategory;
    }
}
