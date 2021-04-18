package com.tp.sec3.lamda_expressions;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;

/*
 * Predefined functional interfaces like Predicate, Function, Consumer, BiPredicate etc. accepts only Objects as arguments.
 * But we pass premitives also as argument like int, boolean, long, char etc.
 * And same applies for return values also i.e these functions returns only objects but we get premitives also.So how it it possible?
 * It is possible because when we pass premitive values as argument, 
 * java implecitely convert them to corresponding wrapper classes like int to Integer, this concept is known as autoboxing.
 * Similarly when these functions returns values in the form of wrapper class, Java implecitely convert them into corresponding premitive value.This concept is known as unboxing.         
 * But the problem is due to this autoconversion, JVM has to perform some extra operation internally, which impacts the performance of the program.
 * In previous programs we might not have noticed the effect as we had used them in very small numbers.
 * But if we have to call these functions in loop of 1000s iteration then in such scenarios you can definately feel the difference.
 * So Java also provides some predefined functional interface which is based on a specific type of arguments and return types like 
 * DoublePredicate -> Similar to Predicate<Double> -> i.e accepts only double value.
 * LongFunction<Double> -> Similar to Function<Long, Double> -> i.e accepts long value but in this also we have to define return type explicetely(in this case 'Long').
 * But in such scenario only we will get only half bebefit as auto-conversion of result is still happening.So if you want full benefit, Java provide predefined functional interfaces for that as well like.  
 * LongToDoubleFunction -> Similar to Function<Long, Double> -> i.e accepts long value and returns double value.
 * LongToIntFunction -> Similar to Function<Long, Integer> -> i.e accepts long value and returns integer value.
 * And SAM of such function is not 'apply' but its SAM name is also based on its return type like 'applyAsDouble()' for all "...ToDoubleFunction" and 'applyAsLong' for all "...ToLongFunction".
 * But please note that not all conbinations are available.Like IntToInt or LongToLong is not available.So please be sure whether the combination is available or not before using them. Otherwise use above one. 
 */

public class Part20_IntPredicateAndOthers {
	public static void main(String[] args) {
		//Similar to Predicate<Integer>
		IntPredicate i = num -> num % 3 == 0;
		
		//Similar to Function<Integer, Integer>
		IntFunction<Integer> f1 = num -> num * 3 -5; 
		
		//Similar to Function<Integer, Double>
		IntToDoubleFunction f2 = num -> Double.valueOf(num);
		
		int[] numbers = {1, 7, 19, 21, 9};
		for(int n: numbers) {
			if(i.test(n)) {
				System.out.format("Value for %d is %f \n", n, f2.applyAsDouble(f1.apply(n)));
			}
		}
	}
}
