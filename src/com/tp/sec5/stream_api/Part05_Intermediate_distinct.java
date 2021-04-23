package com.tp.sec5.stream_api;

import java.util.Arrays;
import java.util.stream.Stream;

/*
 * filter() is a non-terminal operation that returns a stream of distinct elements.
 */

public class Part05_Intermediate_distinct {
	public static void main(String[] args) {
		String[] strArray = { "Aman", "Pawan", "Suman", "Aman", "Sumit", "Mohit", "Pawan", "Ranjit" };
		Stream<String> stringStream = Arrays.stream(strArray);
		Object[] newStr = stringStream.distinct().map(e-> e.toUpperCase()).toArray();
		for(Object s: newStr) {
			System.out.println(s);
		}
	}
}
