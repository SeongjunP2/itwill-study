package com.itwill.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // TODO: Subject, Student 클래스 객체 생성과 메서드 호출 결과 테스트.
    	Subject subject = new Subject(100, 90, 80, 70);
    	Student student = new Student(1, "홍길동", subject);
    	student.info();
    	System.out.println();
    	
    	Subject subject1 = new Subject(90, 80, 70, 60);
    	Student student1 = new Student(2, "김길동", subject1);
    	student1.info();
    	System.out.println();
    	
    	Subject subject2 = new Subject(80, 70, 60, 50);
    	Student student2 = new Student(3, "서길동", subject2);
    	student2.info();
    	System.out.println();
    	
    	// 값이 없는 기본생성자
    	Student student3 = new Student();
    	student3.info();
    	
    }
    
}