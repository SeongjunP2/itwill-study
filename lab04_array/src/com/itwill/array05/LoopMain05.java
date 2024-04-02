package com.itwill.array05;

import java.util.Random;

public class LoopMain05 {

    public static void main(String[] args) {
        // 과제:
        // 정수(int) 5개를 저장할 수 있는 배열을 선언하고, 기본값으로 초기화.
    	Random random = new Random();
    	int[] num = new int[5];
    	
        // 배열에 0 이상 10이하의 난수 5개를 저장.
    	for (int i = 0; i < num.length; i++) {
    		num[i] = random.nextInt(11);
    	}
    	
        // 배열 원소들 중 최댓값을 찾아서 출력.
    	int[] max = new int[1]; // 난수 5개와 비교하기위한 배열1
    	int[] min = new int[1]; // 난수 5개와 비교하기위한 배열2
    	
    	max[0] = num[2];
    	min[0] = num[2];
    	
    	for (int i = 0; i < num.length; i++) {
    		if (max[0] < num[2]) {
    			
    		}
    	}
    	
        // 배열 원소들 중 최솟값을 찾아서 출력.
    	for (int i = 0; i < num.length; i++) {
    		System.out.println(i);
    	}
        
    }

}