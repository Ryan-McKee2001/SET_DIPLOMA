/*
This is a customer abstract it defines basic
functionality and fields expected of classes that
inherit from this (GeneralPublic/TradeCustomer
 */

package org.DifferentCoat.customers;

import org.DifferentCoat.shapes.*;

public abstract class Customer {

    // Fields
    private String custAddress;

    private String custTelNo;

    private double surfaceArea;

    private Shape roomShape;

    /**
     * Takes the minimum values that every
     * customer shares
     *
     * @param custAddress
     * @param custTelNo
     */
    public Customer(String custAddress, String custTelNo) {
        this.custAddress = custAddress;
        this.custTelNo = custTelNo;
    }

    // Getters
    public String getCustAddress() {
        return custAddress;
    }

    public String getCustTelNo() {
        return custTelNo;
    }

    public Shape getRoomShape() {
        return roomShape;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * This function will be implemented in derived classes
     * with different methods of getting paintCoverage
     *
     * @return returns the paint in liters needed to cover
     * a room of certain surface area.
     */
    public abstract double calculatePaintCoverage();

    /**
     * This toString method will be the bare-bones for derived
     * classes it contains some logic which allows the values in
     * this toString to be changed dependent on whether surfaceArea
     * is NA or not.
     *
     * @Return This returns a string containing information about this
     * class.
     */
    public String toString() {
        boolean hasSurfaceArea = true;
        if (roomShape != null) {
            hasSurfaceArea = false;
        }
        StringBuilder string = new StringBuilder();
        string.append("Address: " + custAddress + ", ");
        string.append("TelNo: " + custTelNo + ", ");

        return string.toString();
    }
}
