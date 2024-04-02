package com.itwill.class06;

//import java.util.Scanner; // 스캐너 임포트

public class ClassMain06 {

	public static void main(String[] args) {
		// 계좌 번호, 잔고 생성
		Account account1 = new Account(12345678, 10000);
		Account account2 = new Account(87654321, 20000);
		
		// 스캐너 연습
//		Scanner scn = new Scanner(System.in);
//		int i = scn.nextInt();
//		while (account1.accountNo == 12345678) {
//			if (account1.deposit(i)) {
//				
//			}
//		}
		
		account1.info();
		account1.deposit(1000);
		System.out.println("입금 후 잔고: " + account1.balance);
		account1.withdraw(500);
		System.out.println("출금 후 잔고: " + account1.balance);
		account1.transfer(account2, 2000);
		System.out.println("이체 후 잔고: " + account1.balance);
		account1.info();
		
		System.out.println();
		
		account2.info();
		account2.deposit(1000);
		System.out.println("입금 후 잔고: " + account2.balance);
		account2.withdraw(500);
		System.out.println("출금 후 잔고: " + account2.balance);
		account2.transfer(account1, 2000);
		System.out.println("이체 후 잔고: " + account2.balance);
		account2.info();
		

	}

}
