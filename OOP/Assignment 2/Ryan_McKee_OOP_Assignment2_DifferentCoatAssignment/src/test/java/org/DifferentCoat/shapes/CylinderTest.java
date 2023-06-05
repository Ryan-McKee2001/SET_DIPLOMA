package org.DifferentCoat.shapes;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CylinderTest {

    double HEIGHT = 10;
    double WIDTH = 10;
    Cylinder cylinder = new Cylinder(WIDTH, WIDTH);

    @Test
    public void getRadius() {
        double expected = WIDTH / 2;
        assertEquals(cylinder.getRadius(), expected, 0);
    }

    @Test
    public void getWidth() {
        assertEquals(cylinder.getWidth(), WIDTH, 0);
    }

    @Test
    public void getHeight() {
        assertEquals(cylinder.getHeight(), HEIGHT, 0);
    }

    @Test (dependsOnMethods = { "getRadius" })
    public void getPerimeter() {
        double radius = cylinder.getRadius();
        double expected = 2*Math.PI*radius;
        double actual = cylinder.getPerimeter();
        assertEquals(actual, expected , 0);
    }
}