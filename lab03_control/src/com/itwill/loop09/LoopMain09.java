package com.itwill.loop09;

public class LoopMain09 {

	public static void main(String[] args) {
		// 중첩 while 문장을 사용해서 구구단 1단부터 12단까지 출력.
		int n = 1;
		while (n <= 12) {
			System.out.println(n + "단 -----");
			
			int x = 1;
			while (x <= 12) {
				System.out.printf("%d x %d = %d\n", n, x, n * x);
				x++;
			}
			n++;
		}

	}

}
