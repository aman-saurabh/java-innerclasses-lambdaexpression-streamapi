package com.tp.sec3.lamda_expressions;

/*
 * Lambda expressions are anonymous functions(i.e nameless functions) which doesn't contain return type as well as access modifiers.
 * It is a function which can be created without belonging to any class.
 * As learned in Functional Interface part, lambda expression can be used with Functional interfaces only.
 * Actually it is used to provide implementation for SAM(single abstract method) of Functional interfaces.
 * And that's the reason why the rule of single abstract method was imposed in Functional interfaces.
 * And even though Lambda expressions doesn't have return type but it must return value in accordance with the SAM of its Functional interface. 
 * So with the help of lambda expressions we can provide implementation for an abstract method an interface(particularly SAM of Function interface) without creating an implementation class of that.
 * Let's understand with an example - how can we use Lambda expressions to provide implementation for SAM without creating an implementation class.  
 */

/*
 * Basic syntax of lambda expression :-
 * *************************************************************
 * InterfaceName variableName = () -> {return "Whatever you want to return.return type should be in accordance with SAM"};
 * *************************************************************
 * For example write lambda expression for the following method :
 * -------------------------------------------------------------
 * public String m() {
 *	 return "Hello World";
 * }
 * -------------------------------------------------------------
 * Equivalent lambda Expression :
 * -------------------------------------------------------------
 * InterfaceName i = () -> System.out.println("Hello World");
 * -------------------------------------------------------------
 * Here we have not used curly braces and 'return' keyword.It is because if the implementation is of one line then these are not required.
 * Similarly if the SAM has exactly one argument(neither less nor more) then parenthesis is not required. 
 */

@FunctionalInterface
interface Interface1 {
	public void m1();
}

//Functional interface with void return type and no argument(i.e less than one argument)
@FunctionalInterface
interface Interface2 {
	public void m2();
}

//Functional interface with String return type and exactly one argument
@FunctionalInterface
interface Interface3 {
	public String m3(String name);
}

//Functional interface with int return type and 2 arguments(i.e more than one argument)
@FunctionalInterface
interface Interface4 {
	public int m4(int a, int b);
}

//Providing implementation for 'WithImplementationClass' interface.Without Lambda expression.
class ImplementedClass implements Interface1 {
	@Override
	public void m1() {
		System.out.println("Implementaion provided using implementation class");
	}
}

public class Part01_LambdaBasics {
	public static void main(String[] args) {
		//Providing implementation for remaining functional interfaces with the help of Lambda expression.
		//No need to create a special class for that.
		
		//No curly braces since implementation involves only one line and no return statement since return type is void in the Functional interface SAM.
		//Parenthesis is used for arguments since it has less than one argument.
		Interface2 i2 = () -> System.out.println("Implementation provided using lambda expression");
		//No curly braces and 'return' keyword isn't used to return desired value since implementation involves only one line 
		//Parenthesis isn't used for arguments since it has exactly one argument.  
		Interface3 i3 = n -> "Hello " + n + "!";
		//Curly braces and 'return' keyword is used since implementation involves more than 1 line 
		//Parenthesis is used for arguments since it has more than one arguments  
		Interface4 i4 = (a,b) -> {
			int sum = a+b;
			return sum;
		};
		
		//Accessing Functional interface method whose implementation is provided using Implementation class
		Interface1 i1 = new ImplementedClass();
		//We can also use class name i.e 'ImplementedClass' in place of interface name i.e 'WithImplementationClass' in the above line.
		i1.m1();
		
		//Accessing Functional interface method whose implementation is provided using Lambda expression
		i2.m2();
		i3.m3("Aman");
		i4.m4(5, 15);
	}	
}
