package com.bridgelabz.invoiceservice;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    /**
     * TestCase for printWelcome Message
     */
    @Test
    public void givenWelcomeMessageShouldReturnTrue() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        boolean message = invoiceGenerator.printWelcomeMessage();
        Assert.assertTrue(message);
    }
}
