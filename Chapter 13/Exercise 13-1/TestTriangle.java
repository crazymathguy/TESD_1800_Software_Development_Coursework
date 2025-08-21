/*
 * Author: Sean Briggs
 * Date Created: 8/20/25
 * 
 * This project tests abstract classes by extending the Triangle class
 * from the GeometricObject class
 */

import java.util.*;

public class TestTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Side 1: ");
        double side1 = input.nextDouble();
        System.out.print("Side 2: ");
        double side2 = input.nextDouble();
        System.out.print("Side 3: ");
        double side3 = input.nextDouble();
        System.out.print("Color: ");
        String color = input.nextLine();
        System.out.print("Filled? (true/false): ");
        boolean filled = input.nextBoolean();

        Triangle t = new Triangle(side1, side2, side3);
        t.setColor(color);
        t.setFilled(filled);
        System.out.println(t.toString());
    }
}

abstract class GeometricObject {
    private String color;
    private boolean filled;
    private final Date dateCreated;

    protected GeometricObject() {
        color = "white";
        filled = false;
        dateCreated = new Date();
    }

    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        dateCreated = new Date();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Color: " + color + ", filled: " + filled + ", dateCreated: " + dateCreated + ", area: " + getArea() + ", perimeter: " + getPerimeter();
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        side1 = 1;
        side2 = 1;
        side3 = 1;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
}
