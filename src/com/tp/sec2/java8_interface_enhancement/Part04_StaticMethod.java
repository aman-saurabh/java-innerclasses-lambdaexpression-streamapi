package com.tp.sec2.java8_interface_enhancement;

/*
 * From Java 8, we can define 'static' method also in interfaces.
 * But these static methods aren't normal static methods which is inherited from interface to implementation classes in similar manner as it happens in class based inheritance.
 * Actually unlike class based inheritance, they aren't inherited in implementation classes by default.
 * But you can access them inside implementation classes using the Interface reference in which that static method is defined, and you can not access them using implementation Class reference or Object reference.
 * You can override such static methods in implementation classes with some other static method with same method signature.Actually this won't be overriding as static methods could not be overridden and unlike class based inheritance, neither it will be method hiding. 
 * Actually it will be a completely different local method which has nothing to do with interfaces static method.
 * In such case, You can access implementation class static method with Class based reference or its object based reference and you can access interfaces static method using interface reference. 
 * We can also write an instance method with same method signature in the implementation class also but that will also neither be method overriding nor method hiding.
 * Actually that will also be a different method which has nothing to do with interface static method.As the way to access static and instance methods are completely different.
 * In such cases if we access it as instance method using Object reference then implementation class instance method will be executed and if we access that as static method using interface reference then interface's static method will be executed.
 * This nature is same in normal class based inheritance also.In such case we can't access that using class reference in interface based inheritance but we can access that using class reference in class based inheritance.     
 * And also keep in mind that 'default' and 'static' are illegal combination i.e we can't use them together in same method.   
 */

interface MyInterface {
	public void abstractMethod();

	//We will not override this static method
	public static void firstStaticMethod() {
		System.out.println("First static method interface implementation");
	}

	//We will hide this method with some other static method with same method signature in implementation class 
	public static void secondStaticMethod() {
		System.out.println("Second static method interface implementation");
	}
	
	//We will create an instance method with same method signature in implementation class 
	public static void thirdStaticMethod() {
		System.out.println("Third static method interface implementation");
	}
}

class MyClass {
	//we will not override it
	public static void parentFirstStaticMethod() {
		System.out.println("Parent class first static method implementation");
	}
	
	//we will hide it in inheriting class with some static method with same signature
	public static void parentSecondStaticMethod() {
		System.out.println("Parent class second static method implementation");
	}
}

public class Part04_StaticMethod extends MyClass implements MyInterface {
	
	public static void parentSecondStaticMethod() {
		System.out.println("Parent class second static method inheriting class implementation");
	}

	@Override
	public void abstractMethod() {
		System.out.println("Abstract method inheriting class implementation");
	}
	
	public static void secondStaticMethod() {
		System.out.println("Second static method inheriting class implementation");
	}
	
	public void thirdStaticMethod() {
		System.out.println("Instance method implementation for third static method in inheriting class");
	}

	public static void main(String[] args) {
		Part04_StaticMethod p = new Part04_StaticMethod();
		
		/*
		 * Accessing Parent class static methods
		 */
		Part04_StaticMethod.parentFirstStaticMethod();
		//p.parentFirstStaticMethod();					//However it will work fine if uncommented but its not a good way to access static property using object reference.
		MyClass.parentFirstStaticMethod();
		
		Part04_StaticMethod.parentSecondStaticMethod();
		//p.parentSecondStaticMethod();					//However it will work fine if uncommented but its not a good way to access static property using object reference.
		MyClass.parentSecondStaticMethod();
		
		/*
		 * Accessing implemented interface static methods
		 */
		//Part4_StaticMethod.firstStaticMethod();		//Will throw error if uncomment
		//p.firstStaticMethod();						//Will throw error if uncomment
		MyInterface.firstStaticMethod();
		
		MyInterface.secondStaticMethod();
		Part04_StaticMethod.secondStaticMethod();
		//p.secondStaticMethod();						//However it will work fine if uncommented but its not a good way to access static property using object reference.
		
		MyInterface.thirdStaticMethod();
		//Part4_StaticMethod.thirdStaticMethod()		//Will throw error if uncomment
		p.thirdStaticMethod();							//Will call instance method of same class and has nothing to do with static method of inherited interface.
		
	}
}
