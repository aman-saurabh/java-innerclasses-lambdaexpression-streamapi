package com.tp.sec5.stream_api;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
 * A java stream is a component that is capable of internal iteration of its elements i.e it can iterate its elements itself.
 * In this part we have used several ways to create an stream.For more details check Stream API document.
 * In this part we have forEach() method of stream class to iterate each element.We will see details about this method as well as several other methods of Stream class in later parts.
 */

public class Part01_StreamApiBasics {
	public static void main(String[] args) {
		Collection<String> collection = Arrays.asList("A", "B", "C", "D");
		Stream<String> streamOfCollection = collection.stream();
		streamOfCollection.forEach(e -> System.out.println(e));
		
		Stream.Builder<String> streamBuilder = Stream.<String>builder().add("a").add("b").add("c");
		Stream<String> stream = streamBuilder.build();
		stream.forEach(e -> System.out.println(e));

		LongStream l1 = LongStream.empty();
		IntStream i1 = IntStream.of(5, 67, 156);
		IntStream i2 = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(50, 500)).limit(10);
		DoubleStream d1 = DoubleStream.of(12.57, 16.53, 63);
		DoubleStream d2 = DoubleStream.builder().add(14.57).add(16.3).add(95).build();
		DoubleStream d3 = DoubleStream.iterate(12.25, n -> n * 5 / 2).limit(5);
		d1.forEach(e -> System.out.println(e));
		//Here we have used 'd1' only but you can use any of the above stream object in place of d1.
		
		LongStream lm1 = new Random().longs().limit(5);
		//randomObj.longs()
		LongStream lm2 = new Random().longs(5);	
		//randomObj.longs(long streamSize)
		LongStream lm3 = new Random().longs(100, 1000).limit(10);
		//randomObj.longs(long randomNumberOrigin, long randomNumberBound)
		LongStream lm4 = new Random().longs(10, 100, 1000);
		//randomObj.longs(long streamSize, long randomNumberOrigin, long randomNumberBound)
		DoubleStream dm1 = new Random().doubles(1.00, 2.00).limit(5);
		//randomObj.doubles(double randomNumberOrigin, double randomNumberBound)
		IntStream im1 = new Random().ints(10);
		//randomObj.ints(int streamSize)
		dm1.forEach(e -> System.out.println(e));
		//Here we have used 'dm1' only but you can use any of the above stream object in place of dm1.
		
		String str = "Aman, Where is my tea-cup, I am searching for that.";
		Stream<String> sos = Pattern.compile(", ").splitAsStream(str);
		sos.forEach(System.out::println);
	}
}
