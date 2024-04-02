package com.itwill.inheritance08;

public class Circle extends Shape {
	// field
	private double radius; // 반지름
	
	public Circle(double radius) {
		super("원");
		this.radius = radius;
	}
	
	// 원의 넓이
	@Override
	public double area() {
		return Math.PI * radius * radius; // 자바자체 기능 Math클래스에 있는 파이 변수 사용.
//		return radius * radius * 3.14;
	}
	
	// 원의 둘레
	@Override
	public double perimeter() {
		return Math.PI * radius * 2;
//		return radius * 2 * 3.14;
	}

}
