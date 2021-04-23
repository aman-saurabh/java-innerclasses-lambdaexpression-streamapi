package com.tp.sec5.stream_api;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * limit(int streamSize) is used to limit the size of elements in the processed data. 
 */

public class Part09_Intermediate_limit {
	public static String generateRandomString() {
		String str = "";
		for (int i = 0; i <= 5; i++) {
			int lowerLimit = i == 0 ? 65 : 97;		//For first letter as Capital and rest as Small
			int higherLimit = i == 0 ? 90 : 122 ;	//For first letter as Capital and rest as Small
			int num = ThreadLocalRandom.current().nextInt(lowerLimit, higherLimit+1);
			char c = (char) num;
			str += String.valueOf(c);
		}
		return str;
	}

	public static void main(String[] args) {
		// It will generate a list of 10 elements. But if we don't use limit() method,
		// it will continue to add elements in the list until it reaches the memory
		// limit.
		List<Integer> l = Stream.iterate(50, e -> e + 5).limit(10).collect(Collectors.toList());
		System.out.println(l);

		String[] strArray = Stream.generate(() -> generateRandomString()).limit(5).toArray(String[]::new);
		for(String s: strArray) {
			System.out.println(s);
		}
	}
}
