package com.tp.sec2.java8_interface_enhancement;

/*
 * Default method in case of Multiple inheritance.
 * If a class implements several interfaces and some interfaces among them contains same default method, 
 * then either we should override that default method in the implementation class or specify which interface implementation it wants,
 * by using the desired interface name & 'super' keyword.Otherwise it will create ambiguity problem and throws compile time error.
 * let's see how we can achieve that with the help of an example. 
 */

interface First{
	public default void m1() {
		System.out.println("First interface m1 method default implementation.");
	}
	
	public default void m2() {
		System.out.println("First interface m2 method default implementation.");
	}
	
	public default void m3() {
		System.out.println("First interface m3 method default implementation.");
	}
}

interface Second{
	public default void m1() {
		System.out.println("Second interface m1 method default implementation.");
	}
	
	public default void m2() {
		System.out.println("Second interface m2 method default implementation.");
	}
	
	public default void m3() {
		System.out.println("Second interface m3 method default implementation.");
	}
}
public class Part03_DefaultMethodWithMultipleInheritance implements First, Second {
	//Specifying we want First interface implementation for m1() method.
	public void m1() {
		First.super.m1();
	}
	
	//Specifying we want Second interface implementation for m2() method.
	public void m2() {
		Second.super.m2();
	}
	
	//Specifying we want customized implementation for m3() method by overriding the default method m3().
	public void m3() {
		System.out.println("Providing customized implementation");
	}
	
	public static void main(String[] args) {
		Part03_DefaultMethodWithMultipleInheritance p = new Part03_DefaultMethodWithMultipleInheritance();
		p.m1();
		p.m2();
		p.m3();
	}
}
