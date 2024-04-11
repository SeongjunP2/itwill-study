package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain06 {

	public static void main(String[] args) {
		// TODO Student 1,000,000개를 저장하는 더미 데이터(ArrayList)를 만듦.
		ArrayList<Student> studentList = new ArrayList<>();
//		ArrayList<Score> scoreList = new ArrayList<>();
		
		Random random = new Random(); // 시험 점수 난수로 생성하기
		for (int i = 0; i < 1_000_000; i++) {
			// 시험 점수 정보 난수로 생성
			Score score = new Score(random.nextInt(101), random.nextInt(101), random.nextInt(101));
			studentList.add(new Student(i, "name_" + i, score)); // student 리스트에 score정보를 포함한 학생정보 생성
		}
		System.out.println(studentList.getFirst());
		System.out.println(studentList.getLast());
		
//		for (int i = 0; i < 1_000_000; i++) { // Student 객체의 학생 정보 생성
//			StudentList.add(new Student(i, i, scoreList));
//		}
		
		// 더미 데이터를 파일에 씀. 파일에 쓰는 데 걸린 시간 측정.
		String filename = "data/student_list.dat";
		
		try (
				FileOutputStream fos = new FileOutputStream(filename);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
		) {
			long start = System.currentTimeMillis(); // 파일 쓰기 시작 시간
			oos.writeObject(studentList);
			long end = System.currentTimeMillis(); // 파일 쓰기 끝나는 시간
			
			System.out.println("파일 쓰기 시간: " + (end - start) + "ms"); // ms단위로 시간 출력
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 파일에서 데이터를 읽음. 읽는 데 걸린 시간 측정.
		try (
				FileInputStream fis = new FileInputStream(filename);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
				
		) {
			long start = System.currentTimeMillis(); // 파일 읽기 시작 시간
			ArrayList<Student> student = (ArrayList<Student>) ois.readObject();
			long end = System.currentTimeMillis(); // 파일 읽기 끝나는 시간

			System.out.println("파일 읽기 시간: " + (end - start + "ms"));
			System.out.println(student.getFirst());
			System.out.println(student.getLast());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
