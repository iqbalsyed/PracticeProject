package phase1project;

import java.util.ArrayList;

public class Shape {
	    public void displayArea() {
	        System.out.println("Area: " + calculateArea());
	    }

	    public double calculateArea() {
	        return 0;
	    }
	}

class Rectangle extends Shape {
	private double length;
	private double width;

	public Rectangle(double length, double width)
	 
	{
	        this.length = length;
	        this.width = width;
	    }

	    
	public double calculateArea()
	 
	{
	        return length * width;
	    }
}

class Circle extends Shape
	 
	{

	    private double radius;

	    public Circle(double radius)
	 
	{
	        this.radius = radius;
	    }

	    
	public double calculateArea()
	 
	{
	        return Math.PI * radius * radius;
	    }
}

class Main {

	    public static void main(String[] args) {
	        try {
	            ArrayList<Shape> shapes = new ArrayList<>();
	            shapes.add(new Rectangle(4, 15));
	            shapes.add(new Circle(6));

	            for (Shape shape : shapes) {
	                shape.displayArea();
	            }
	        } catch (Exception e) {
	            System.out.println("Error");
	        } finally {
	            System.out.println("Executed");
	        }
	    }
}

