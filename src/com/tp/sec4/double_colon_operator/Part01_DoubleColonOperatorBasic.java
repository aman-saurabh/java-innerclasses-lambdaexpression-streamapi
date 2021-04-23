package com.tp.sec4.double_colon_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/* 
 * Double colon operator is an alternative to lamda expression.
 * The only difference is, in case of double colon operator, instead of defining SAM exclusively we just delegate the reference of an already existing method to the SAM. 
 * And actually that's also the advantage of double colon operator over lamda expression as in double colon operator we achieve reusability.
 * Since in double colon operator we provide implementaion for SAM of a functional interface using method reference of an already existing function, hence it is also known as "Method reference operator".    	 
 * As the name suggests in double colon operator, double colons i.e "::" is used to delegate a method reference to the SAM of functional interface.
 * But to use a method as method reference in double colon operator, the arguments & return type of the method, must be same as SAM of functional interface.
 * Method reference or double colon operator can be used to refer the following :
 * 1.) a static method
 * 2.) an instance method
 * 3.) a constructor
 * We will see them in details in later parts. Now let's see few basic examples for how can we use double colon operator inplace of lamda expression to provide functionality for SAM of a functional interface.
 */

interface Message{
	public String sayHello(String name);
}
public class Part01_DoubleColonOperatorBasic {
	public String helloMsg(String name) {
		return String.format("Hello %s!",name);
	}
	
	public static int getSumOfSquares(int a, int b) {
		return (a*a) + (b*b);
	}
	
	public static void main(String[] args) {
		//For user defined functional interface
		//Implementation for Message interface SAM 
		Message le = name -> String.format("Hello %s!",name);
		System.out.println(le.sayHello("Aman"));
		
		//But suppose we already have a 'helloMsg()' method defined which has same implementation.
		//In such scenario instead of proving implementaion for SAM of Message interface again we can reuse helloMsg() method as follows using double colon operator.
		//Since helloMessage is an instance method hence we will have to use object reference of Part1_DoubleColonOperatorBasic and hence we will have to create an object of it.
		Part01_DoubleColonOperatorBasic obj = new Part01_DoubleColonOperatorBasic();
		Message dc = obj::helloMsg;
		System.out.println(dc.sayHello("Saurabh"));
		
		//For predefined functional interface
		BiFunction<Integer, Integer, Integer> bf = (a, b) -> (a*a) + (b*b);
		System.out.println(bf.apply(5, 9));
		
		//Same functionality by reusing getSumOfSquares() method, as it is already defined(suppose).
		//Since getSumOfSquares() method is a static method hence we can use class reference and we don't need to create an object or reused an existing object.
		BiFunction<Integer, Integer, Integer> mro = Part01_DoubleColonOperatorBasic::getSumOfSquares;
		System.out.println(mro.apply(5, 7));
		
		//Using predefined methods as method rererence in double colon operator.
		List<String> l = Arrays.asList("Aman", "Mohit", "Vivek", "Saurabh");
		//Using Consumer predefined Functional interface
		l.forEach(item -> System.out.println(item));
		//Same functionality Using double colon operator
		l.forEach(System.out::println);
		//Here basically the syntax is
		//collectionObject.forEach(objOneByone -> {return processedData});			//i.e lamda expression
		//or 
		//collectionObject.forEach(SomeCLassOrObject::somestaticOrInstanceMethod);	//i.e double colon operator
		//We will learn about forEach method in next section i.e in stream api.
	}
}
