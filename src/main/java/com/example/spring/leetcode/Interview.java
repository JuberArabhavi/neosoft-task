package com.example.spring.leetcode;

import java.util.HashMap;

public class Interview {
	
	
	public static void main(String[] args) {
		// return no of words in string and accept string
		String str = "aa b c";
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i=str.length()-1;  i>=0; i--) {
			if(map.containsKey(str.charAt(i))) {
				// count
				int count = map.get(str.charAt(i));
				map.put(str.charAt(i), ++count);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		
		System.out.println(map);
		
		
	}

}
