import java.awt.*;

public class TestRectangle {
	public static void main(String[] args) {
		Rectangle r1 = new Rectangle(4, 40);
		Rectangle r2 = new Rectangle(3.5, 35.9);
		
		System.out.println("Rectangle 1: " + r1.getWidth());
		System.out.println(r1.getHeight());
		System.out.println(r1.getArea());
		System.out.println(r1.getPerimeter());
		System.out.println("Rectangle 2: " + r2.getWidth());
		System.out.println(r2.getHeight());
		System.out.println(r2.getArea());
		System.out.println(r2.getPerimeter());
	}
}

class Rectangle {
	private double width;
	private double height;
	
	Rectangle() {
		width = 1;
		height = 1;
	}
	
	Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	double getWidth() {
		return width;
	}
	
	double getHeight() {
		return height;
	}
	
	double getArea() {
		return width * height;
	}
	
	double getPerimeter() {
		return 2 * (width + height);
	}
}