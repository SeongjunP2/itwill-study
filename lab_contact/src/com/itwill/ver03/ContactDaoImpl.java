package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {
	private static ContactDaoImpl instance = null;
	
	private List<Contact> contacts = new ArrayList<>();
	
	private int count = 0;
	
	public static ContactDao getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	
    public boolean isValidIndex(int index) {
        return (index >= 0) && (index < count);
    }

	@Override
	public int create(Contact contact) {
		if (contacts.add(contact)) {
			count++;
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
		if (contacts.get(index) != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int delete(int index) {
		if (contacts.remove(index) != null) {
			return 1;
		} else {
			return 0;
		}
	}

}
