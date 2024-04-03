package com.itwill.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// 기본생성자를 사용해서 Rectangle 객체 생성, 매서드 호출
		Rectangle rectangle1 = new Rectangle();
		System.out.println(rectangle1);
		System.out.print("rectangle1 넓이: " + rectangle1.area());
		
		System.out.println();
		
		System.out.println("rectangle1 둘레: " + rectangle1.round());
		
		System.out.println();
		
		// 아규먼트를 갖는 생성자를 사용:
		Rectangle rectangle2 = new Rectangle(10, 20);
		System.out.println(rectangle2);
		System.out.print("rectangle2 넓이: " + rectangle2.area());
		
		System.out.println();
		
		System.out.println("rectangle2 둘레: " + rectangle2.round());

		rectangle2 = new Rectangle(3.0, 4.0);
		System.out.println(rectangle2);
		
//		String s = "a";
//		String s1 = "a";
//		String s2 = new String("a");
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s == s1);
//		System.out.println(s1 == s2);

	}

}
