package com.bridgelabz.invoiceservice;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class InvoiceGenerator {
    private static final int MINIMUM_COST_PER_KM = 10;
    private static final int MINIMUM_COST_PER_MINUTE = 1;
    private static final int MINIMUM_FARE = 5;

    /*Function to print Welcome message*/
    public boolean printWelcomeMessage() {
        System.out.println("Welcome to Cab Invoice Generation System");
        return true;
    }

    /**
     * @param distance
     * @param time
     * @return total Fare for given Distance and Time
     */
    public double calculateFare(double distance, int time) {
        double totalFare = distance * MINIMUM_COST_PER_KM + time * MINIMUM_COST_PER_MINUTE;
        if (totalFare < MINIMUM_FARE) {
            return MINIMUM_FARE;
        }
        return totalFare;
    }
    /**
     * @param rides
     * @return total Fare for multiple rides
     */
    public double calculateFare(Ride[] rides) {
        return Arrays.stream(rides).
                flatMapToDouble(ride -> DoubleStream.of(calculateFare(ride.getDistance(), ride.getTime())))
                .sum();
    }
}
