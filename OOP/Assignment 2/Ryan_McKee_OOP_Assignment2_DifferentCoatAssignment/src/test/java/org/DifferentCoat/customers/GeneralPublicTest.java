/*
This test class is used to test the GeneralPublic class
specifically the getCoverage function and the toString functions
 */

package org.DifferentCoat.customers;

import org.DifferentCoat.shapes.Cylinder;
import org.DifferentCoat.shapes.Rectangle;
import org.DifferentCoat.shapes.Shape;
import org.DifferentCoat.shapes.Square;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import static org.DifferentCoat.support.Constants.*;

public class GeneralPublicTest {

    private GeneralPublic generalPublicCustomer;

    private static final String NAME = "Joe bloggs";

    private static final String ADDRESS = "121 Darkley road, co Armagh";

    private static final String TELNO = "07879424178";

    private static final double HEIGHT = 10;

    private static final double WIDTH = 8;

    @BeforeClass
    public void setUp() {
        this.generalPublicCustomer = new GeneralPublic(
                NAME,
                ADDRESS,
                TELNO,
                new Square(35, 35)
        );
    }

    @Test
    public void testGetCustName() {
        assertEquals(generalPublicCustomer.getCustName(), NAME);
    }

    @Test
    public void testGetCustType() {
        assertEquals(generalPublicCustomer.getCustType(), GENERAL_CUSTOMER);
    }

    @Test
    public void testGetRoomShape() {
        assertEquals(generalPublicCustomer.getRoomShape().toString(), Shape.ShapeEnum.SQUARE.toString());
    }

    @Test
    public void testCalculateSurfaceAreaForSquare() {

        assertEquals(5340.5, generalPublicCustomer.getSurfaceArea(), 2);
    }

    @Test
    public void testCalculateSurfaceAreaForRectangle() {

        this.generalPublicCustomer = new GeneralPublic(
                NAME,
                ADDRESS,
                TELNO,
                new Rectangle(10, 20, 15)
        );

        System.out.println(generalPublicCustomer.calculateSurfaceArea());
    }

    @Test
    public void testCalculateSurfaceAreaForCylinder() {

        this.generalPublicCustomer = new GeneralPublic(
                NAME,
                ADDRESS,
                TELNO,
                new Cylinder(12, 20)
        );

        // expected calculation
        double perimeter = generalPublicCustomer.getRoomShape().getPerimeter();
        double surfaceArea = perimeter * generalPublicCustomer.getRoomShape().getHeight();
        surfaceArea = (surfaceArea - DOOR_SIZE - WINDOW_SIZE) * WASTAGE;
        surfaceArea = Math.round(surfaceArea * 100.0) / 100.0;
        double expected = surfaceArea;

        double actual = generalPublicCustomer.calculateSurfaceArea();
        assertEquals(actual, expected, 0);
    }

    @Test
    public void testCalculatePaintCoverageForSQUARE() {

        Square square = new Square(HEIGHT, WIDTH);
        this.generalPublicCustomer = new GeneralPublic(
                NAME,
                ADDRESS,
                TELNO,
                square
        );
        double actual = this.generalPublicCustomer.calculatePaintCoverage();
        assertEquals(69.29, actual, 2);
    }

    @Test
    public void testCalculatePaintCoverageForRectangle() {

        Rectangle rectangle = new Rectangle(HEIGHT, WIDTH, 20);
        this.generalPublicCustomer = new GeneralPublic(
                NAME,
                ADDRESS,
                TELNO,
                rectangle
        );

        // expected calculation
        double perimeter = generalPublicCustomer.getRoomShape().getPerimeter();




        double actual = this.generalPublicCustomer.calculatePaintCoverage();



        assertEquals(actual, 27.9, 0);
    }

    @Test
    public void testCalculatePaintCoverageForCylinder() {

        Cylinder cylinder = new Cylinder(HEIGHT, WIDTH);
        this.generalPublicCustomer = new GeneralPublic(
                NAME,
                ADDRESS,
                TELNO,
                cylinder
        );

        // expected calculation
        double perimeter = cylinder.getPerimeter();
        double surfaceArea = perimeter * cylinder.getHeight();

        surfaceArea = (surfaceArea - DOOR_SIZE - WINDOW_SIZE) * WASTAGE;
        // This rounds the surface area up to 2 decimal places

        surfaceArea =  (surfaceArea / COVERAGE) * GALLON;
        double expected = Math.round(surfaceArea * 100.0) / 100.0;;



        double actual = this.generalPublicCustomer.calculatePaintCoverage();
        // assertEquals(actual, expected);

        assertEquals(actual, expected, 0);
    }
}