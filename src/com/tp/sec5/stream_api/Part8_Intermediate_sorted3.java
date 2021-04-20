package com.tp.sec5.stream_api;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * In this part we will see how to use custom sorting for numbers as well as for custom classes.
 * Here also we will use same Customer class of part 7 as custom class.
 */

public class Part8_Intermediate_sorted3 {
	public static void main(String[] args) {
		Stream<Integer> nums = Stream.of(5, 32, 2, 11, 23);
		// Object[] sortedNums = nums.sorted((a,b) -> (a >b)?-1:(a<b)?1:0).toArray();
		
		// However above code is perfectly vaild but the only problem is we have to hold processed data in object array.
		// What if we want the data in int array.Actually Stream<T> is generics type hence it work only with objects.
		// So to get data in int array we have to change type from Stream<T> to IntStream.
		// We can do so by adding "mapToInt()" method of intStream interface at the end of intermediate operations pipeline, which will convert the stream into Intstream. 
		// And applying toArray() method after that will return an int array instead of Object array.   
		int[] sortedNums = nums.sorted((a,b) -> (a >b)?-1:(a<b)?1:0).mapToInt(i -> i).toArray();
		for(int i: sortedNums) {
			System.out.println(i);
		}
		System.out.println();
		
		// However in case of primitive streams (i.e in IntStream, LongStream and DoubleStream) customized sorting is not supported.
		// As these streams are intended to hold only whole numbers or floating-point numbers. So we don't even need customized sorting except for sorting in decresing order. 
		// For sorting in decresing order(i.e opposite of default natural sorting) we can use following method.
		int[] ary = {5, 32, 2, 11, 23};
		IntStream arynums = Arrays.stream(ary);
		int[] sortedAryNums = arynums.boxed().sorted(Collections.reverseOrder()).mapToInt(i -> i).toArray();
		for(int i: sortedAryNums) {
			System.out.println(i);
		}
		// Here first we are converting IntStream into Stream<Integer> with the help of IntStream interface 'boxed()' method, 
		// then we are applying customized sorting on that Stream<Interger> object and after sorting again we are converting Stream<Integer> to IntStream using intStream interface mapToInt() method.   
		// And finally we are storing processed data into an int array using toArray() method.
		System.out.println();
		
		//Note :- Here if we use Stream.of() method instead of Arrays.stream(). Then in such scenarios it will create a stream of array of integers i.e "Stream<int[]>" instead of "IntStream".
		//Processing which is little cumbersome and we will have to use flatMap() method for that purpose.Hence to convert an existing primitive array into stream we should use Arrays.stream() method over Stream.of() method. 
		//As Stream.of() method can be used only to create Stream<T> object and not primitive streams like IntStream, LongStream or DoubleStream. 
		//Whereas Arrays.stream() method can be used to create both types of stream. In case of array of primitives it creates primitive stream otherwise Stream<T> object.
		Stream<int[]> arynums2 = Stream.of(ary);

		//However if you don't have any existing array and you want to add element of the array while defining stream then for such situation we should use Stream.of() method as for such requirements Arrays.stream() won't work.    
		Stream<Integer> numStream1 = Stream.of(1, 2, 3, 4);
		
		//For array of objects like array of Strings both methods i.e Arrays.stream() and Stream.of() both works same. 
		String[] stringAry = {"One", "Two", "Three", "Four"};
		Stream<String> stringStream1 = Arrays.stream(stringAry);
		stringStream1.forEach(System.out::println);
		System.out.println();
		Stream<String> stringStream2 = Stream.of(stringAry);
		stringStream2.forEach(System.out::println);
		
		List<Customer> l = Arrays.asList(
				new Customer(1, "Aman"),
				new Customer(5, "Pawan"),
				new Customer(7, "Mohit"),
				new Customer(3, "Irfan"),
				new Customer(6, "Mike")
		);
		Comparator<Customer> comp = (a,b) -> {
			return a.name.compareTo(b.name);
		};
		
		List<Customer> l1 = l.stream().sorted(comp).collect(Collectors.toList());
		System.out.println(l1);
	};
}
