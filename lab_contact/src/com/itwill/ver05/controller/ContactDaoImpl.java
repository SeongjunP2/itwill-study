package com.itwill.ver05.controller;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver05.model.Contact;

// import static 문장: 클래스에서 public static으로 선언된 멤버(필드, 메서드)의 이름
// import static com.itwill.ver04.util.FileUtil.initializeData;
import static com.itwill.ver05.util.FileUtil.*;

// MVC 아키텍쳐에서 Controller 역할 담당 클래스. DAO(Data Access Object).
public class ContactDaoImpl implements ContactDao {
	//----- singleton
	private static ContactDaoImpl instance = null;
	
	private ContactDaoImpl() {
		// 데이터 폴더 초기화: 폴더가 없으면 새로 만듦
		initializeDataDir();
		
		// 연락처 데이터 초기화: 데이터 파일에서 리스트를 읽어오거나, 빈 리스트를 생성.
		contacts = initializeData(); // 필드에 선언된 contacts이기 때문에 contacts 사용가능
	}
	
	public static ContactDaoImpl getInstance() {
		if (instance == null) {
			instance = new ContactDaoImpl();
		}
		return instance;
	}
	//----- singleton
	
	private List<Contact> contacts;
	
	/**
	 * 인덱스가 연락처 리스트의 유효한 범위 안에 있는 지를 리턴.
	 * @param 검사할 인덱스
	 * @return 유효한 인덱스이면 true, 그렇지 않으면 false.
	 */
	public boolean isValidIndex(int index) { // 인덱스 유효 검사
		return (index >= 0) && (index < contacts.size());// 인덱스는 0이상이여야 하고, 리스트에 생성된 size만큼의 인덱스만 사용가능하다
	}

	@Override
	public int create(Contact contact) {
		contacts.add(contact); // 리스트(메모리)에 추가.(리스트의 add기능)
		writeDataToFile(contacts); // FileUtil에 있는 write 메서드를 호출하여 파일에 씀.
		
		return 1;
	}

	@Override
	public List<Contact> read() {
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (isValidIndex(index)) { // 인덱스 유효를 검사하고
			return contacts.get(index); // 올바른 인덱스가 들어왔을 경우 해당 list를 불러온다.(list의 get기능)
		} else {
			return null;
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if (!isValidIndex(index)) { // !는 부정의 의미(인덱스가 올바르지 않을 경우)
			return 0;
		}
		
		contacts.set(index, contact); // 메인에서 불러온 contact 내용을 해당 인덱스의 리스트에 다시 세팅.(list의 set기능)
		writeDataToFile(contacts); // 전 버전의 contact와는 다르게 파일에 contacts내용을 담기위한 작업 필요
		
		return 1;
	}

	@Override
	public int delete(int index) {
		if (isValidIndex(index)) {
			contacts.remove(index); // contacts 리스트의 해당 인덱스 리스트 삭제
			writeDataToFile(contacts); // 삭제후 삭제된 내용의 데이터를 로컬에 있는 파일에 contacts의 내용을 덮어씌운다.
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Contact> search(String keyword) {
		List<Contact> result = new ArrayList<>();
		
		for (Contact c : contacts) {
			if (c.getName().toLowerCase().contains(keyword.toLowerCase()) ||
					c.getPhone().toLowerCase().contains(keyword.toLowerCase()) ||
					c.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
				result.add(c);
			}
		}
		
		return result;
	}

}
