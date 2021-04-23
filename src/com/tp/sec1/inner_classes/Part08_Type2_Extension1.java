package com.tp.sec1.inner_classes;

/*
 * If we declare Method local inner class inside of an instance method then we can access both static as well as instance members of outer class from within the inner class.
 * But if we declare Method local inner class inside of a static method then we can access only static member of outer class from within the inner class and its instance member.
 * This is due to the fact that instance members can't be accessed from within the static area.
 * We can access local variable of the method() in both cases. 
 */
public class Part08_Type2_Extension1 {
	public String instanceMember = "I am instance member";
	public static String staticMember = "I am static member";
	
	//Case1 :- Method local class declared inside instance method.
	public void m1() {
		String m1Var = "I am a variable defined within m1 method";
		class InstanceInner{
			public void innermethod() {
				System.out.println(instanceMember);
				System.out.println(staticMember);
				System.out.println(m1Var);
			}
		}
		
		InstanceInner i1 = new InstanceInner();
		i1.innermethod();
	}
	
	//Case1 :- Method local class declared inside instance method.
	public static void m2() {
		String m2Var = "I am a variable defined within m2 method";
		class StaticInner{
			public void innermethod() {
				//System.out.println(instanceMember);
				//If we uncomment above line then we will get error as instance members can't be accessed from static area.
				System.out.println(staticMember);
				System.out.println(m2Var);
			}
		}
		StaticInner s1 = new StaticInner();
		s1.innermethod();
	}
	
	public static void main(String[] args) {
		//Accessing static method m2 
		m2();
		
		//Accessing instance method m1
		Part08_Type2_Extension1 obj = new Part08_Type2_Extension1();
		obj.m1();
	}
}
