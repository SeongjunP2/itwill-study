package com.itwill.switch02;

import java.util.Random;

public class SwitchMain02 {

	public static void main(String[] args) {
		// Random 타입의 변수를 선언하고, 초기화.
		Random r = new Random();
		
		// 정수 타입의 변수에 1부터 4까지의 정수 난수 1개를 저장.
		int code = r.nextInt(1, 5); // 1 이상 5미만의 난수
		System.out.println("code= " + code);
		
		switch(code) {
		case 1:
		case 3:
			System.out.println("남자");
			break;
		case 2:
		case 4:
			System.out.println("여자");
		}  // 강사님 코드
		
		
		
		
		switch(code) {
		case 1, 3:
			System.out.println("성별: 남자");
			break;
		default:
			System.out.println("성별: 여자");
		}  // 작성 코드

	}

}
