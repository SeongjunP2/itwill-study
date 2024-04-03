package com.itwill.array05;

import java.util.Random;

public class ArrayMain05 {

    public static void main(String[] args) {
        // 과제:
        // 정수(int) 5개를 저장할 수 있는 배열을 선언하고, 기본값으로 초기화.
    	int[] num = new int[5];
    	
        // 배열에 0 이상 10 이하의 난수 5개를 저장.
    	Random random = new Random();  // 난수생성을 위한 코드 생성.
    	for (int i = 0; i < num.length; i++) {  // 인덱스(i)를 배열 최대 크기만큼 늘리기위한 for 반복문.
    		num[i] = random.nextInt(0, 11);  // 각 배열마다 0이상 11미만의 정수 생성.
    	}
    	
    	// 배열 원소들을 출력
    	for (int x : num) {
    		System.out.print(x + " ");
    	}
    	System.out.println();
    	
        // 배열 원소들 중 최댓값을 찾아서 출력.
    	int max = num[0];  // 배열의 첫번재 원소를 최댓값이라고 가정
    	for (int x: num) { // 배열의 모든 원소를 순서대로 하나씩 반복
    		if (x > max) {  // 배열에서 꺼낸 값이 (현재까지의) 최댓값보다 크다면
    			max = x;  // 최댓값을 배열에서 꺼낸 값으로 변경.
    		}
    	}
    	System.out.println("최댓값: " + max);
    	
    	
//    	int max = num[0];  // 최댓값을 담기위한 변수선언(배열의 첫번재 원소를 최댓값이라고 가정)
//    	for (int i = 0; i < num.length; i++) { // 최댓값을 구하기 위해 인덱스(i)를 늘려가면서
//    		if (max < num[i]) {
//    			max = num[i];  // max 변수에 더 큰 값으로 교체해나간다.
//    		}
//    	}
//    	System.out.println("최댓값: " + max);
    	
    	
        // 배열 원소들 중 최솟값을 찾아서 출력.
    	int min = num[0];  // 배열의 첫번재 원소를 최솟값이라고 가정
    	for (int x: num) { // 배열의 모든 원소를 순서대로 하나씩 반복
    		if (x < min) {  // 배열에서 꺼낸 값이 (현재까지의) 최솟값보다 작다면
    			min = x;  // 최솟값을 배열에서 꺼낸 값으로 변경.
    		}
    	}
    	System.out.println("최솟값: " + min);
    	
    	
    	
//    	int min = num[0];
//    	for (int i = 0; i < num.length; i++) {
//    		if (min > num[i]) {
//    			min = num[i];
//    		}
//    	}
//    	System.out.println("최솟값: " + min);
        
    }

}