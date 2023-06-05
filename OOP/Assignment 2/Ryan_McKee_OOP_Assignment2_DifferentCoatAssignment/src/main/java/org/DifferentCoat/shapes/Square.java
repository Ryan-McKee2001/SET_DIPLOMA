package org.DifferentCoat.shapes;

public class Square extends Shape {
    private ShapeEnum shape = ShapeEnum.SQUARE;

    public Square(double height, double width) {
        super(height, width);
    }

    public String getShapeName() {
        return shape.toString();
    }

    @Override
    public double getPerimeter() {
        // super.getPerimeter is 2 of the widths added together
        // this is just multiplied by 2 to get the total perimeter.
        return super.getPerimeter() * 2;
    }

    public String toString() {
        return getShapeName();
    }
}
