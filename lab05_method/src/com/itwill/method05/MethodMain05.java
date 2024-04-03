package com.itwill.method05;

public class MethodMain05 {

	public static void main(String[] args) {
		// TODO 매서드 호출, 그 결과를 출력:
		// sum 메서드 호출, 결과 출력.
		int[] array = {1, 2, 3, 4, 5};
		int result = sum(array);
		System.out.println(result);
		System.out.println();
		
//		result = avg(array);
//		System.out.println((double)result);
		double average = mean(array);
		System.out.println(average);
		System.out.println();
		
		result = max(array);
		System.out.println(result);
		System.out.println();
		
//		System.out.println(max(array)); // 위와 다른 최댓값 표현방법
		
		result = min(array);
		System.out.println(result);
		System.out.println();
		
	}
	
	/**
	 * sum.
	 * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합을 리턴.
	 * @param array 정수들의 1차원 배열(int[]).
	 * @return array의 모든 원소들의 합.
	 */
	public static int sum(int[] array) {
		int sum = 0;
		for (int y = 0; y < array.length; y++) {
			sum = sum + array[y];
		}
		return sum;
	}
	
	/**
	 * mean.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들의 평균을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들의 평균을 double 타입으로 리턴.
	 */
	public static double mean(int[] array) {
		double avg = (double) sum(array) / array.length;  // 이미 만들어진 sum메서드를 사용하여 합을 구하고 배열의 길이만큼 나누면 평균값.
		return avg;
	}
	
//	public static int avg(int[] x) {
//		int avg = 0;
//		for (int y = 0; y < x.length; y++) {
//			avg = avg + x[y];
//		}
//		return avg/5;
//	}
	
	/**
	 * max.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최댓값을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들 중 최댓값.
	 */
	public static int max(int[] array) {
		int max = array[0]; // array 배열의 첫번째[0] 원소를 max에 대입
		for (int y = 0; y < array.length; y++) { // 배열의 길이만큼 반복
			if (max < array[y]) { // max보다 비교대상(array[y]이 더 큰 값이면
				max = array[y]; // max에 비교대상을 넣는다(최댓값 산출까지 반복)
			}
		}
		return max;
	}
	
	/**
	 * min.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최솟값을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들 중 최솟값.
	 */
	public static int min(int[] array) {
		int min = 0;
		for (int y = 0; y < array.length; y++) {
			if (min > array[y]) { // min보다 비교대상(array[y]이 더 작은 값이면
				min = array[y]; // min에 비교대상을 넣는다(최솟값 산출까지 반복)
			}
		}
		return min;
	}
	
//    public static int min(int[] array) { // 향상된 for문을 사용하여 최솟값 구하기
//        int result = array[0];
//        for (int x : array) {
//            if (x < result) {
//                result = x;
//            }
//        }
//        
//        return result;
//    }

}
