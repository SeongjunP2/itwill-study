package com.itwill.ver04.view;

import java.util.List;
import java.util.Scanner;

import com.itwill.ver04.controller.ContactDao;
import com.itwill.ver04.controller.ContactDaoImpl;
import com.itwill.ver04.model.Contact;

// MVC 아키텍쳐에서 View 역할.
public class ContactMain04 {
	
	private final Scanner scanner = new Scanner(System.in);
	private ContactDao dao = ContactDaoImpl.getInstance();

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.4 ***");
		
		ContactMain04 app = new ContactMain04();
		
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
			case 5:
				app.removeContactByIndex();
				break;
			default:
				System.out.println("0~5 범위의 정수로 입력하세요...");
			}
		}
		
		System.out.println(">>> 프로그램 종료 >>>");

	}
	
	private void saveNewContact() {
		System.out.println("\n----- 새 연락처 저장 -----");
		
		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();

		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();
		
		System.out.print("이메일 입력>> ");
		String email = scanner.nextLine();

		Contact contact = new Contact(0, name, phone, email);
		int result = dao.create(contact);
		if (result == 1) {
			System.out.println("연락처 정보 저장 성공");
		} else {
			System.out.println("연락처 정보 저장 실패");
		}
		
	}

	private void readAllContacts() {
		System.out.println("\n--- 연락처 목록 ---");
		List<Contact> contacts = dao.read();
		for (Contact c : contacts) {
			System.out.println(c);
		}

	}

	private void readContactByIndex() {
		System.out.println("\n--- 인덱스 검색 ---");

		System.out.println("검색할 인덱스 입력>> ");
        int index = inputInteger();
		
        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        }

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
        int index = inputInteger();
		
        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        }
        
        Contact contact = dao.read(index);
        
		System.out.println("수정 전: " + contact);

		System.out.println("전화번호 수정>> ");
//		contact.setPhone(scanner.nextLine());
		String name = scanner.nextLine();
		
		System.out.println("이름 수정>> ");
//		contact.setName(scanner.nextLine());
        String phone = scanner.nextLine();
		
		System.out.println("이메일 수정>> ");
//		contact.setEmail(scanner.nextLine());
		String email = scanner.nextLine();

        Contact update = new Contact(0, name, phone, email); // contact 객체에 새로 수정한 정보들을 저장
		int result = dao.update(index, update); // contact 객체의 update 정보들을 dao.update 메서드에 전달
		if (result == 1) {
			System.out.println("연락처 업데이트 성공");
		} else {
			System.out.println("연락처 업데이트 실패");
		}
	}
	
	private void removeContactByIndex() {
		System.out.println("\n--- 연락처 정보 삭제 ---");
		
		System.out.println("삭제할 인덱스>> ");
        int index = inputInteger();
		
        if (!((ContactDaoImpl) dao).isValidIndex(index)) {
            System.out.println("해당 인덱스에는 연락처 정보가 없습니다.");
            return;
        }
		
		Contact contact = dao.read(index);
		System.out.println("삭제할 연락처: " + contact);
		
		int result = dao.delete(index);
		if (result == 1) {
			System.out.println("연락처 삭제 성공");
		} else {
			System.out.println("연락처 삭제 실패");
		}
	}

	int showMainMenu() {
		System.out.println("\n----------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정 [5]삭제");
		System.out.println("----------------------------------------------");
		System.out.print("선택> ");

		int menu = inputInteger();

		return menu;
	}
	
    private int inputInteger() {
        int result = 0;
        
        while(true) {
            try {
                result = Integer.parseInt(scanner.nextLine()); // 입력받은 문자열을 정수로 변환
                break;
            } catch (NumberFormatException e) { // 정수 이외의 값 입력시 catch하는 곳
                System.out.println("입력값은 정수여야 합니다.");
                System.out.print("정수 입력>> ");
            }
        }
        
        return result;
    }

}
