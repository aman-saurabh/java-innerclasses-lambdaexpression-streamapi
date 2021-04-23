package com.tp.sec1.inner_classes;

class A{
	class B{
		class C {
			public void m1() {
				System.out.println("Nested inner class method called.");
			}
		}
	}
}

public class Part05_Type1_NestingOfInnerClasses {
	public static void main(String[] args) {
		A a = new A();
		A.B b = a.new B();
		A.B.C c = b.new C();
		c.m1();
	}
}
