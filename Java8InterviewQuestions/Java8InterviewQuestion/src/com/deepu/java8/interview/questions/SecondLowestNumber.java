// To find the second lowest number fron the given int array

package com.deepu.java8.interview.questions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecondLowestNumber {

	public static void main(String[] args) {
		
		int[] numbers = {5, 9, 11, 2, 8, 21, 1};
		
		Integer secondLowestNumber = Arrays.stream(numbers).boxed()
												.sorted()
												.skip(1).findFirst().get();
		
		System.out.println(secondLowestNumber);
		
	}
	
}
