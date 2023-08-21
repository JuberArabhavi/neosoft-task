package com.example.spring.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class StringService {
	
	public HashMap<Character, Integer> acceptNoofWords (String str) {
		HashMap<Character,Integer> map = new HashMap<>();
		
		for (int i=str.length() -1; i>=0; i--) {
			if (map.containsKey(str.charAt(i))) {
				int cnt = map.get(str.charAt(i));
				map.put(str.charAt(i), ++cnt);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		
		return map;
	}
	
}
