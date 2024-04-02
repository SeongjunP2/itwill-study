package com.itwill.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
		// 정수 10개를 저장할 수 있는 배열(codes)을 만들고 기본값으로 초기화.
		Random random = new Random();
		int[] codes = new int[10];
		
		// 배열 codes에 1 이상 4 이하 범위 정수를 임의로 저장.
		for (int i = 0; i < codes.length; i++) {
			codes[i] = random.nextInt(1, 5);
		}
		
		// codes 내용을 출력.
		System.out.print("출력: ");
		for (int x : codes) {
			System.out.print(x + " ");
		}
		System.out.println();
		// 문자열(String) 10개를 저장할 수 있는 배열(genders)를 만들고 기본값으로 초기화.
		String[] genders = new String[10];
		
		// codes의 원소가 1, 3이면 "남성"을, 원소가 2 또는 4 이면 "여성"를 genders에 저장.
		for (int i = 0; i < codes.length; i++) {
				if (codes[i] == 1 || codes[i] == 3) {
					genders[i] = "남성";
				} else {
					genders[i] = "여성";
				}
		}
		
		// genders 내용을 출력.
		for (String g : genders) {
			System.out.print(g + " ");
		}
		

	}

}
