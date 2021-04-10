package com.tp.sec1.inner_classes;

/*
 * If we declare an inner class without any name such inner classes are known as Anonymous inner classes.
 * This kind of inner classes are useful in cases where we need an object for one time and instance use.
 * Based on the declaration and behavior, Anonymous inner classes are further divided into 3 sub-types.
 * 	1.)Anonymous inner class that extends a class
 * 	2.)Anonymous inner class that implements an interface
 * 	3.)Anonymous inner class as an arguments
 * We will see see sub-types in details in later parts.Now we will see a basic example of this type of inner class.But before that please note the following points.
 * 	1.)A normal java class can extend a class and can implement any number of interfaces.But an anonymous inner class can either extend a class or can implement an interface, but not both simultaneously.
 *  2.)In normal java class we can write any number of constructors butin anonymous inner class we can't write any constructor.It is because to write a constructor we need class name but anonymous inner classes doesn't have class name. 
 */
//Abstract class whose abstract method is implemented inside Anonymous inner class.
class ParentPart10{
	public void m1() {
		System.out.println("Method defined in Parent class.");
	}
}

public class Part10_Type3_AnonymousInnerClass {
	//Anonymous inner class to implement above Abstract class abstract method. 
	//Here actually 'c' is not holding Parent class object.Actually it is holding child class object.
	//But since the child class is Anonymous inner class(i.e it doesn't have any name), hence we have to hold its object in Parent class reference.
	ParentPart10 c = new ParentPart10() {
		public void m1() {
			System.out.println("Method defined in Anonymous inner class.");
		}
	};
	
	public static void main(String[] args) {
		//Calling Parent class m1() method.
		ParentPart10 p = new ParentPart10();
		p.m1();
		
		//Calling Anonymous inner class m1() method.
		Part10_Type3_AnonymousInnerClass obj = new Part10_Type3_AnonymousInnerClass();
		obj.c.m1();
		
		System.out.println(p.getClass().getName());
		//com.tp.sec1.inner_classes.ParentPart10
		
		System.out.println(obj.c.getClass().getName());
		//com.tp.sec1.inner_classes.Part10_Type3_AnonymousInnerClass$1
		//i.e the name of the Anonymous inner class is not based on the class it extends but it depends upon the class where it is declared.
		//Anonymous inner  class name = OuterClassName + $1, $2, $3...etc.Here 1,2,3... represents the position of Anonymous inner class among all anonymous classes defined inside the same Outer class.  
	}
}
