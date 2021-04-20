package com.tp.sec4.double_colon_operator;

/*
 * Demo program for how to use an existing constructor as method reference in double colon operator.
 * Note that this example might seem useless to you as in this example.
 * We have used constructor to simply print a message in the console, which we normally don't do in constructors.
 * Actually in this program we are simple showing how to use a constructor as method reference in double colon operator.
 * And to keep things simple we are not passing any argument to the constructor.
 * For real scenario like example i.e passing parameter to the constructor check next part.   
 */

class Test{
	public Test() {
		System.out.println("Test class object created");
	}
}

@FunctionalInterface
interface GetObject{
	//Factory method for Sample class
	public Test getTestObject();
}

public class Part4_ConstructorAsMethodReference1 {
	public static void main(String[] args) {
		//Using lamda expression 
		GetObject g1 = () -> new Test();
		g1.getTestObject();
		
		//Using double colon operator
		GetObject g2 = Test::new;
		g2.getTestObject();
	}
}
