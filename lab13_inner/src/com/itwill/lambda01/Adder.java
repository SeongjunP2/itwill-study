package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

public class Adder implements Calculable {
	
	@Override
	public double calculate(double x, double y) {
		return x + y;
	}
	
	// 여러 패키지에서 다양하게 사용할거면 
	// 이와같이 별도의 클래스로 기능을 구현해주면 여러 곳에서 사용하기 편하다

}
