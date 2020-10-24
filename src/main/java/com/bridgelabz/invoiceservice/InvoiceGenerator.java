package com.bridgelabz.invoiceservice;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class InvoiceGenerator {
    private static final int MINIMUM_COST_PER_KM = 10;
    private static final int MINIMUM_COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;
    private RideRepository rideRepository;

    /*Function to print Welcome message*/
    public boolean printWelcomeMessage() {
        System.out.println("Welcome to Cab Invoice Generation System");
        return true;
    }

    /**
     * Constructor to initialize Repository
     */
    public InvoiceGenerator() {
        this.rideRepository = new RideRepository();
    }

    /**
     * @param distance
     * @param time
     * @return total Fare for given Distance and Time
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * MINIMUM_COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    /**
     * @param rides
     * @return Invoice Summary for multiple rides
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = Arrays.stream(rides).
                flatMapToDouble(ride -> DoubleStream.of(calculateFare(ride.getDistance(), ride.getTime())))
                .sum();
        return new InvoiceSummary(rides.length, totalFare);
    }

    /**
     * Method to add rides to List
     *
     * @param userId
     * @param rides
     */
    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    /**
     * @param userId
     * @return Invoice Summary for given User Id
     */
    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.calculateFare(rideRepository.getRides(userId));
    }
}
