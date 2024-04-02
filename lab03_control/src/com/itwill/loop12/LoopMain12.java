package com.itwill.loop12;

import java.util.Random;

public class LoopMain12 {

	public static void main(String[] args) {
        // 교재 연습문제 3
        // 주사위 2개를 던졌을 때 결과를 (x, y) 형식으로 출력.
        // 주사위 2개의 눈의 합이 5가 되면 실행을 멈춤.
        // (1, 2), (6, 2), ..., (2, 3)
		Random random = new Random();
//		int sum = 0;
		while (true) {
			int x = random.nextInt(1, 7);
			int y = random.nextInt(1, 7);
			System.out.printf("(%d, %d)\n", x, y);
			if (x + y == 5) {
				break; // 무한루프를 멈춤.
			}
		}
		
		int x;
		int y;
		do {
			x = random.nextInt(1, 7);
			y = random.nextInt(1, 7);
			System.out.printf("(%d, %d)\n", x, y);
		} while (x + y != 5);
		
//		while (sum == 5) {
//			int x = random.nextInt(1, 7);
//			int y = random.nextInt(1, 7);
//			sum = x + y;
//		}
		
		
        // 교재 연습문제 4
        // 4x + 5y = 60 방정식을 만족하는 x와 y를 찾기.
        // 단, x와 y는 10 이하의 자연수(1, 2, 3, ..., 9, 10)
        // (x=5, x=8), ...
		for (x = 1; x <= 10; x++) {
			for (y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.printf("(x=%d, y=%d)", x, y);
				}
			}
		}
		

	}

}
