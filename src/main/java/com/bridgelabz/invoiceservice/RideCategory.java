package com.bridgelabz.invoiceservice;

public enum RideCategory {
    NORMAL(10.0, 1.0, 5.0), PREMIUM(15.0, 2.0, 20.0);

    public double costPerKm;
    public double costPerMinute;
    public double MinimumFarePerRide;

    RideCategory(double costPerKm, double costPerMinute, double minimumFarePerRide) {
        this.costPerKm = costPerKm;
        this.costPerMinute = costPerMinute;
        this.MinimumFarePerRide = minimumFarePerRide;
    }

    public double calculateCostOfCabRide(Ride ride) {
        double rideCost = ride.getDistance() * costPerKm + ride.getTime() * costPerMinute;
        return Math.max(rideCost, MinimumFarePerRide);
    }
}
