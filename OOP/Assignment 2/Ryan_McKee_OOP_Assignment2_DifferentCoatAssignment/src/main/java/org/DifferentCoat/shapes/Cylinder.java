/*

 */

package org.DifferentCoat.shapes;

public class Cylinder extends Shape {

    // fields
    private double radius;

    private ShapeEnum shapeName = ShapeEnum.CYLINDER; // Shape name is represented by the shape enums

    // constructor
    public Cylinder(double height, double width) {
        super(height, width);
        radius = width / 2;
    }

    // Getters
    public String getShapeName() {
        return shapeName.toString();
    }

    public double getRadius() { return this.radius; }

    public ShapeEnum getShapeType() {
        return shapeName;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    public String toString() {
        return getShapeName();
    }
}

