package com.itwill.map03;

import java.util.HashMap;

public class MapMain03 {

	public static void main(String[] args) {
		// 단어 개수 세기(word counting):
		// 문자열에 등장하는 단어를 key로 하고
		// 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고, 출력.
		
		String sentence = "짜장면 짬뽕 짜장면 짬뽕 볶음밥";
		//-> 결과: {짜장면=2, 짬뽕=2, 볶음밥=1}
		
		//String[]
		//Map<String, Integer>
		String[] words = sentence.split(" ");
		for (String s : words) {
			System.out.print(s + ", ");
		}
		System.out.println();
		
		// 단어(key)-빈도수(value) 저장하기 위한 Map을 선언, 초기화.
		HashMap<String, Integer> wordcounts = new HashMap<>();
		
		// 배열에 저장된 단어들을 순서대로 하나씩 반복
		for (String w : words) {
			Integer count = wordcounts.getOrDefault(w, 0);
			wordcounts.put(w, count + 1);
			System.out.println(wordcounts);
		}
		System.out.println();
		
		HashMap<String, Integer> wordcounts2 = new HashMap<>();
		for (String w : words) {
			Integer count = wordcounts2.get(w);
			if (count != null) {
				wordcounts2.put(w, count + 1);
			} else {
				wordcounts2.put(w, 1);
			}
			System.out.println(wordcounts2);
		}

	}

}
