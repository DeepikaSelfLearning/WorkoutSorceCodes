// To find the second highest number from the given int array

package com.deepu.java8.interview.questions;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighestNumber {

	public static void main(String[] args) {
		
		int[] numbers = {5, 9, 11, 2, 8, 21, 1};
		
		int secondHighestNumber = Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		 	
		System.out.println("The second highest number is "+secondHighestNumber);
	}
}
