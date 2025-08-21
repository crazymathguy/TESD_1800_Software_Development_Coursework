/*
 * Author: Sean Briggs
 * Date Created: 8/21/25
 * 
 * This project creates octagons that are comparable and cloneable
 */

import java.util.*;

public class TestOctagon {
    public static void main(String[] args) {
        Octagon octagon = new Octagon(5);
        Octagon newOctagon = octagon.clone();
        System.out.println(octagon.compareTo(newOctagon));
    }
}

abstract class GeometricObject{
    private String color;
    private boolean filled;
    private Date dateCreated;

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

    protected void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Color: " + color + ", filled: " + filled + ", dateCreated: " + dateCreated + ", area: " + getArea() + ", perimeter: " + getPerimeter();
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}

class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;

    public Octagon() {
        side = 0;
    }

    public Octagon(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return side * 8;
    }

    @Override
    public int compareTo(Octagon o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public Octagon clone() {
        try {
            Octagon octagonClone = (Octagon)super.clone();
            octagonClone.setDateCreated((Date)octagonClone.getDateCreated().clone());
            return octagonClone;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}