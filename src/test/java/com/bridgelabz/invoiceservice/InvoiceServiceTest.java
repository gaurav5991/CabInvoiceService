package com.bridgelabz.invoiceservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;
    RideRepository rideRepository = null;
    Ride []rides;
    InvoiceSummary ExpectedInvoiceSummary = null;

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
        rideRepository = new RideRepository();
        invoiceGenerator.setRideRepository(rideRepository);
        rides = new Ride[] { new Ride(2.0, 5, RideCategory.NORMAL), new Ride(0.1, 1, RideCategory.PREMIUM)};
        ExpectedInvoiceSummary = new InvoiceSummary(2, 45.0);
    }

    /**
     * TestCase for printWelcome Message
     */
    @Test
    public void givenWelcomeMessageShouldReturnTrue() {
        boolean message = invoiceGenerator.printWelcomeMessage();
        Assert.assertTrue(message);
    }

    /**
     * Test Case to check Fare for given Distance and Time
     */
    @Test
    public void givenDistanceAndTimeShouldReturnTheTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    /**
     * Test Case to check Fare is Minimum Fare if totalFare less than MinimumFare for given Distance and Time
     */
    @Test
    public void givenDistanceAndTimeShouldReturnTheTotalFareAsMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    /**
     * Test Case to check Invoice Summary of multiple rides for Normal and Premium Ride
     */
    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummary() {
        String userId = "abc@gmail.com";
        invoiceGenerator.addRides(userId,rides);
        InvoiceSummary summary = invoiceGenerator.getInvoiceSummary(userId);
        Assert.assertEquals(ExpectedInvoiceSummary, summary);
    }
}
