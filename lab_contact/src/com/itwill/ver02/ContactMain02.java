package com.itwill.ver02;

import java.util.Scanner;

import com.itwill.ver01.Contact;

// MVC 아키텍쳐에서 View 역할.
public class ContactMain02 {
	
	private final Scanner scanner = new Scanner(System.in);
	private ContactDao dao = ContactDaoImpl.getInstance();

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.2 ***");
		
		ContactMain02 app = new ContactMain02();
		
		boolean run = true;
		while (run) {
			int menu = app.showMainMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewContact();
				break;
			case 2:
				app.readAllContacts();
				break;
			case 3:
				app.readContactByIndex();
				break;
			case 4:
				app.editContactByIndex();
				break;
				default:
					System.out.println("0~4 범위의 정수로 입력하세요...");
			}
		}
		
		System.out.println(">>> 프로그램 종료 >>>");

	}
	
	private void saveNewContact() {
		System.out.println("\n----- 새 연락처 저장 -----");
		ContactDaoImpl daoImpl = (ContactDaoImpl) dao;
        if (daoImpl.isMemoryFull()) {
            System.out.println("연락처 정보를 저장할 메모리가 부족합니다.");
            return;
        }
		
		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();

		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();
		
		System.out.print("이메일 입력>> ");
		String email = scanner.nextLine();

		Contact contact = new Contact(name, phone, email);
		int result = dao.create(contact); // View 객체에서 Controller 객체의 기능을 사용.
		if (result == 1) {
			System.out.println("연락처 정보 저장 성공");
		} else {
			System.out.println("연락처 정보 저장 실패");
		}
		
	}

	private void readAllContacts() {
		System.out.println("\n--- 연락처 목록 ---");
		Contact[] contacts = dao.read(); // View에서 Controller 기능을 사용, 출력할 데이터를 가져옴.
		for (Contact c : contacts) {
			System.out.println(c);
		}
		
	}

	private void readContactByIndex() {
		System.out.println("\n--- 인덱스 검색 ---");

		System.out.println("검색할 인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());

		Contact contact = dao.read(index);
		if (contact != null) {
			System.out.println(contact);
		} else {
			System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
		}
		
	}

	private void editContactByIndex() {
		System.out.println("\n--- 연락처 정보 수정 ---");

		System.out.println("업데이트할 인덱스>> ");
		int index = Integer.parseInt(scanner.nextLine());

		Contact contact = dao.read(index);
		System.out.println("수정 전: " + contact);

		System.out.println("전화번호 수정>> ");
		contact.setPhone(scanner.nextLine());
		
		System.out.println("이름 수정>> ");
		contact.setName(scanner.nextLine());
		
		System.out.println("이메일 수정>> ");
		contact.setEmail(scanner.nextLine());

		// View에서 Controller의 기능을 사용해서 비밀번호를 업데이트
		int result = dao.update(index, contact);
		if (result == 1) {
			System.out.println("연락처 업데이트 성공");
		} else {
			System.out.println("연락처 업데이트 실패");
		}
	}

	int showMainMenu() {
		System.out.println("\n----------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("----------------------------------------------");
		System.out.print("선택> ");

		int menu = Integer.parseInt(scanner.nextLine());

		return menu;
	}

}
