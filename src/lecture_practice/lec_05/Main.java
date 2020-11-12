package lecture_practice.lec_05;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Ellipse ellipse = new Ellipse(12, 10);
        Rectangle rectangle = new Rectangle(15, 10);
        Triangle triangle = new Triangle(20, 8);
        Square square = new Square(14);

        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(circle);
        shapeList.add(ellipse);
        shapeList.add(rectangle);
        shapeList.add(triangle);
        shapeList.add(square);

        for(Shape shape : shapeList){
            shape.print();
        }

        System.out.println("circle vs square " + circle.compare(square));
        System.out.println("triangle vs square " + triangle.compare(square));
    }
}
