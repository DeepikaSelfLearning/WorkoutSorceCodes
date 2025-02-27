// To find the frist repetative character from a given String

package com.deepu.java8.interview.questions;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepetativeCharacterFromAString {

	public static void main(String[] args) {
		
		String str = "ilovejavatechie";
		
		String firstRepetativeElemets = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.entrySet().stream().filter(s -> s.getValue() > 1).findFirst().get().getKey();
		
		
		System.out.println("First repeated element is "+firstRepetativeElemets);
	}
}
