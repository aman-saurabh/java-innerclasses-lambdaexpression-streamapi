package com.tp.sec3.lamda_expressions;

import java.util.function.Consumer;

/*
 * Consumer supports only one type of chaining
 * 1.) c1.andThen(c2).accept() -> first c1 will be executed followed by c2
 */

/*
 * Note :- Supplier doesn't support chaining hence no part is created for that
 */
public class Part15_ConsumerChaining {
	public static void main(String[] args) {
		Consumer<String> c1 = str -> System.out.println(str+" was a great movie.");
		Consumer<String> c2 = str -> System.out.println(str+" had earned 100+ crores in boxoffice.");
		
		c1.andThen(c2).accept("3 idiots");
		c1.andThen(c2).accept("Kuch kuch hota hai");
	}
}
