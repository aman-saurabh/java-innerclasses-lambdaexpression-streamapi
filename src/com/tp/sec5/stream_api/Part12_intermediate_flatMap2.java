package com.tp.sec5.stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * We want an array of all unique elements from the given array of arrays of strings
 */

public class Part12_intermediate_flatMap2 {
	public static <T> Stream<T>  flattenStream(T[][] arrays) {
		List<T> l = new ArrayList<T>();
		for(T[] array : arrays) {
			Arrays.stream(array).forEach(l::add);
		}
		return l.stream().distinct();
	}
	
	public static void main(String[] args) {
		String[][] strArray = new String[][]{{"a", "b"}, {"c", "a"}, {"e", "b"}, {"b", "f"}};
		//Method 1 :- Without using flatmap method.With the help of a custom function "flattenStream"
		List<String> s1 = flattenStream(strArray).collect(Collectors.toList());
		System.out.println(s1);
		System.out.println();
		
		//Method 2: With the help of flatMap.No need of any custom function in this case.
		List<String> s2 = Arrays.stream(strArray).flatMap(Stream::of).distinct().collect(Collectors.toList());
		System.out.println(s2);
	}
}
