package com.example.spring.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * 
 * @author Juber Arabhavi
 * 
 * 
 *
 */
public class Array {

	static int secondHighest(Integer a[], int total) {
		List<Integer> list = Arrays.asList(a);
		Collections.sort(list);
		int element = list.get(total - 2);

		return element;
	}

	static int firstHighest(Integer arr[], int total) {
		List<Integer> array = Arrays.asList(arr);
		Collections.sort(array);
		Integer first = array.get(total - 1);
		
		return first;
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
		Integer arr[] = { 6, 10, 5, 4, 9, 120, 4, 6, 10 };
		int array[] = { 6, 10, 5, 4, 9, 120, 4, 6, 10 };
		int index = firstDuplicate(array, arr.length);
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
		
		Integer first = firstHighest(arr, 5);
		System.out.println(first);
		Integer second = secondHighest(arr, 5);
		System.out.println(second);
		
		Integer diff = first - second;
		System.out.println(diff);
		
		
		// Java 8 if-else condition in filter method
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Predicate<Integer> even = i -> i % 2 == 0;
		
		list.stream().filter(even).forEach(System.out::print);
		System.out.println();
		
		Consumer<Integer> isEven = i -> {
			if (i % 2 == 0) {
				System.out.println("Even nos "+i);
			} else {
				System.out.println("Odd nos "+i);
			}
		};
		list.stream().forEach(isEven);
	}
}
