package com.tp.sec3.lamda_expressions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Lambda expression is not a replacement to anonymous inner class.And still Anonymous inner class has its own significance.
 * Actually Anonymous inner classes is much more powerful and have wide range of uses compared to Lambda expressions.
 * Lambda expressions can be used with functional interfaces only but anonymous inner classes can be used with any type of interfaces as well as classes.
 * For example Lambda expressions can be used as replacement to Anonymous inner class of Runnable interface but it can't be used as replacement to Anonymous inner class of Thread class. 
 */

public class Part7_LambdaVsAnonymousInnerClass {
	public static void main(String[] args) {
		
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable interface implementation using Anonymous inner class");
			}
		};
		
		//Corresponding implementation using Lambda expression.
		Runnable r2 = () -> System.out.println("Runnable interface implementation using Lambda expression");
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(r1);
		executor.execute(r2);
		
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("Thread class implementation using Anonymous inner class");
			};
		};
		t.start();
		//No corresponding implementation using Lambda expression is possible.
		
		executor.shutdown();
	}
}
