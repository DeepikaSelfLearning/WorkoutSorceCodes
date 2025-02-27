//3 Ways to find the duplicates elements from the given array

package com.deepu.general.workouts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateElementsFromArrya {
	
	public static void main(String[] args) {
	
		String[] names = {"Deepu", "Dhruvith", "Prasanna", "Sujatha", "Adveesh", "Veda", "Chandu", "Deepu", "Chandu"};
		
		// 1. Compare each element O(n*n)
		for(int i=0; i<names.length; i++) {
			for(int j=i+1; j<names.length; j++) {
				if(names[i].equals(names[j])) {
					System.out.println("Duplicate element is " + names[i]);
				}
			}
		}
		
		System.out.println("************************");
		
		// 2. Using HashSet O(n)
		Set<String> nameSet = new HashSet<>();
		for(String name : names) {
			if(nameSet.add(name) == false) {
				System.out.println("Duplicate elemet is "+name);
			}
		}
		
		System.out.println("************************");
	
		//3. Using HashMap O(2n)
		Map<String, Integer> nameMap = new HashMap<>();
		for(String name : names) {
			Integer count = nameMap.get(name);
			if(count == null) {
				nameMap.put(name, 1);
			}
			else {
				nameMap.put(name, ++count);
			}
		}
		
		Set<Entry<String, Integer>> nameMapEntrySet = nameMap.entrySet();
		for(Entry<String, Integer> entry : nameMapEntrySet) {
			if(entry.getValue() > 1) {
				System.out.println("Duplicate element is "+ entry.getKey());
			}
		}
		
		
		System.out.println("************************");
		
		//Using Streams
		Arrays.stream(names).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		.entrySet().stream().filter(name -> name.getValue() > 1)
		.map(nam -> nam.getKey())
		.forEach(s -> System.out.println("Duplicat element is "+ s));
		
	}

}
