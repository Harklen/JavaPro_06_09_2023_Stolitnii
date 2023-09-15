package ua.hillel.stolitnii.homeworks.homework3.polymorphism;

import org.jetbrains.annotations.NotNull;

interface GeometricFigure {
    double getArea();
}
class Circle implements GeometricFigure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle implements GeometricFigure {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

class Square implements GeometricFigure {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
interface TotalAreaCalculator {
    double calculateTotalArea(GeometricFigure[] figures);
}
class AreaCalculator implements TotalAreaCalculator {
    @Override
    public double calculateTotalArea(@org.jetbrains.annotations.NotNull GeometricFigure @NotNull [] figures) {
        double totalArea = 0.0;
        for (GeometricFigure figure : figures) {
            totalArea += figure.getArea();
        }
        return totalArea;
    }
}

public class Main {
    public static void main(String[] args) {
        GeometricFigure[] figures = new GeometricFigure[]{
                new Circle(9.0),
                new Triangle(3.0, 7.0),
                new Square(5.0)
        };

        TotalAreaCalculator calculator = new AreaCalculator();
        double totalArea = calculator.calculateTotalArea(figures);


        System.out.println("Сумарна площа всіх фігур: " + totalArea);
    }
}