package com.itwill.inheritance06;

// 2차원 평면의 점의 좌표를 표현
public class Point {
	// field
	private int x;
	private int y;
	
	// constructor
	public Point() {}
	
	public Point(int x, int y) {
<<<<<<< HEAD
		this.x = x;
=======
		this.x = y;
>>>>>>> fab8f94c3d392500379f4a95c55c21ccd2b22233
		this.y = y;
	}
	
	@Override // Object의 클래스에서 상속받은 toString() 재정의
	public String toString() {
		return "Point(x=" + x + ", y=" + y + ")";
	}
	
//	@Override
//	public boolean equals(Object o) {
//		return this.x == this.y;
//	}
	
	@Override // Object에서 상속받은 equals를 재정의(Object에서의 equals는 주소값을 비교해서 리턴한다)
	public boolean equals(Object obj) {
		boolean result = false;
		
		if (obj instanceof Point) {
			Point pt = (Point) obj;
			result = (this.x == pt.x) && (this.y == pt.y);
		}
		
		return result;
	}
	
	@Override // Object 클래스의 hashCode() 메서드를 재정의
	public int hashCode() {
		return x + y;
	}

}
