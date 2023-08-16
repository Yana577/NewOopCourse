package ivanova.shape_main;

import ivanova.shape.Shape;
import ivanova.shape_circle.Circle;
import ivanova.shape_rectangle.Rectangle;
import ivanova.shape_square.Square;
import ivanova.shape_triangle.Triangle;
import ivanova.shape_comparator.shapeAreaComparator;
import ivanova.shape_comparator.shapePerimeterComparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Triangle(0, 10, 0, 4, 4, 0),
                new Rectangle(14, 6),
                new Rectangle(2, 3),
                new Square(2),
                new Square(1),
                new Circle(1),
                new Circle(2)};

        System.out.println("Самая большая в массиве фигура: " + getMaxAreaShape(shapes).toString());
        System.out.println("ширина фигуры = " + getMaxAreaShape(shapes).getWidth());
        System.out.println("высота фигуры = " + getMaxAreaShape(shapes).getHeight());
        System.out.println("площадь фигуры = " + getMaxAreaShape(shapes).getArea());
        System.out.println("периметр фигуры = " + getMaxAreaShape(shapes).getPerimeter());
        System.out.println("_______________________________");

        System.out.println("Со вторым по величине периметром в массиве фигура: " + getSecondPerimeterShape(shapes).toString());
        System.out.println("ширина фигуры = " + getSecondPerimeterShape(shapes).getWidth());
        System.out.println("высота фигуры = " + getSecondPerimeterShape(shapes).getHeight());
        System.out.println("площадь фигуры = " + getSecondPerimeterShape(shapes).getArea());
        System.out.println("периметр фигуры = " + getSecondPerimeterShape(shapes).getPerimeter());
        System.out.println("_______________________________");

        System.out.println(shapes[0].toString());
        System.out.println(shapes[1].toString());
        System.out.println(shapes[2].toString());
        System.out.println(shapes[3].toString());
        System.out.println(shapes[4].toString());
        System.out.println(shapes[5].toString());
        System.out.println(shapes[6].toString());

        Shape newCircle = new Circle(1);
        System.out.println(newCircle.equals(shapes[1]));
    }

    public static Shape getMaxAreaShape(Shape[] shapes) {
        Comparator shapeAreaComparator = new shapeAreaComparator();

        Arrays.sort(shapes, shapeAreaComparator);

        return shapes[shapes.length - 1];
    }

    public static Shape getSecondPerimeterShape(Shape[] shapes) {
        Comparator shapePerimeterComparator = new shapePerimeterComparator();

        Arrays.sort(shapes, shapePerimeterComparator);

        return shapes[1];
    }
}