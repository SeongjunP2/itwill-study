package com.itwill.array03;

import java.util.Random;

public class ArrayMain03 {

	public static void main(String[] args) {
		// 성적처리 프로그램:
		// 점수는 난수로 만들고 배열에 저장. 배열에 저장된 점수들의 합계와 평균을 출력.
		
		// Random 타입 변수 선언 & 초기화
		Random random = new Random();
		int total = 0;
		
		// int 타입 5개를 저장할 수 있는 배열(scores)을 선언 & 기본값으로 초기화
		int [] scores = new int[5];
		
		// for 문을 사용해서 5개의 정수 난수(0 ~ 10)를 배열에 저장.
		for (int i = 0; i < scores.length; i++) {
			scores[i] = random.nextInt(11);
		}
		
		// 향상된 for 문을 사용해서 배열에 저장된 모든 점수들을 출력.
		System.out.print("점수들: ");
		for (int x : scores) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		// 배열의 모든 원소들의 합계를 계산하고 출력
		for (int i = 0; i < scores.length; i++) {
			total = total + scores[i];
		}
		System.out.print("합계: " + total);
		
		// 배열의 원소들의 평균을 계산하고 출력
		double mean = (double)total / scores.length;
		System.out.println("mean= " + mean);
		
		System.out.print("평균: " + (double)total/5);

	}

}
