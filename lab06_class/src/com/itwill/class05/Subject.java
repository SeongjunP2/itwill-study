package com.itwill.class05;

public class Subject {
    // field
    int korean;
    int english;
    int math;
    int science;
    
    // TODO 생성자: (1)기본 생성자. (2)아규먼트를 갖는 생성자.
    public Subject() {
    	
    }
    
    public Subject(int korean, int english, int math, int science) {
    	this.korean = korean;
    	this.english = english;
    	this.math = math;
    	this.science = science;
    }
    // TODO 메서드: (1)총점 리턴. (2) 평균 리턴.
    public int sum() { // 메모리에 이미 Subject 매서드를 이용한 과목 값들이 들어있기 때문에 파라미터 필요x
    	return korean + english + math + science;
    }
    
    public double avg() {
    	return (double) sum() / 4;
    }
    
    // 과목 클래스의 총 정보를 출력하는 매서드
    public void info() {
    	System.out.println("korean: " + korean);
    	System.out.println("english: " + english);
    	System.out.println("math: " + math);
    	System.out.println("science: " + science);
    	System.out.println("총점: " + sum());
    	System.out.println("평균: " + avg());
    }

}