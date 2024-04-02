package com.itwill.method03;

public class MethodMain03 {

	public static void main(String[] args) {
		// 반환값이 없는 메서드 작성, 호출 연습
		countdown(5); // main 메서드에서 countdown 메서드 호출 및 숫자 5입력

	}
	
	public static void countdown(int x) { // main 메서드에서 x로 숫자 5 받음.
		if (x <= 0) {
			System.out.println("카운트다운 시작값은 양의 정수여야 합니다.");
			return;
			// return 문장의 의미:
			// (1) 메서드를 종료.
			// (2) return 문장의 값이 있으면, 메서드를 호출한 곳으로 값을 반환.
			// (3) void 메서드는 값이 없는 return 문만 사용 가능.
		}
		
		
		for (int y = x; y >= 0; y--) {
			System.out.println(y);
		}
			
	}

}
