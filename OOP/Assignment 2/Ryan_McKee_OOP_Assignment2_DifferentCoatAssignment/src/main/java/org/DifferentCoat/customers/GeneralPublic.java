/*
This is the GeneralPublic class in extends from the Customer class and provides further
implementation. A general customer is a normal customer with assumed no previous experience in
calculating paint coverage therefore when we create this customer with additional information
compared to other types of customers like TradeCustomer such as height, width and room shape
of the room they want to paint to calculate surface area fo the room and then calculate the
paint coverage.
 */

package org.DifferentCoat.customers;

import org.DifferentCoat.shapes.*;

import static org.DifferentCoat.support.Constants.*;

public class GeneralPublic extends Customer {

    // fields
    private String custName;

    private static final char custType = GENERAL_CUSTOMER;

    private Shape room;

    /**
     * This class takes 6 arguments in its constructor. roomShape,
     * height and width are used to calculate surface area as a general
     * customer is assumed to not know how to make this calculation
     *
     * @param custName
     * @param custAddress
     * @param custTelNo
     * @param room:  Shape{Cylinder, Square, Rectangle}
     */
    public GeneralPublic(String custName, String custAddress, String custTelNo, Shape room) {
        super(custAddress, custTelNo);
        this.custName = custName;
        this.room = room;
    }

    // Getters
    public String getCustName() {
        return custName;
    }

    public char getCustType() {
        return custType;
    }

    public Shape getRoomShape() {
        return room;
    }

    @Override
    public double getSurfaceArea() {
        return Math.round(calculateSurfaceArea() * 100.0) / 100.0;
    }

//    /**
//     * Used for creating a Shape
//     *
//     * @param shapeType: ShapeEnum{CYLINDER, SQUARE, RECTANGLE}
//     * @param height
//     * @param width
//     * @return: Returns a Shape object which will have information about
//     * the customers room.
//     */
//    private Shape setRoomShape(Shape.ShapeEnum shapeType, double height, double width) {
//
//        Shape room = null;
//
//        switch (shapeType) {
//            case SQUARE:
//                room = new Square(height, width);
//                break;
//            case CYLINDER:
//                room = new Cylinder(height, width);
//                break;
//            case RECTANGLE:
//                room = new Rectangle(height, width);
//                break;
//            default:
//                throw new TypeNotPresentException("Shape type is not present please enter a valid type", null);
//        }
//
//        return room;
//    }

    /**
     * This function calculates how many liters of paint are needed in
     * order totally cover the room.
     *
     * @return The paint coverage rounded up to 2 decimal places
     */
    @Override
    public double calculatePaintCoverage() {
        double surfaceArea = calculateSurfaceArea();
        // surface area is subtracted by average door size and window size
        // to assure an accurate calculation
        double coverage = (surfaceArea / COVERAGE) * GALLON;
        // Math.round rounds surface area up to 2 decimal places.
        coverage = Math.round(coverage * 100.0) / 100.0;
        return coverage;
    }

    /**
     * function calculates the surfaceArea of the room shape
     * depending on what type of shape it is and takes into consideration
     * average size of doors and windows in this calculation to the surface area
     * subtracts that.
     *
     * @return surfaceArea double value
     */
    public double calculateSurfaceArea() {
        double surfArea = 0;

        switch (room.getShapeName()) {
            case "CYLINDER":
            case "SQUARE":
            case "RECTANGLE":
                surfArea = room.getPerimeter();
                surfArea = surfArea * room.getHeight();
                break;
            default:
                throw new TypeNotPresentException("Room shape selected is not currently supported", null);
        }

        surfArea = (surfArea - DOOR_SIZE - WINDOW_SIZE) * WASTAGE;
        surfArea = Math.round(surfArea * 100.0) / 100.0;
        return surfArea;
    }

    /**
     * Overrides the toString from customer and gives adds the additional
     * information from this class
     *
     * @return GeneralPublic string
     */
    @Override
    public String toString() {
        return "General Customer{Name: "
                + this.custName + ", "
                + super.toString()
                + "Room shape: " + room.getShapeName() + ", "
                + "Height: " + room.getHeight() + ", "
                + "Width: " + room.getWidth() + ", "
                + "surface area: " + calculateSurfaceArea() + ", "
                + "Paint Coverage: " + calculatePaintCoverage()
                + "}";
    }
}
