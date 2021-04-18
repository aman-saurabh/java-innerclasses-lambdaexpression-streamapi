package com.tp.sec3.lamda_expressions;

import java.util.function.Predicate;

/*
 * Write a program to check whether length of the string is greater than 5 or not.
 */
@FunctionalInterface
interface TestString {
	public boolean checkIsNumber(String s);
}

public class Part9_PredicateExample {
	public static void main(String[] args) {
		//Using custom FunctionalInterface and Lamda Expression. 
		TestString t = s -> {
			try {
				Integer.parseInt(s);
				return true;
			} catch (NumberFormatException e) {
				//If not a number then it will  throw NumberFormatException
				return false;
			}
		};
		System.out.println(t.checkIsNumber("15695"));		//Will return true
		System.out.println(t.checkIsNumber("Aman126"));		//Will return false
		
		//Same functionality with the help of predicate without the need of defining a custom FunctionalInterface
		Predicate<String> p = s -> {
			try {
				Integer.parseInt(s);
				return true;
			} catch (NumberFormatException e) {
				//If not a number then it will  throw NumberFormatException
				return false;
			}
		};
		System.out.println(p.test("15695"));
		System.out.println(p.test("Aman126"));
	}
}
