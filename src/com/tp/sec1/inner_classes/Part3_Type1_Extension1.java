package com.tp.sec1.inner_classes;

/* 
 * From Normal or Regular inner class we can access both static and instance members of outer class directly (i.e without using 'this' or any other keyword).
 */
class OuterPart3{
	String instanceProp = "This is instance property";
	static String staticProp = "This is static property"; 
	class InnerPart3{
		public void innerClassMethod() {
			System.out.println(instanceProp);
			System.out.println(staticProp);
		}
	}
}

public class Part3_Type1_Extension1 {

	public static void main(String[] args) {
		OuterPart3.InnerPart3 obj = new OuterPart3().new InnerPart3();
		obj.innerClassMethod();
	}

}
