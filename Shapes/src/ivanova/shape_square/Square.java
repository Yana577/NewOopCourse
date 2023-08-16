package ivanova.shape_square;

import ivanova.shape.Shape;

public class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getWidth() {
        return sideLength;
    }

    public double getHeight() {
        return sideLength;
    }

    public double getArea() {
        return Math.pow(sideLength, 2);
    }

    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "; a = " + sideLength;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Square square = (Square) object;
        {
            return sideLength == square.sideLength;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 17;

        return prime * Double.hashCode(sideLength);
    }
}