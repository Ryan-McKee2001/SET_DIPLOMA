/*
This is TradeCustomer class this is an extension
of the Customer class. A trade-customer is a customer
of differentCoat which is assumed to know how to make
an accurate measurement of surface area for a room that they
are painting therefore this customer we do not take room shape,
height and width to calculate the surface area rather we let the customer
input the surface area in the constructor.
 */

package org.DifferentCoat.customers;

import static org.DifferentCoat.support.Constants.*;

public class TradeCustomer extends Customer {

    // fields
    private String tradeName;

    private double surfaceArea;

    private static final char custType = TRADE_CUSTOMER;

    /**
     * In this constructor we take surface area directly from
     * the customer as we assume they can accurataly make this
     * calculation themselves.
     *
     * @param tradeName
     * @param custAddress
     * @param custTelNo
     * @param surfaceArea
     */
    public TradeCustomer(String tradeName, String custAddress, String custTelNo, double surfaceArea) {
        super(custAddress, custTelNo);
        this.tradeName = tradeName;
        this.surfaceArea = surfaceArea;
    }

    // getters
    @Override
    public double getSurfaceArea() {
        return Math.round(this.surfaceArea * 100.0) / 100.0;
    }

    public String getTradeName() {
        return tradeName;
    }

    public char getCustType() {
        return custType;
    }

    /**
     * This function we use the surface area to calculate
     * the paint needed to cover the surface area for this
     * class.
     *
     * @return paint coverage
     */
    @Override
    public double calculatePaintCoverage() {
        double coverage = (this.surfaceArea / COVERAGE) * GALLON;
        return Math.round(coverage * 100.0) / 100.0;
    }

    /**
     * This string gives returns a string with additional details including
     * trade name of the customer.
     *
     * @return TradeCustomer information string
     */
    @Override
    public String toString() {
        return "Trade Customer{Name: "
                + this.tradeName + ", "
                + super.toString()
                + "Surface area: " + surfaceArea + ", "
                + "Paint coverage: " + calculatePaintCoverage()
                + "}";
    }
}
