package com.tp.sec5.stream_api;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*
 * Premitive streams like IntStream, LongStream and DoubleStream has almost same intermediate operations as with normal Stream<T>.
 * But not all methods are same or similar like as we have seen in previous example "sorted(ComparatorObject)" is not supported by IntStream.
 * And we have also seen that some methods like boxed() and mapToInt() is supported byIntStream but not by Stream<T>.
 * So in this section we will see few important methods which are supported by premitive streams but not by 
 */

public class Part12_PremitiveStreams_Intermediate {
	public static void main(String[] args) {
		LongStream ls = LongStream.rangeClosed(1000, 999999).limit(10);
		// To convert premetive stream to normal stream.We can use bound() method of
		// premitive stream.
		Stream<Long> sl = ls.boxed();
		sl.forEach(System.out::println);
		Stream<Double> s = Stream.of(1.5, 3.25, 6.75, 12.5);
		// To convert normal stream into premetive stream.We can use mapToInt(),
		// mapToLong() and mapToDouble() methods of IntStream, LongStream and
		// DoubleStream respectively.
		DoubleStream d = s.mapToDouble(e -> e);
		d.forEach(System.out::println);
		System.out.println();
		
		//syntax :- randomObject.doubles(int streamSize, startValue, endValue)
		DoubleStream ds = new Random().doubles(5, 159.72, 1865.35).limit(5);
		double[] doubleAry = ds.boxed().sorted((a, b) -> (a > b) ? 1 : (a < b) ? 1 : 0).mapToDouble(e -> e).toArray();
		for(double dou : doubleAry) {
			System.out.println(dou);
		}
	}
}
