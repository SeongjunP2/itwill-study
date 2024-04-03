package com.itwill.conditon07;

import java.util.Random;

public class ConditionMain07 {

	public static void main(String[] args) {
		// 조건문, 비교/논리 연산자 연습
		
		// 난수(random number)를 생성할 수 있는 타입의 변수를 선언, 초기화.
		Random rand = new Random();
		
		// rand.nextInt(x) 0 이상 x보다 작은 정후를 난수를 변환.
		// rand.nextInt(x, y): x이상 y 미만의 정수 난수를 반환.
		
		int java = rand.nextInt(101); // 0 이상 101 미만의 정수 난수를 저장.
		System.out.println("Java: " + java);
		
		int sql = rand.nextInt(101);
		System.out.println("sql: " + sql);
		
		int javascript = rand.nextInt(101);
		System.out.println("javascript: " + javascript);
		
		// 총점계산
		int total = java + sql + javascript;
		System.out.println("총점: " + total);
		
		// 평균계산
		double mean = (double) total / 3;
		System.out.println("평균: " + mean);
		
		
		// double score = java + sql + javascript >= 40 / 3.0;
		// 세 과목이 모두 40점 이상이고, 평균이 60점 이상이면 "합격",
		// 그렇지 않으면 "불합격'을 출력.
		
		if (java >= 40 && sql >= 40 && javascript >= 40 && mean >= 60) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}

	}

}
