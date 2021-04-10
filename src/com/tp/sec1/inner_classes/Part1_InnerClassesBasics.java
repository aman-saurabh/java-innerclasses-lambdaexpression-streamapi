package com.tp.sec1.inner_classes;

/*
 * Note :- 
 * Here I have not followed naming convention properly.
 * To make people, easy to understand the flow. I have used such naming convention.
 * Apart from that I have written a lot of comment as well in this project as this is for future references.   
 */

/*
 * Inner classes are classes which are defined inside of some other class.
 * If without existence of any class, there is no chance of existence of some another class then we should go for inner classes.  
 * For example - We should define Department class inside of University class.As without existence of University class, Department class can't exist.    
 * Similarly, in Java 'Map', data is stored in the form of key-value pair and each key-value pair is known as 'Entry'.
   Hence without existence of Map object, there is no chance of existence of Entry object hence 'Entry' interface is defined inside of 'Map' interface.   
 * In Java there are mainly 4 types of Inner classes.
 	1.) Normal or Regular inner classes.
 	2.) Method Local inner class.
 	3.) Anonymous inner class.
 	4.) Static Nested class. 
 * We will see details about these types in next parts.Now let's see a basic example of nested class.But before that please note the following point.
 * In inner classes we can't declare any static member, hence we can't declare 'main' method as well and hence we can't run inner classes directly from command line.
*/

class OuterPart1 {
	String name;
	public OuterPart1(String name) {
		this.name = name;
	}
	
	class InnerPart1{
		String name;
		public InnerPart1(String name) {
			this.name = name;
		}
	}	
}

public class Part1_InnerClassesBasics {
	public static void main(String[] args) {
		OuterPart1 o = new OuterPart1("Aman");
		OuterPart1.InnerPart1 i = o.new InnerPart1("Saurabh");
		System.out.println("Outer name : "+o.name);
		System.out.println("Inner name : " + i.name);
	}
}

