package com.tp.sec5.stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
 * Consider an array of arrays as follows int[][] x = {{1,2}, {3,4}, {5,6}};
 * Processing stream created from such arrays with normal methods will be little complex.
 * We will have to flatten this 2 level array into a single level while processing its elements like.
 * {1,2,3,4,5,6}
 * We can achieve this easily by using flapMap() method of Stream interface. 
 */

public class Part11_Intermediate_flatMap1 {
	public static <T> Stream<T> flattenStream(T[][] arrays) {
		List<T> list = new ArrayList<>();
		for (T[] array : arrays) {
			Arrays.stream(array).forEach(list::add);
		}
		return list.stream();
	}

	public static void main(String[] args) {
		//Consider the following Array of arrays.
		//We will see how to flatten this 2 level array to 1 level array
		
		//Method 1 : - Without using flatMap() method.With the help of a custom function "flattenStream"
		Integer[][] x = {{1,2}, {3,4}, {5,6}};
		Integer[] l1 = flattenStream(x).toArray(Integer[]::new);
		for(Integer i : l1) {
			System.out.println(i);
		}
		System.out.println();
		//Method 2 :- With the help of flatMap.No need of any custom function in this case.
		Integer[] l2 = Arrays.stream(x).flatMap(Arrays::stream).toArray(Integer[]::new);
		//Here we can also use Stream.of() method inplace of Arrays.stream() inside flatMap method.
		for(Integer i : l2) {
			System.out.println(i);
		}
	}
}
