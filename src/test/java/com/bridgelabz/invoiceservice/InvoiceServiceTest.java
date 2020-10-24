package com.bridgelabz.invoiceservice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void setUp() {
        invoiceGenerator = new InvoiceGenerator();
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
     * Test Case to check Invoice Summary of multiple rides for given Distance and Time
     */
    @Test
    public void givenMultipleRidesShouldReturnInvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5), new Ride(0.1, 1)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary ExpectedInvoiceSummary = new InvoiceSummary(2, 30, 0);
        Assert.assertEquals(ExpectedInvoiceSummary,summary);
    }
}
