package ivanova.shape_rectangle;

import ivanova.shape.Shape;

public class Rectangle implements Shape {
    private double firstSideLength;
    private double secondSideLength;

    public Rectangle(double firstSideLength, double secondSideLength) {
        this.firstSideLength = firstSideLength;
        this.secondSideLength = secondSideLength;
    }

    public double getWidth() {
        return Math.min(firstSideLength, secondSideLength);
    }

    public double getHeight() {
        return Math.max(firstSideLength, secondSideLength);
    }

    public double getArea() {
        return firstSideLength * secondSideLength;
    }

    public double getPerimeter() {
        return 2 * (firstSideLength + secondSideLength);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "; a = " + getHeight() + ", b = " + getWidth();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Rectangle rectangle = (Rectangle) object;
        {
            return getWidth() == rectangle.getWidth() && getHeight() == rectangle.getHeight();
        }
    }

    @Override
    public int hashCode() {
        final int prime = 17;
        int hash = 1;

        hash = prime * hash + Double.hashCode(firstSideLength);
        hash = prime * hash + Double.hashCode(secondSideLength);

        return hash;
    }
}