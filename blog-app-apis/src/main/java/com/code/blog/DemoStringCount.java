package com.code.blog;

import java.util.LinkedHashMap;
import java.util.Map;

public class DemoStringCount {

	public static void main(String[] args) {

		String str = "Nikhilpjavadeveloper";

		Map<Character, Integer> hMap = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < str.length(); i++) {

			if (hMap.containsKey(str.charAt(i))) {

				int count = hMap.get(str.charAt(i));

				hMap.put(str.charAt(i), ++count);

			} else {
				hMap.put(str.charAt(i), 1);
			}
		}
		System.out.println(hMap);
	}
}
