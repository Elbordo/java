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

import java.util.Scanner;

public class Triangle1 extends GeometricObject {
	private double side1 = 1.0;
	private double side2 = 1.0;
	private double side3 = 1.0;
	public Triangle1() {}
	public Triangle1(double s1, double s2, double s3) {
		side1 = s1;
		side2 = s2;
		side3 = s3;
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
		Scanner in = new Scanner(System.in);
			System.out.println("Enter 3 sides of trinagle: ");
			double s1 = in.nextDouble();
			double s2 = in.nextDouble();
			double s3 = in.nextDouble();
			System.out.print("Enter trinagle color: ");
			in.nextLine();
			String color = in.nextLine();
			System.out.print("Triangle filled?(true/false): ");
			boolean isFilled = in.nextBoolean();
			Triangle1 triangle = new Triangle1(s1, s2, s3);
			triangle.setFilled(isFilled);
			triangle.setColor(color);
			System.out.println("\n******************************************");
			System.out.println(triangle.toString());
			System.out.printf("Area: %.2f\n", triangle.getArea());
			System.out.printf("Perimeter: %.2f\n", triangle.getPerimeter());
			System.out.println("Color: " + triangle.getColor());
			System.out.println("Filled: " + triangle.isFilled());			
			System.out.println("******************************************\n");
	}
}
