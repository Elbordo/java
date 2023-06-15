/**********************************************
Workshop # 3
Course:JAC444ZAA - Semester 4
Last Name: Sorokan
First Name: Maksym
ID: 106544208
Section: CPP
This assignment represents my own work in accordance with Seneca Academic Policy. 
Signature - Maksym Sorokan
Date: 11.10.2022(dd.mm.yyyy)
**********************************************/ 
package test1;


public class Triangle2 extends GeometricObject {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	public Triangle2() {}
	public Triangle2(double s1, double s2, double s3) throws TriangleException {
		if (s1 + s2 > s3 && s2 + s3 > s1 && s1 + s3 > s2) {
			side1 = s1;
			side2 = s2;
			side3 = s3;
		} else {
			throw new TriangleException("In a triangle, the sum of any two sides should always be greater than the other side");
		}
	}
	public double getSide1() {
		return side1;
	}
	public double getSide2() {
		return side2;
	}
	public double getSide3() {
		return side3;
	}
	public double getArea() {      
		double s = (side1+side2+side3)/2;
		return Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
	}
	public double getPerimeter() {
		return side1+side2+side3;
	}
	public String toString() {
		return "Side1 = " + side1 + ", Side2 = " + side2 + ", Side3 = " + side3;
	}
	public static void main(String[] args) {
		try {
			Triangle2 triangle = new Triangle2(1.32, 2.1, 1.9);
			triangle.setColor("Red");
			triangle.setFilled(true);
			System.out.println("\n******************************************");
			System.out.println(triangle.toString());
			System.out.printf("Area: %.2f\n", triangle.getArea());
			System.out.printf("Perimeter: %.2f\n", triangle.getPerimeter());
			System.out.println("Color: " + triangle.getColor());
			System.out.println("Filled: " + triangle.isFilled());			
			System.out.println("******************************************\n");
		} catch (TriangleException ex) {
			System.out.println("Caught TriangleException!!!!!"); 
			System.out.println(ex.getMessage());
		}
		try {
			Triangle2 triangle = new Triangle2(1.8, 12.9, 3.33);
			triangle.setColor("Red");
			triangle.setFilled(true);
			System.out.println("\n******************************************");
			System.out.println(triangle.toString());
			System.out.printf("Area: %.2f\n", triangle.getArea());
			System.out.printf("Perimeter: %.2f\n", triangle.getPerimeter());
			System.out.println("Color: " + triangle.getColor());
			System.out.println("Filled: " + triangle.isFilled());			
			System.out.println("******************************************\n");
		} catch (TriangleException ex) {
			System.out.println("Caught TriangleException!!!!!"); 
			System.out.println(ex.getMessage());
		}
	}
}

class TriangleException extends Exception {
	TriangleException(String message){ 
		super(message); }
}
