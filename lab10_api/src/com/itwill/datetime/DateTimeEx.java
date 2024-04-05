package com.itwill.datetime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeEx {

	public static void main(String[] args) {
		// Java 8 버전부터 새로 생긴 java.time 패키지의 날짜/시간 클래스
		
		LocalDate today = LocalDate.now(); // 오늘 날짜(년, 월, 일)
		System.out.println(today);
		System.out.println(today.getYear()); // year(년도) 출력
		System.out.println(today.getMonth()); // month(월)을 영어로 출력
		System.out.println(today.getMonthValue()); // month(월)을 숫자로 출력
		System.out.println(today.getDayOfMonth()); // day(일) 출력
		System.out.println(today.getDayOfWeek()); // 요일 출력
		System.out.println(today.plusDays(1));
		System.out.println(today.plusWeeks(1));
		
		LocalDate birthday = LocalDate.of(2000, 12, 31); // 날짜를 만들어서 출력(년, 월, 일)
		System.out.println(birthday);
		
		LocalDateTime now = LocalDateTime.now(); // 현재 날짜를 초단위까지 출력
		System.out.println(now);
		
		LocalDateTime time = LocalDateTime.of(2024, 3, 14, 9, 30, 10); // 날짜를 초단위까지 만들어서 출력
		System.out.println(time);
		
		// Timestamp: 1970-01-01 00:00:00를 기준으로 해서 1/1000초(milli-second)마다
		// 1씩 증가하는 정수(long 타입)를 기반으로 날짜와 시간 정보를 저장하는 클래스(타입)
		
		// LocalDateTime --> TimeStamp 변환
		Timestamp ts = Timestamp.valueOf(now);
		System.out.println(ts);
		System.out.println(ts.getTime());
		
		// Timestamp --> LocalDateTime 변환
		LocalDateTime dt = ts.toLocalDateTime();
		System.out.println(dt);

	}

}
