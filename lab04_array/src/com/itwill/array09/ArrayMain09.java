package com.itwill.array09;

import java.util.Random;

public class ArrayMain09 {

	public static void main(String[] args) {
		Random random = new Random();
		
		// 1차원 정수(int) 배열 3개를 갖는 2차원 배열을 선언 & 초기화.
		int[][] array = new int[3][];
		
		// 2차원 배열 array의 첫번째 배열에는 난수 2개, 두번째 배열에는 난수 3개,
		array[0] = new int[2];
		array[1] = new int[3];
		
		// 세번째 배열에는 난수 4개를 저장. 난수의 범위는 0이상 10미만.
		array[2] = new int[4];
		
		for(int x = 0; x < array.length; x++) {  // 2차원배열의 전체 길이(length)까지 인덱스(x) 증가
//			array[x] = new int[x + 2];  // 2차원 배열 아래 1차원 배열을 for문을 통해 생성
			for (int y= 0; y < array[x].length; y++) {  // 1차원배열의 전체 길이(length)까지 인덱스(y) 증가 
				array[x][y] = random.nextInt(0, 10);  // 위의 for문을 통해 2차열, 1차열 전체에 난수를 생성
//				System.out.print(array[x][y] + " ");
			}
		}
		
		// 2차원 배열 array의 내용을 출력.
		for (int[] arr : array) {
			for (int x : arr) {
				System.out.print(x + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// 2차원 배열의 모든 원소들(정수 9개)의 합을 계산하고 출력
		int sum = 0; // 배열의 원소들의 합을 저장할 변수
		int count = 0; // 배열의 원소 개수를 저장할 변수
		
//		향상된 for문을 사용한 합계
//		배열에 저장된 변수들을 그대로 읽어와서 합계를 구하는 것이기 때문에 향상된 for문으로 계산 가능
		for (int[] arr : array) {
			for (int x : arr) {
				sum = sum + x; // 배열에서 읽은 값을 sum에 더함.
				count++; // 배열에서 읽은 원소 개수를 증가.
			}
			System.out.println();
		}
		
		
//		for(int x = 0; x < array.length; x++) {
//			for (int y= 0; y < array[x].length; y++) {
//				sum = sum + array[x][y];
//			}
//		}
		System.out.println("합계: " + sum);
		System.out.println("count = " + count);
		System.out.println();
		
		// 2차원 배열의 모든 원소들(정수 9개)의 평균을 계산하고 출력
//		double mean = (double) sum / count;
//		System.out.println("평균: " + mean);
		
		System.out.println("평균: " + (double)sum/count);

	}

}
