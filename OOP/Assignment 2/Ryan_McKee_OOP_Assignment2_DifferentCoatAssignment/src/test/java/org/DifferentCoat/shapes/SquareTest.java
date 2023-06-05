package org.DifferentCoat.shapes;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SquareTest {

    private static Square square;
    private static double SIDE_LENGTH;
    private static double HEIGHT;

    @BeforeClass
    public void setUp() {
        SIDE_LENGTH = 10;
        HEIGHT = 20;
        square = new Square(HEIGHT, SIDE_LENGTH);
    }

    @Test
    public void getLength() {
        assertEquals(square.getWidth(), SIDE_LENGTH);
    }

    @Test
    public void getHeight() {
        assertEquals(square.getHeight(), HEIGHT);
    }

    @Test
    public void getPerimeter() {
        double expected = (SIDE_LENGTH + SIDE_LENGTH) * 2;
        double actual = square.getPerimeter();
        assertEquals(expected, actual, 2);
    }
}
