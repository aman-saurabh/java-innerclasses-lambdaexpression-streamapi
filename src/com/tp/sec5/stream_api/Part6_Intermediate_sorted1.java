package com.tp.sec5.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * 'filter()' is a non-terminal operation that returns a stream consisting of elements sorted according to default natural sorting order or customized sorting order.
 * Default natural sorting order for strings are alphabatical order while for numbers, it is increasing order.
 * We can define default natural sorting order for customized classes also by implementing "Comparable" interface and its "compareTo()" method.
 * And if we want customized sorting order we need to pass a "Comparator" object in the sorted() method as argument.
 * And since "Comparator" interface is a functional interface so we can implement its SAM directly inside the "sorted()" method itself using lamda expression.
 * In this part we will see default natural sorting for strings, in next 2 parts we will see default natural sorting for user-defined class and customized sorting respectively.   
 */

public class Part6_Intermediate_sorted1 {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>() {
			private static final long serialVersionUID = 1L;
			{
				{
					add("Suman");
					add("Aman");
					add("Saurabh");
					add("Manish");
				}
			}
		};
		
		System.out.println("List before sorting");
		System.out.println(l);
		
		List<String> l1 =  l.stream().sorted().collect(Collectors.toList());
		System.out.println("List after sorting");
		System.out.println(l1);		
	}
}
