package com.tp.sec5.stream_api;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * skip(int number) is used to return a stream after skipping first n elements.
 */

public class Part10_Intermediate_skip {
	public static void main(String[] args) {
		Stream<Integer> s = Stream.iterate(5, e -> e*2).skip(5).limit(10);
		Set<Integer> set = s.collect(Collectors.toSet());
		Iterator<Integer> i = set.iterator();
		while (i.hasNext()) {
			int num = i.next();
			System.out.println(num);
		}
	}
}
