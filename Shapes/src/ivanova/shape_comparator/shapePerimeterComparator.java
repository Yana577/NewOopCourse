package ivanova.shape_comparator;

import ivanova.shape.Shape;

import java.util.Comparator;

public class shapePerimeterComparator implements Comparator<Shape> {

    @Override
    public int compare(Shape shape1, Shape shape2){
        return (int) (shape1.getPerimeter() - shape2.getPerimeter());
    }
}