package com.itwill.modifier03;

public class Person {
	private String name; // 읽기 전용 필드
	private int age; // 읽기/쓰기 필드
	
	public Person(String name, int age) {
		if (name != null && age > 0) {
			this.name = name;
			this.age = age;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	// 이름 읽기
	public String getName() {
		return name;
	}
	
	// 나이 읽기
	public int getAge() {
		return age;
	}
	
	// 나이 수정
	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		}
	}

}
