package com.deepu.streamapi.examples;

import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamTest1 {

	public static void main(String[] args) {
		
		Supplier<String> supplier = new Supplier<String>() {

			@Override
			public String get() {
				return "Hello Stream";
			}
			
		};
		
		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String str) {
				System.out.println(str);
			}
			
		};
		
		//Stream.generate(supplier).forEach(consumer);
		
		//Stream.generate(() -> "Hello Stream").forEach(str -> System.out.println(str));
		
		Stream.generate(() -> "Hello Stream").forEach(System.out::println);
	}
}
