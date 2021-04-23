package com.tp.sec5.stream_api;

import java.util.Arrays;
import java.util.List;

/*
 * filter() is a non-terminal operation that returns a stream of elements which satisfy the given predicate.
 */

public class Part04_Intermediate_filter {
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(5, 8, 9 , 12, 13, 15);
		//Here we have used filter() as non-terminal operation and count() as terminal operation.
		long numCount = l.stream().filter(e -> e % 3 == 0).count();	
		System.out.println(numCount);
		System.out.println();
		//We can chain filter with other non-terminus operations as follows.
		//Here we have used filter() and map() as non-terminal operations and toArray() as terminal operation.
		Object[] intArray = l.stream().filter(e -> e%3 ==0).map(m -> (m * 2)+2).toArray();
		for(Object obj: intArray) {
			System.out.println(obj);
		}	
	}
}
