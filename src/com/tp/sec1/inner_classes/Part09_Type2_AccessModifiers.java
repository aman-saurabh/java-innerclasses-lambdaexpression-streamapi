package com.tp.sec1.inner_classes;

/*
 * Only 'final' and 'abstract' access modifiers are allowed in Method local inner class and no other is allowed.
 * For example 'public', 'static' etc are not allowed.
 */

public class Part09_Type2_AccessModifiers {

	String instanceVar = "I am outer class instance variable";
	static String staticVar = "I am outer class static variable";
	public void m1() {
		String methodLocalVar = "I am method local variable";
		abstract class InnerAbstract{
			public abstract void innerMethod();
		}
		
		final class InnerFinal extends InnerAbstract{
			@Override
			public void innerMethod() {
				System.out.println(instanceVar);
				System.out.println(staticVar);
				System.out.println(methodLocalVar);
			}
		}
		InnerFinal i = new InnerFinal();
		i.innerMethod();
	}
	
	public static void main(String[] args) {
		Part09_Type2_AccessModifiers p = new Part09_Type2_AccessModifiers();
		p.m1();
	}

}
