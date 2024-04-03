package com.itwill.class05;

public class Student {
    // field
    int id; // 학생 번호
    String name; // 학생 이름
    Subject subject; // 수강 과목
    
    // TODO 생성자: (1)기본 생성자.
    // 타입 기본값: boolean-false, 정수-0, 실수-0.0, 참조타입-null
    public Student() {
    	
    }
    
    // (2)아규먼트를 갖는 생성자.
    public Student(int id, String name, Subject subject) {
    	this.id = id;
    	this.name = name;
    	this.subject = subject;
    }
    
    // TODO 메서드: 학생의 정보(번호, 이름, 각 과목의 점수, 총점, 평균)를 출력.
    public void info() {
    	System.out.print("번호: " + id + " " + "이름: " + name + "\n");
    	
    	// subject 값(주소)이 없는 기본생성자 출력시 nullpointerException 오류를 막기위한 if문 처리
    	// Main에서 기본생성자로 출력할때 이 코드가 없다면 subject에서 불러올 주소 자체가 없기 때문에 nullPointerException 오류가 발생
    	if (subject != null) {
    	System.out.print("korean: " + subject.korean + " ");
    		System.out.print("english: " + subject.english + " ");
    		System.out.print("math: " + subject.math + " ");
    		System.out.print("science: " + subject.science + "\n");
    		System.out.println("총점: " + subject.sum());
    		System.out.println("평균: " + subject.avg());
    	} else {
    		System.out.println("성적없음");
    	}
    }
    
}