package com.itwill.ver02;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {
	
	// singleton 구현
	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {}
	
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
	// 연락처 저장 배열 선언
	private Contact[] contacts = new Contact[MAX_LENGTH];
	
	// 배열 원소 추가 될 때마다 카운트
	private int count = 0;
	
    public boolean isMemoryFull() {
        return (count == MAX_LENGTH);
    }

	@Override
	public int create(Contact contact) {
		if (count < MAX_LENGTH) {
			contacts[count] = contact;
			count++;
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Contact[] read() {
		Contact[] contacts = new Contact[count];
		
		for(int i = 0; i < count; i++) { // 카운트가 쌓인 수만큼 배열 출력
			contacts[i] = this.contacts[i];
		}
		
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (index >= MAX_LENGTH || index < 0) {
			return null;
		}
		return contacts[index];
	}

	@Override
	public int update(int index, Contact contact) {
		if (index < 0 || index >= contacts.length || contacts[index] == null) {
			return 0;
		} else {
		    Contact c = contacts[index];
		    c.setName(contact.getName());
		    c.setPhone(contact.getPhone());
		    c.setEmail(contact.getEmail());
			return 1;
		}
	}
}
