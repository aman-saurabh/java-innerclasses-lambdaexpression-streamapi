package com.tp.sec1.inner_classes;

/*
 * Within the inner class 'this' always refers to current inner class object.
 * If you want to refer outer class object, we have to use 'OuterClassName.this' syntax for that.  
 * But please note.This is useful only in cases if both inner and outer class have property or method with same name.
 * Otherwise as we have seen in previous example(i.e in Part3).We can access both Static and Instance members of outer class directly inside inner class without using any keyword.    
 */

class OuterPart4{
	public String data = "Outer class data";
	class InnerPart4{
		public String data = "Inner class data";
		
		public void m1() {
			System.out.println("Using 'this' keywork directly : " + this.data);
			System.out.println("Using 'OuterClassName.this' keyword : " + OuterPart4.this.data);
		}
	}
}

public class Part04_Type1_ThisKeywordInInnerClass {
	public static void main(String[] args) {
		OuterPart4.InnerPart4 obj = new OuterPart4().new InnerPart4();
		obj.m1();
	}
}
