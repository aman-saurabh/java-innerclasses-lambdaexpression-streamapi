package com.tp.sec3.lamda_expressions;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
 * BiFunction is similar to Function.Their SAM is same but there is some difference in chaining.
 * 'compose' is not supported in BiFunction and 'andThen' can be applied only between a BiFunction and a Function and not between two BiFunctions. 
 * The only difference is Function accepts one argument while BiFunction accepts two arguments.
 */
@FunctionalInterface
interface SquareAndMultiply {
	public int getSquareProduct(int a, int b);
}

public class Part18_BiFunction {
	public static void main(String[] args) {
		//Implementing custom functional interface
		SquareAndMultiply s = (a, b) -> (a * a) * (b * b);
		//Same functionality with the help of predefined functional interface - BiFunction
		BiFunction<Integer, Integer, Integer> bf = (a, b) -> (a * a) * (b * b);

		System.out.println(s.getSquareProduct(5, 3));
		System.out.println(bf.apply(5, 3));

		// To demonstrate chaining of BiFunction.
		// Chaining concept work for BiFunction, but we can apply chaining between a
		// BiFunction and a Function and not between two Bifunctions
		// Its because BiFUnction returns a single value but accepts two arguments.
		// So in chaining of two BiFunction the first BiFunction will return a single
		// value, so how we will pass 2 arguments to second BiFunction.
		// Even we apply chaining between Functions to further process the processed
		// data by first BiFunction.So logically also chaining of two bifunctions is not
		// valid.
		BiFunction<Integer, Integer, Integer> bf2 = (a, b) -> (a * a) + (b * b);
		Function<Integer, Integer> f = n -> n * 3;
		System.out.println(bf.andThen(f).apply(4, 6));
		System.out.println(bf2.andThen(f).apply(4, 6));
		// But following is not valid and will throw error
		// bf.andThen(bf2).apply(4, 6);
	}
}
