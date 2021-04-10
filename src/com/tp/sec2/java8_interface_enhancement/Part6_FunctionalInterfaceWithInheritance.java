package com.tp.sec2.java8_interface_enhancement;

@FunctionalInterface
interface P {
	public void m1();
}

//It is a valid Functional interface since method m1() is available to it as SAM through inheritance.  
@FunctionalInterface
interface A extends P {

}

//It is a valid Functional interface since method m1() is available to it as SAM through inheritance and it is not creating any new method just overriding that.
@FunctionalInterface
interface B extends P {
	public void m1();
}

//Not a valid Functional interface since method m1() is available to it through inheritance and it also declares an another abstract method m2().Hence can't apply @FunctionalInterface annotation to it.
//@FunctionalInterface
interface C extends P {
	public void m2();
}

public class Part6_FunctionalInterfaceWithInheritance implements A, B {

	@Override
	public void m1() {
		System.out.println("Implemention provided for SAM in implementation class");
	}

	public static void main(String[] args) {
		Part6_FunctionalInterfaceWithInheritance p = new Part6_FunctionalInterfaceWithInheritance();
		p.m1();
	}
}
