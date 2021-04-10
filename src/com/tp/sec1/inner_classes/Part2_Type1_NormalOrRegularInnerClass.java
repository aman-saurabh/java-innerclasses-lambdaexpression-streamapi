package com.tp.sec1.inner_classes;

/*
 * This is first type of inner classes - Normal Or Regular Inner Classes.
 * If an inner class is declared with some name(i.e not an anonymous class), directly inside a class(i.e not within any method) and without static keyword such types of inner classes are called Normal or Regular inner class.
 * In Part1, we have seen an example of an inner class. That was also an example of an inner class. 
 * Now Let's see few more examples of how we can use inner classes at different areas.
 */

class OuterPart2{
	class InnerPart2{
		public void innerClassMethod() {
			System.out.println("Inner class method called");
		}
	}
	// Case1 :- From static area of Outer class.
	// Please note that in the same way we can use inner classes in the 'main' method of Outer class also. 
	public static void staticOuterMethod() {
		OuterPart2 o1 = new OuterPart2();
		//Outer class Object is required since we can't access any class instance member from static area directly. 
		OuterPart2.InnerPart2 i1 = o1.new InnerPart2();
		i1.innerClassMethod();
	}
	
	// Case2 :- From instance area of Outer class.
	public void instanceOuterMethod() {
		InnerPart2 i2 = new InnerPart2();
		i2.innerClassMethod();
	}
	// Case3 :- From Outside of Outer class.
	// Similar to that of Case1 i.e as we access in Outer class static area.
	// To see example check how we called 'innerClassMethod' in main method of 'Part2_Type1_NormalOrRegularInnerClass' class. 
}

public class Part2_Type1_NormalOrRegularInnerClass {
	public static void main(String[] args) {
		//Calling Outer class 'staticOuterMethod'.
		OuterPart2.staticOuterMethod();
		OuterPart2 o3 = new OuterPart2();
		//Calling Outer class 'instanceOuterMethod'.
		o3.instanceOuterMethod();
		OuterPart2.InnerPart2 i3 = o3.new InnerPart2();
		//Calling directly Inner class 'innerClassMethod'.
		i3.innerClassMethod();
	}
}