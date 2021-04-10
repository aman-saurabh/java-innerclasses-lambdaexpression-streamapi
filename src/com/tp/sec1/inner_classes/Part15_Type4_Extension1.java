package com.tp.sec1.inner_classes;

/*
 * From Normal or Regular inner classes, we can access both static and non-static members (i.e instance members) directly.
 * But from static nested class we can access only static members of the outer class directly but not the instance members.
 * To access instance members of the outer class we will need object of outer class inside the static nested class. 
 */

class OuterPart15{
	int x = 5;
	static int y = 15;
	static class InnerPart15{
		public int getSum() {
			// We can't access 'x' directly here inside static nested class as it is an instance member of outer class.
			// To access 'x' we need to create an object of Outer class here.
			// However we can access 'y' directly without the need of object of Outer class as this is a static member of outer class. 
			OuterPart15 o = new OuterPart15();
			return o.x + y;
		}
	}
}

public class Part15_Type4_Extension1 {
	public static void main(String[] args) {
		OuterPart15.InnerPart15 i = new OuterPart15.InnerPart15();
		int sum = i.getSum();
		System.out.println(sum);
	}
}
