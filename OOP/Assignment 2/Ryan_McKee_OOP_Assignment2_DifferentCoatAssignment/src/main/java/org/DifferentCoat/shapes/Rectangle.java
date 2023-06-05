package org.DifferentCoat.shapes;

public class Rectangle extends Shape {

    private ShapeEnum shapeName = ShapeEnum.RECTANGLE;

    private double length;

    public Rectangle(double height, double width, double length) {
        super(height, width);
        this.length = length;
    }

    public String getShapeName() {
        return shapeName.toString();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter() + (length * 2);
    }

    public String toString() {
        return shapeName.toString();
    }

    public double getLength() {
        return this.length;
    }
}
