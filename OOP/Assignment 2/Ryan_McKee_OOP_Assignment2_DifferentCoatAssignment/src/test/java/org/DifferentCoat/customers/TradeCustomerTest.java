/*
This class tests the functionality of the TradeCustomer
class specifically the getCoverage function and the
toString functions
 */

package org.DifferentCoat.customers;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.DifferentCoat.support.Constants.COVERAGE;
import static org.DifferentCoat.support.Constants.GALLON;
import static org.testng.Assert.*;

public class TradeCustomerTest {

    private TradeCustomer customer;

    private final String TRADE_NAME = "plywood plc";

    private final String ADDRESS = "59 Adelaide isle";

    private final String TELEPHONE = "(028) 078567345";

    private final double SURFACE_AREA = 150;

    @BeforeClass
    public void setUp() {
        customer = new TradeCustomer(
                TRADE_NAME
                , ADDRESS
                , TELEPHONE
                , SURFACE_AREA
        );
    }

    @Test
    public void getCoverage() {

        double expected = (SURFACE_AREA / COVERAGE) * GALLON;
        double actual = customer.calculatePaintCoverage();
        assertEquals(actual, expected, 0);
    }

    // This test is used to ascertain the correctness of the
    // toString function of TradeCustomer class
    @Test
    public void toStringTest() {

        System.out.println(customer.toString());
    }
}
