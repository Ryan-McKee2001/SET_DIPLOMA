/*
This is the Shape class. This class is the abstract
class for all shape classes (Cylinder, Rectangle and Square)
it defines the basic functionality of a shape including field
height width
 */

package org.DifferentCoat.shapes;

public abstract class Shape {

    // fields
    private ShapeEnum shapeType;
    private double height;
    private double width;

    // constructor
    public Shape(double height, double width) {
        this.height = height;
        this.width = width;
    }

    // getters
    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public abstract String getShapeName();

    // This function is abstract it gets the length of
    // both of the widths of the perimeter it as a
    public double getPerimeter() {
        return 2 * this.width;
    }

    public abstract String toString();

    // This inner class is used to represent
    // what type of shape an object is.
    public enum ShapeEnum {
        CYLINDER, SQUARE, RECTANGLE;
    }
}
