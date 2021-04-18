package com.tp.sec3.lamda_expressions;

import java.util.function.Consumer;

/*
 * Java 8 another important predefined functional interface is 'Consumer' interface which is defined in 'java.util.function' package.
 * It accepts one argument and but don't returns any data.
 * SAM of 'Function' interface is 'accept'. 
 */

@FunctionalInterface
interface Message {
	public void printMessage(String message);
}

public class Part11_ConsumerExample {
	public static void main(String[] args) {
		//Using custom functional interface
		Message m = msg -> System.out.println(msg);
		
		//Same functionality using pre-defined functional interface 'Consumer'
		Consumer<String> c = msg -> System.out.println(msg);
		
		m.printMessage("Hello World!");
		c.accept("Hello World!");
	}	
}
