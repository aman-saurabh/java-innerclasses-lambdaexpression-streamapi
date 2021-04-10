package com.tp.sec2.java8_interface_enhancement;

/*
 * Functional interface - An interface is said to be functional interface if it has only one abstract method.
 * i.e SAM(Single Abstract Methods) interfaces are also known as Functional interfaces.
 * An annotation '@FunctionalInterface' was also introduced in Java 8 to declare an interface as Functional interface.
 * However this is not mandatory to apply but recommended as it make it easy for you and others to understand that it is a Functional interface 
 * and if someone tries to add any other abstract method in that interface by mistake then it will throw error and will alert them that this can create issue if it is used with some Lambda expressions.   
 * The concept of Functional interface was introduced to support 'Lambda expression' as Lambda expression can be used with Functional interfaces only.
 * We will see Lambda expressions in details in next section but for now let's see an example of Functional interface.   
 */


/*
 * Note :- In Functional interface one method restriction is applicable for abstract methods only i.e Functional interfaces can have any number of default and static methods as well.
 * Few examples of predefined functional interfaces in Java.
 * 'Runnable' interface -> Single abstract method(SAM) -> run()
 * 'Callable' interface -> Single abstract method(SAM) -> call()
 * 'Comparable' interface -> Single abstract method(SAM) -> compareTo()
 * 'Comparator' interface -> Single abstract method(SAM) -> compare()
 * 'ActionListner' interface -> Single abstract method(SAM) -> actionPerformed() 
 */

@FunctionalInterface
interface Greet{
	//SAM
	public void sayHello(String name);
	
	//Default method
	public default void defaultGreeting() {
		System.out.println("Hope you are doing well.");
	}
	
	//Static method
	public static void sayGoodMorning(String name) {
		System.out.println("Good Morning "+name+"!");
	}
}

public class Part5_FunctionalInterface implements Greet{
	@Override
	public void sayHello(String name) {
		System.out.println("Hello "+name+"!");
	}
	public static void main(String[] args) {
		Part5_FunctionalInterface p = new Part5_FunctionalInterface();
		//Accessing SAM
		p.sayHello("Aman");
		//Accessing default method
		p.defaultGreeting();
		//Accessing static method
		Greet.sayGoodMorning("Aman");
	}
}
