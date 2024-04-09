package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {
	private static ContactDaoImpl instance = null;
	
	private List<Contact> contacts = new ArrayList<>();
	
//	private int count = 0; // 배열에서는 count 사용
	
	public static ContactDao getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
    public boolean isValidIndex(int index) {
//        return (index >= 0) && (index < count);  // 배열에서는 생성된 배열, index를 파악하기위해 count를 사용
        return (index >= 0) && (index < contacts.size()); // list에서는 count가 아닌 size를 사용하면 된다.
    }

	@Override
	public int create(Contact contact) {
		if (contacts.add(contact)) {
//			count++;
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Contact> read() {
		return contacts;
	}

	@Override
	public Contact read(int index) {
		return contacts.get(index);
	}

	@Override
	public int update(int index, Contact contact) {
		if (isValidIndex(index)) { // 정상적인 인덱스의 값을 받았다면
            contacts.set(index, contact); // 메인에서 전달받은 값(index, contact)들을 set을 이용해 수정 
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int delete(int index) {
		if (isValidIndex(index)) {
			contacts.remove(index); // 메인에서 전달받은 인덱스의 값을 받아서 remove를 사용해 리스트에서 삭제
			return 1;
		} else {
			return 0;
		}
	}

}
