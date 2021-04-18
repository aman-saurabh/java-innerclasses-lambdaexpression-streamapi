package com.tp.sec3.lamda_expressions;

import java.util.function.Function;

/*
 * Function interface supports 2 type of chaining
 * 1.) f1.andThen(f2).apply() -> first f1 will be applied followed by f2
 * 2.) f1.compose(f2).apply() -> first f2 will be applied followed by f1
 * i.e both does same task but in order is different
 */

public class Part14_FunctionChaning {
	public static void main(String[] args) {
		Function<Integer, Integer> f1 = num -> num * 5;
		Function<Integer, Integer> f2 = num -> num + 5;
		
		System.out.println(f1.andThen(f2).apply(12));
		System.out.println(f1.compose(f2).apply(12));
		
		System.out.println(f1.andThen(f2).apply(167));
		System.out.println(f1.compose(f2).apply(167));
	}
}
