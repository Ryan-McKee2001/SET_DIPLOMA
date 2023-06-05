package org.DifferentCoat.shapes;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class RectangleTest {

    private Rectangle rectangle;
    private double HEIGHT = 20;
    private double WIDTH = 15;
    private double LENGTH = 12;

    @BeforeClass
    public void setUp() {
        rectangle = new Rectangle(HEIGHT, WIDTH, LENGTH);
    }

    @Test
    public void getLength() {
        assertEquals(rectangle.getLength(), LENGTH);
    }

    @Test
    public void getHeight() {
        assertEquals(rectangle.getHeight(), HEIGHT);
    }

    @Test
    public void getWidth() {
        assertEquals(rectangle.getWidth(), WIDTH);
    }

    @Test
    public void getPerimeter() {
        double expected = (LENGTH + WIDTH) * 2;
        double actual = rectangle.getPerimeter();
        assertEquals(actual, expected, 2);
    }
}