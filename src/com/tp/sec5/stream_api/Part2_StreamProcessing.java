package com.tp.sec5.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Stream iterates its elements internally.So we can attach listeners to it, 
 * So that when stream iterates through its elements, we can perform some operation on each element of it.
 * Basically We can perform two types of operations on stream objects -
 * 1.) Terminal operation
 * 2.) Intermediate (also kown as non-terminal) operation 
 * A non-terminal operations or intermediate operation transforms a stream into another stream i.e it always returns a modified stream. 
 * Example of non-terminal operations are map(), filter(), sorted(), distinct() etc.
 * On the other hand a terminal operations always returns a result that can be of premitive type, array, collection object etc. but it can't be another stream object.
 * Example of terminal operations are count(), forEach(), collect(), toArray() etc.    
 * Multipe Non-terminal operations can be chained together to form a pipeline of operations. 
 * But there can be only one terminal operation in a pipeline and that also at the end of the pipeline 
 * i.e no other terminal or non-terminal operation should be applied after terminal operation. 
 */

public class Part2_StreamProcessing {
	public static void main(String[] args) {
		List<String> l = new ArrayList<String>();
		l.add("Aman");
		l.add("Mohit");
		l.add("Sohan");
		l.add("Vijay");
		
		//Here we are using collection interface "stream()" method to create a stream.
		Stream<String> stream = l.stream();
		//Here we are processing each element and converting them to lower case.
		//And in the last part again we are collecting each processed element and creating a list out of them.
		List<String> l1 = stream.map(e -> e.toLowerCase()).collect(Collectors.toList());
		//In this example we basically performed two operations map() and collect() 
		//where map() is an intermediate or non-terminal operation and collect() is a terminal operation.  
				
		ListIterator<String> li = l1.listIterator();
		while(li.hasNext()) {
			System.out.println(li.next());
		}
	}
}
