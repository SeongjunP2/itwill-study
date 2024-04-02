package com.itwill.class04;

public class Rectangle {
	// field
	double width; // 직사각형의 가로 길이
	double height; // 직사각형의 세로 길이
	
	// 생성자
	// (1) 기본 생성자
	public Rectangle() {
		
	}
	// (2) 가로/세로를 아규먼트로 전달받아서 초기화하는 생성자
	public Rectangle(double width, double height) { // 지역변수로 width와 height를 사용하였기 때문에,
		this.width = width; // this를 사용하여 필드에 있는 width와 height를 각각 지정
		this.height = height;
	}
	
	// 매서드
	// (1) 넓이를 리턴
	public double area() { // 넓이를 계산하는 double타입의 area매서드 생성
		return width * height; // 넓이를 계산하고 리턴
	}
	// (2) 둘레길이를 리턴
	public double round() { // 둘레길이를 계산하는 double타입의 round매서드 생성
		return (width + height) * 2; // 둘레를 계산하고 리턴
	}

}
