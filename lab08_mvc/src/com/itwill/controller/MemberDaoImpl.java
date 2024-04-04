package com.itwill.controller;

import com.itwill.model.Member;

// MVC 아키텍쳐에서 컨트롤러 역할을 담당할 클래스 -> 싱글턴으로 구현.
public class MemberDaoImpl implements MemberDao {
	
	//----- singleton 구현
	private static MemberDaoImpl instance = null;
	
	private MemberDaoImpl() {}
	
	public static MemberDaoImpl getInstance() {
		if (instance == null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}
	//----- singleton 구현
	
	// 회원 정보를 저장할 배열 선언
	private Member[] members = new Member[MAX_LENGTH];
	
	// 회원 배열에 현재까지 저장된 원소의 개수 -> 새로운 회원 정보를 저장할 위치(배열 인덱스)
	private int count = 0; // 배열에 원소가 추가될 때마다 ++.

	@Override
	public int create(Member member) {
		if (count < MAX_LENGTH) {
			members[count] = member;
			count++;
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Member[] read() {
		// TODO 배열 members의 원소들 중 null이 아닌 원소들로만 이루어진 배열을 리턴
		Member[] members2 = new Member[count];
		
		for(int i = 0; i < count; i++) { // 카운트가 쌓인 수만큼 배열 출력
			members2[i] = members[i];
		}
		
		return members2;
	}

	@Override
	public Member read(int index) {
		if (index >= MAX_LENGTH || index < 0) {
			return null;
		}
		return members[index];
	}

	@Override
	public int update(int index, String password) {
		if (index < 0 || index >= members.length || members[index] == null) {
			return 0;
		} else {
			members[index].setPassword(password);
			return 1;
		}
		
	}

}
