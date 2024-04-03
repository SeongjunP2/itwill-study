package com.itwill.loop14;

import java.util.Scanner;

public class LoopMap14 {

	public static void main(String[] args) {
		boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
		int balance = 0; // 은행 계좌의 잔고를 저장하기 위한 변수.
		Scanner scanner = new Scanner(System.in); // 콘솔 입력을 위해서.
		
		while(run) {
			System.out.println("---------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("---------------------------------");
			System.out.print("선택> ");
			int choice = scanner.nextInt();
			if (choice == 1) { // 입금 기능 구현
				System.out.println();
				System.out.print("입금: ");
				int in = scanner.nextInt();
				balance = balance + in;
			} else if (choice == 2) { // 출금 기능 구현
				System.out.println();
				System.out.print("출금: ");
				int out = scanner.nextInt();
				balance = balance - out;
			} else if (choice == 3) { // 잔고 확인 기능 구현
				System.out.println();
				System.out.print("잔고: ");
				System.out.println(balance);
			} else if (choice == 4) { // 프로그램 종료
				break;
			} else {
				System.out.println("잘못된 선택입니다.");
			}
			
			// switch 사용코드
//			switch (choice) {
//			case 1: // 입금 기능 구현
//				break;
//			case 2: // 출금 기능 구현
//				break;
//			case 3: // 잔고 확인 기능 구현
//				break;
//			case 4: // 프로그램 종료
//				run = false; // break;로 while 문을 종료시키지는 못하기때문에 run이란 변수를 false로 변경시켜 종료.
//				break; // switch 문장을 종료(while 문을 종료시키지는 못함)
//			default:
//			}
		}
		System.out.println("프로그램 종료");

	}

}
