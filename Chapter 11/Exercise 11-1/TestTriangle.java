import java.util.*;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Side1: ");
        double side1 = input.nextDouble();
        System.out.print("Side2: ");
        double side2 = input.nextDouble();
        System.out.print("Side3: ");
        double side3 = input.nextDouble();
        System.out.print("Color: ");
        String color = input.next();
        System.out.print("Filled? (true/false): ");
        boolean filled = input.nextBoolean();
        input.close();

        Triangle triangle = new Triangle(side1, side2, side3, color, filled);
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Date Created: " + triangle.getDateCreated());
        System.out.println("Filled? " + triangle.isFilled());
    }
}

class GeometricObject {
    private String color = "white";
    private boolean filled;
    private Date dateCreated = new Date();

    GeometricObject() { }

    GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    String getColor() {
        return color;
    }

    boolean isFilled() {
        return filled;
    }

    Date getDateCreated() {
        return dateCreated;
    }
}

class Triangle extends GeometricObject {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    Triangle() { }

    Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    double getSide1() {
        return side1;
    }

    double getSide2() {
        return side2;
    }

    double getSide3() {
        return side3;
    }

    double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    double getPerimeter() {
        return side1 + side2 + side3;
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}