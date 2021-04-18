package com.tp.sec3.lamda_expressions;

import java.util.function.BiPredicate;

/*
 * BiPredicate is similar to Predicate.Even their SAM and chaining are same.
 * The only difference is Predicate accepts one argument while BiPredicate accepts two arguments.
 */
@FunctionalInterface
interface MultiplyAndTest {
	public boolean checkIfProductEven(int a, int b);
}

public class Part17_BiPredicate {
	public static void main(String[] args) {
		// Implementing custom defined functional interface SAM
		MultiplyAndTest m = (a, b) -> a * b % 2 == 0;

		// Same functionality with the help of BiPredicate
		BiPredicate<Integer, Integer> bp = (a, b) -> (a * b) % 2 == 0;
		
		System.out.println(m.checkIfProductEven(5, 13));
		System.out.println(bp.test(5, 13));
		System.out.println();
		System.out.println(m.checkIfProductEven(12, 7));
		System.out.println(bp.test(12, 7));
		
		System.out.println();
		//To demonstrate chaining of BiPredicate
		BiPredicate<Integer, Integer> bp2 = (a, b) -> (a+b) %2 ==0;
		System.out.println(bp.and(bp2).test(16, 7));
		System.out.println(bp.or(bp2).test(16, 7));
		System.out.println(bp2.negate().test(16, 7));
	}
}
