package com.tp.sec3.lamda_expressions;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * In this part we will see few specific cases of Functional interface.
 * Actually Lambda expression was not only introduced to provide implementation for SAM.
 * But the main purpose behind the introduction of Lambda expressions was to introduce the concept of Functional programming in Java.
 * Actually earlier, Java was a completely OOP based programming Language and to provide any functionality in Java, a class was required.
 * So Lambda expression was mainly introduced to overcome this problem, so that we can provide functionality(i.e write a function) without creating a class for that.
 * But since changing entire Java was not so easy neither it was logical, so restriction was made that Lambda expression can be used with Functional interfaces only.          
 * So in Java 8 with introduction of Functional interface and Lambda expressions few predefined Functional interfaces were also introduced
 * which can serve some of very common requirements, so that we don't have to define an interface explicitly for such common requirements every time and we can reuse those Functional interfaces whenever required.
 * However several such Functional interfaces were introduced in Java 8 and later versions but 4 were main.Most other predefined functional interfaces were also based on those 4 only.
 * So here in this section we will learn basics of them and we will try to understand how and when to use them through some example.
 * They are as follows :      
 * 1.) Predicate - SAM - 'test()' -> Accepts 1 argument perform some test and returns boolean value based on test result.
 * 2.) Function - SAM- 'apply()' -> Accepts 1 argument, perform some operation on that and returns processed value.Return value can be of any type.
 * 3.) Consumer - SAM- 'accept()' -> Accepts 1 argument, perform some operation with that value but don't return anything.It can be used for printing message on console, logging data, database update, send email or SMS etc.   
 * 4.) Supplier - SAM - 'get()' -> Don't accept any argument but returns some value.It can be used for operations like to get the current date, to generate random number, OTP etc.
 * Note here that 'Predicate', 'Function' and 'Consumer' all accepts only one argument.If you need Functional interface with same functionality but which can accept two arguments then use 'BiPredicate', 'BiFunction' and 'BiConsumer' respectively. 
 * Now let's see how and where to use them with some example.
 */

//Interface that accepts one argument, perform some test on that and returns test result in the form of boolean value.
//For such requirements a predefined Functional interface with name 'Predicate' is introduced in Java 8 in 'Java.util.function' package,
interface TestInterface {
	public boolean isEven(int num);
}

//Interface that accepts one argument, perform some operation on that and returns processed value.
//For such requirements a predefined Functional interface with name 'Function' is introduced in Java 8 in 'Java.util.function' package, 
interface SquareInterface {
	public int getSquare(int num);
}

//Interface that accepts one argument, perform some operation on that but don't return any value.
//For such requirements a predefined Functional interface with name 'Consumer' is introduced in Java 8 in 'Java.util.function' package, 
interface MessageInterface {
	public void printMessage(String msg);
}

//Interface that don't accepts any argument but returns some value.
//For such requirements a predefined Functional interface with name 'Supplier' is introduced in Java 8 in 'Java.util.function' package, 
interface DateInterface {
	public Date getDate();
}

public class Part8_PredefinedFunctionalInterfaces {
	public static void main(String[] args) {
		// Lambda expression on TestInterface
		TestInterface t = num -> num % 2 == 0 ? true : false;
		// Same functionality we can achieve without defining 'SumInterface' as follows:
		Predicate<Integer> p = num -> num % 2 == 0 ? true : false;
		// Give Argument type in generic i.e <ArgumentType>.
		t.isEven(5);
		p.test(5);

		// Lambda expression on SquareInterface
		SquareInterface s = num -> num * num;
		// Same functionality we can achieve without defining 'SumInterface' as follows:
		Function<Integer, Integer> f = num -> num * num;
		// Give Argument type, Return type in generic i.e <ArgumentType, ReturnType>.
		s.getSquare(5);
		f.apply(5);

		// Lambda expression on MessageInterface
		MessageInterface m = msg -> System.out.println(msg);
		// Same functionality we can achieve without defining 'MessageInterface' as follows:
		Consumer<String> c = msg -> System.out.println(msg);
		// Give Argument type in generic i.e <ArgumentType>.
		m.printMessage("Hello World!");
		c.accept("Hello World");

		// Lambda expression on DateInterface
		DateInterface d = () -> new Date();
		// Same functionality we can achieve without defining 'DateInterface' as follows:
		Supplier<Date> sp = () -> new Date();
		// Give Return type in generic i.e <ReturnType>.
		d.getDate();
		sp.get();
		
	}
}

