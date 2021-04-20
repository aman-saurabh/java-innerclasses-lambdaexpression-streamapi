package com.tp.sec5.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * map() is a non-terminal operation that returns a stream after modifying each element of the stream.
 */

public class Part3_Intermediate_map {
	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>() {
			private static final long serialVersionUID = 1L;

			{
				add(5);
				add(7);
				add(9);
				add(11);
			}
		};
		//Here we are using non-terminal operation map() but as we have discussed earlier we have to used it with some terminal operation in order to get result in some defined data-structure.
		//Otherwise we will get a modified stream only if we use only non-terminal or intermediate operations.
		//Here we are using collect() as the terminal operation to get result in the form of list. 
		List<Integer> l1 = l.stream().map(e -> e*e).collect(Collectors.toList());
		System.out.println(l1);
		
	}
}
