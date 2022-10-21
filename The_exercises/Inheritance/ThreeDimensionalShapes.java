package The_exercises.Inheritance;

import java.util.ArrayList;

abstract class Shape {
	private double volume;

	public Shape(double volume) {
		this.volume = volume;
	}

	public double getVolume() {
		return volume;
	}
}

abstract class SolidOfResolution extends Shape {
	private double radius;

	public SolidOfResolution(double volume, double radius) {
		super(volume);
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
}

class Pyramid extends Shape {
	private double s;

	private double h;
	public Pyramid(double volume, double s, double h) {
		super(1.0/3.0 * s * h);
		this.s = s;
		this.h = h;
	}

}

class Cylinder extends SolidOfResolution {
	private double height;

	public Cylinder(double radius, double height) {
		super(Math.PI * Math.pow(radius, 2) * height, radius);
		this.height = height;
	}
}

class Ball extends SolidOfResolution {
	public Ball(double volume, double radius) {
		super(4.0/3.0 * Math.pow(radius, 3) * Math.PI, radius);
	}
}

class Box extends Shape {
	private ArrayList<Shape> arrOfShapes;
	private double available;

	public Box(double volume, double available) {
		super(volume);

		arrOfShapes = new ArrayList<>();
		this.available = available;
	}

	public boolean add(Shape shape) {
		if (available >= shape.getVolume()) {
			arrOfShapes.add(shape);
			available -= shape.getVolume();
			return true;
		} else return false;
	}
}