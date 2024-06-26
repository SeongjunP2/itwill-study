package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain {
	private static final int MAX_LENGTH = 3; // 연락처 배열의 최대 길이(원소 개수)

	private Scanner scanner = new Scanner(System.in);
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장하기 위한 배열
	private int count = 0; // 현재까지 연락처 배열에 저장된 개수.
	// 배열에 새로운 연락처 저장될 때마다 count++를 실행.

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.1 ***");

		ContactMain app = new ContactMain();

		// 프로그램 계속 실행(run=true) 또는 종료(run=false) 여부를 저장하기 위한 변수.
		boolean run = true;
		while (run) {
			// TODO 메인 메뉴 보여주기
			int menu = app.showMainMenu();
			// switch ()
			switch (menu) {
			case (0):
				run = false;
				break;
			case (1):
				app.saveNewContact();
				break;
			case (2):
				app.readAllContacts();
				break;
			case (3):
				app.readContactByIndex();
				break;
			case (4):
				app.editContactByIndex();
				break;
			default:
				System.out.println("메뉴 번호(0 ~ 4)를 확인하세요.");
			}
		}

		System.out.println("*** 프로그램 종료 ***");
	}

	private void saveNewContact() {
		System.out.println("\n--- 새 연락처 저장---");

		if (count == MAX_LENGTH) {
			System.out.println("연락처를 더 이상 저장할 수 없습니다!");
//			return;  // else까지 사용하지 않고 if문 안쪽에 return만 사용하여 조건이 맞으면 메서드를 끝낼 수도 있음
		} else {

			System.out.println("이름 입력>> ");
			String name = scanner.nextLine();

			System.out.println("전화번호 입력>> ");
			String phone = scanner.nextLine();

			System.out.println("이메일 입력>> ");
			String email = scanner.nextLine();

			Contact contact = new Contact(name, phone, email);

			// Contact 타입 객체를 연락처 배열 인덱스 count
			contacts[count] = contact;
			// 배열에 저장 후에는 연락처 저장 개수(인덱스)를 증가
			count++;
			
			System.out.println("연락처 저장 성공!");
		}
	}

	private int showMainMenu() {
		System.out.println("\n----------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("----------------------------------------------");
		System.out.print("선택> ");

		int menu = Integer.parseInt(scanner.nextLine());

		return menu;
	}

	private void readAllContacts() {
		System.out.println("\n--- 연락처 목록 ---");
		// 인덱스 0번부터 현재 저장된 연락처 개수보다 작을 때까지
		for (int i = 0; i < count; i++) {
			System.out.println(contacts[i].toString());
		}
	}

	private void readContactByIndex() {
		System.out.println("\n--- 인덱스 검색 ---");
		System.out.println("인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());
		if (index >= MAX_LENGTH || index < 0 || contacts[index] == null) {
			System.out.println("잘못된 인덱스 입니다.");
		} else {
			System.out.println(contacts[index].toString());
		}
		
//		if (index < 0 || index >= count) {
//			System.out.println(contacts[index].toString());
//		} else {
//			System.out.println("잘못된 인덱스 입니다.");
//		}

	}

	private void editContactByIndex() {
		System.out.println("\n--- 수정 ----");
		System.out.println("인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());

		if (index >= MAX_LENGTH || contacts[index] == null) {
			System.out.println("잘못된 인덱스 입니다.");
		} else {
			System.out.println("수정전: " + contacts[index].toString());

			System.out.println("이름 수정>> ");
			String name = scanner.nextLine();

			System.out.println("전화번호 수정>> ");
			String phone = scanner.nextLine();

			System.out.println("이메일 수정>> ");
			String email = scanner.nextLine();

			contacts[index].setName(name);
			contacts[index].setPhone(phone);
			contacts[index].setEmail(email);
			
			// 동작 방식은 다르지만 똑같이 수정이 가능한 코드
//			contacts[index] = new Contact(name, phone, email); // new Contact로 인해 새로운 주소(객체)가 할당되고 새로운 값들이 저장된다.

			contacts[index] = contacts[index];
		}
	}

}