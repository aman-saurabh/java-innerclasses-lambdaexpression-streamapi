package com.tp.sec3.lamda_expressions;

import java.util.function.Predicate;

/*
 * Chaining means joining several predefined functional interfaces can be joined
 * 'Predicate' interface supports 3 types of chaning
 * 1.) p1.and(p2).test()
 * 2.) p1.or(p2).test()
 * 3.) p1.negate().test()
 */

public class Part13_PredicateChaining {
	public static void main(String[] args) {
		Predicate<Integer> p1 = num -> num % 5 ==0;
		Predicate<Integer> p2 = num -> num > 100;
		
		//To check if the number is multiple of 5 and greater than 100 or not
		System.out.println(p1.and(p2).test(125));
		System.out.println(p1.and(p2).test(61));
		System.out.println();
		//To check if the number is multiple of 5 or greater than 100 or not
		System.out.println(p1.or(p2).test(324));
		System.out.println(p1.or(p2).test(75));
		System.out.println(p1.or(p2).test(49));
		System.out.println();

		//To check if the number is less than or equal to 100 or not(i.e Should return true if <= 100 and false if >100);
		System.out.println(p2.negate().test(59));
		System.out.println(p2.negate().test(236));
		System.out.println();
		//To check if the nuber is neither > 100 nor multiple of 5 or not.
		System.out.println(p1.or(p2).negate().test(324));
		System.out.println(p1.or(p2).negate().test(75));
		System.out.println(p1.or(p2).negate().test(49));
	}
}
