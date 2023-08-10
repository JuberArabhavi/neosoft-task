package com.example.spring.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * @author Juber Arabhavi
 * 
 * 
 *
 */
public class Array {

	public static int secondHighest(Integer a[], int total) {
		List<Integer> list = Arrays.asList(a);
		Collections.sort(list);
		int element = list.get(total - 2);

		return element;
	}

	public static int firstDuplicate(int arr[], int n) {

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] == arr[j]) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// 0 1 2 3 4 5 7 9
		// 16,19,21,25,21,5,8,10,25 - 5 8 10 16 19 21 21 25 25
		
		//1. first duplicate in array
		int arr[] = { 6, 10, 5, 4, 9, 120, 4, 6, 10 };
		int index = firstDuplicate(arr, arr.length);
		if (index == -1) {
			System.out.println("non-repeating");
		} else {
			System.out.println("first duplicate " + arr[index]);
		}

		//2. Given an unsorted integer array, find a triplet with a given sum in it.
		// Input: nums = [ 2, 7, 4, 0, 9, 5, 1, 3 ] target = 6 Output: Triplet exists.
		Integer nums[] = { 2, 7, 4, 0, 9, 5, 1, 3 };
		int target = 6, sum = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				for (int k = 0; k < 8; k++) {
					if (nums[i] + nums[j] + nums[k] == target) {
						//System.out.println("{" + nums[i] + "," + nums[j] + "," + nums[k] + "}");
						sum = nums[i] + nums[j] + nums[k];
					}
				}
			}
		}
		if (sum == target) {
			System.out.println("Triplet exists");
		} else {
			System.out.println("Triplet does not exists");
		}
		//System.out.println("sum "+sum);

		
		//3. Occurrence of each character in String. 
		String character = "SATISFACTION";
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = character.length() - 1; i >= 0; i--) {
			if (map.containsKey(character.charAt(i))) {
				int count = map.get(character.charAt(i));
				map.put(character.charAt(i), ++count);
			} else {
				map.put(character.charAt(i), 1);
			}
		}

		System.out.println(map);

		//4. second highest element in array
		System.out.println("second highest element "+ secondHighest(nums, 8));
	}
}
