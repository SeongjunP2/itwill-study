package com.itwill.loop11;

public class LoopMain11 {

	public static void main(String[] args) {
		// Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력
		// 1 + 2 + 3 + ... + 9 + 10 = 55
		int sum = 0;
		int x = 1;
		while (x <= 10) {
			sum = sum + x;
			x++;
		}
		System.out.println(sum);
		
		sum = 0;
		for (int x1 = 1; x1 <= 10; x1++) {
			sum += x1; // sum = sum + x1;
		}
		System.out.println(sum);
			
		System.out.println();
		System.out.println();
		
		// Ex2. 1부터 100까지 자연수들 중에서 짝수들의 합을 계산하고 출력.
		// 2 + 4+ 6 + ... + 98 + 100 = ?
		sum = 0;
		for (int x1 = 2; x1 <= 100; x1+= 2) {
			sum += x1;
		}
		System.out.println(sum);
//		
//		
		sum = 0;
		for (int x1 = 1; x1 <= 100; x1++) {
			if (x1 % 2 ==0) {
				sum += x1;
			}
		}
		System.out.println(sum);
//		
		x = 1;
		sum = 0;
		while (x <= 100) {
			if (x % 2 == 0) {
				sum = sum + x;
			}
				x++;
		}
		System.out.println(sum);
		
		// Ex2. 1부터 100까지 자연수들 중에서 짝수들의 합을 계산하고 출력.
		// 1 + 3 + 5 + ... + 97 + 99 = ?
		sum = 0;
		x = 1;
		while (x <= 100) {
			if (x % 2 == 1) {
				sum = sum + x;
			}
			x++;
		}
		System.out.println(sum);

		sum = 0;
		x= 1;
		while (x < 100) {
			sum += x;
			x += 2;
		}
		System.out.println(sum);
		
	}

}
