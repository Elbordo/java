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

public abstract class GeometricObject {
	private String color = "white";
	private boolean filled;
	public GeometricObject() {}
	protected GeometricObject(String c, boolean f) {
		color = c;
		filled = f;
	}
	public abstract double getArea();
	public abstract double getPerimeter();
	public String getColor() {
		return color;
	}
	public void setColor(String c) {
		color = c;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean f) {
		filled = f;
	}
}
