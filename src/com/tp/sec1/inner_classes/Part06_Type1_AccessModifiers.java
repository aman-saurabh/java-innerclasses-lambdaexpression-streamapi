package com.tp.sec1.inner_classes;

/*
 * Normally for Java classes only following access modifiers are applicable.
 * 	1.)	public
 * 	2.)	<default>
 * 	3.) final
 * 	4.)	abstract
 * 	5.) strictfp
 * But please note that here we are talking about Java classes and not about there properties and methods.
 * Hence for Outer classes also only these access modifiers are allowed. 
 * But for inner classes apart from above access modifiers following access modifiers are also allowed.
 * 	1.) private
 * 	2.) protected
 * 	3.) static
 * In the following example we will see how can we use 'static' and 'protected' access modifier in inner classes.
 * Actually inner classes with 'static' keyword are known as 'Static Nested Classes'.Which we will see in Type4 in details.
 */

class OuterPart6{
	protected static class InnerPart6{
		String ip = "Inner Class Instance property";
		static String sp = "Inner Class Static property";
	}
	public void name() {
		//Accessing static member of Protected Static inner class from Outer class
		System.out.println(InnerPart6.sp);
		//Accessing instance member of Protected Static inner class from Outer class
		InnerPart6 innerObj = new InnerPart6();
		System.out.println(innerObj.ip);
	}
}

public class Part06_Type1_AccessModifiers {
	public static void main(String[] args) {
		//Accessing static member of Protected Static inner class from outside of Outer class
		System.out.println(OuterPart6.InnerPart6.sp);
		//Accessing instance member of Protected Static inner class from outside of Outer class
		OuterPart6.InnerPart6 obj = new OuterPart6.InnerPart6();
		System.out.println(obj.ip);
	}
}
