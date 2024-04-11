package com.itwill.file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.file04.Product;

public class FileMain05 {

	public static void main(String[] args) {
		// 파일에 쓸(write) 더미 데이터
		ArrayList<Product> list = new ArrayList<>();
		for (int i = 0; i < 1_000_000; i++) {
			list.add(new Product(i, "name_" + i, i));
		}
		System.out.println("size = " + list.size());
		
		// ArrayList를 저장하는 파일 이름
		String fileName = "data/product_list.dat";
		
		// 1. Product 타입 객체 1,000,000개를 저장하는 ArrayList를 파일 쓰기(write)
		// FOS, BOS, OOS을 이용.
		try (
				FileOutputStream fos = new FileOutputStream(fileName);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);
		) {
			oos.writeObject(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 2. 파일에서 객체를 읽어서 ArrayList<Product>로 변환하기(read)
		// FIS, BIS, OIS을 이용.
		try (
				FileInputStream fis = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);
				ObjectInputStream ois = new ObjectInputStream(bis);
		) {
//			list = (ArrayList) ois.readObject();
//			System.out.print(list.get(0) + " " + list.get(999_999));
//            System.out.println(list.getFirst()); // list.get(0)
//            System.out.println(list.getLast()); // list.get(999_999) // list.get(Products.size() -1)
            
            long start = System.currentTimeMillis(); // 파일에서 객체를 읽어 콘솔에 출력하기까지의 시간을 측정하기 위한 코드
            
            ArrayList<Product> products = (ArrayList<Product>) ois.readObject();
            
            long end = System.currentTimeMillis();
            
            System.out.println("파일 읽기 시간: " + (end - start) + "ms"); // 객체를 읽기 끝난 시간과 읽기 시작한 시간을 빼서 파일 읽기 시간을 측정
            System.out.println("size = " + products.size());
            System.out.println(products.getFirst()); // products.get(0)
            System.out.println(products.getLast()); // products.get(999_999) // products.get(Products.size() -1)
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
