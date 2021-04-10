package com.tp.sec1.inner_classes;

/*
 * If we declare an inner class with name, directly inside a class (i.e outside of any method) and with static keywork.Then such classes are known as Static nested class.
 * To access Normal or Regular inner classes outside of the class where that is defined, we first have to create an object of Outer class and then only we can create an object of inner class.
 * But that is not the case of 'Static nested class'.In case of Static nested class we can access it without creating/having Outer class object.
 * i.e in case of Static nested class, inner class is strongly associated with outer class object. 
 */

/*
 * For Static nested class all types of access modifiers are allowed like abstract, final, public, private, protected etc.
 * But while using these access modifiers we should be careful as these modifier's own characteristics can create problem.
 * For example - If we use 'abstract' modifier in static nested class then we won't be able to create object of such classes.Therefore there is no benefit of declaring instance members in such classes.
 * Similarly - If we use 'private' access modifier in static nested class then we won't be able to access such static nested class outside of the Outer class.So if you need to access static nested class outside of outer class then never use 'private' with them.      
 */

class OuterPart14 {
	static class InnerPart14 {
		public void m1() {
			System.out.println("Static nested class instance method called");
		}

		public static void m2() {
			System.out.println("Static nested class static method called");
		}
	}

	public void outerClassInstanceMethod() {
		// Accessing Static nested class static method from outer class instance method.
		InnerPart14.m2();
		// Accessing Static nested class instance method from outer class instance method.
		// Since the member we want to access is instance member hence it's class object will be required irrespective of whether the class is static or not.
		InnerPart14 i = new InnerPart14();
		i.m1();
	}

	public static void outerClassStaticMethod() {
		// Accessing Static nested class static method from outer class static method.
		InnerPart14.m2();
		// Accessing Static nested class instance method from outer class static method.
		// Since the member we want to access is instance member hence it's class object will be required irrespective of whether the class is static or not.
		InnerPart14 i = new InnerPart14();
		i.m1();
	}
	// i.e in both cases (i.e outer class static method as well as outer class instance method), we have to access static nested class member in same way.
}

public class Part14_Type4_StaticNestedClass {
	public static void main(String[] args) {
		// Accessing outer class static method.
		OuterPart14.outerClassStaticMethod();
		
		// Accessing outer class instance member.
		OuterPart14 o = new OuterPart14();
		o.outerClassInstanceMethod();
		
		// Accessing Static nested class static method from outside of outer class.
		OuterPart14.InnerPart14.m2();
		// Accessing Static nested class instance method from outside of outer class.
		// Since the member we want to access is instance member hence it's class object will be required irrespective of whether the class is static or not.
		OuterPart14.InnerPart14 i = new OuterPart14.InnerPart14();
		i.m1();
	}
}
