package ivanova.shape_circle;

import ivanova.shape.Shape;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return 2 * radius;
    }

    public double getHeight() {
        return 2 * radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "; r = " + radius;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Circle circle = (Circle) object;
        {
            return radius == circle.radius;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 17;

        return prime * Double.hashCode(radius);
    }

}