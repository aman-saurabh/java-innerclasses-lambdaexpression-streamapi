package com.tp.sec1.inner_classes;

/*
 * This is second type of inner classes - Method Local Inner Classes.
 * If we define an inner class inside any method of some other class then such inner classes are known as Method Local Inner Classes.
 * If we have requirement of a kind of object inside a particular function only then for such requirements 'Method Local Inner Class' is best suitable.
 * Apart from that it is also best suitable to meet nested methods(i.e method defined within a method) requirements as nested methods are not allowed in Java. 
 * However since 'Method Local inner class' can be accessed only within the class where it is declared.Hence they are the most rarely used inner classes.   
 */



public class Part07_Type2_MethodLocalInnerClass {
	
	//Case1 :- If we have requirement of 'Employee' object inside a function only
	public static String m1(String userName, String wifeName, String childName) {
		class User {
			public String name;
			public String relationship;
			public User(String name, String relationaship) {
				this.name = name;
				this.relationship = relationaship;
			}
			@Override
			public String toString() {
				return relationship+" - "+name+"; ";
			}
		}
		User user = new User(userName, "Self");
		User wife = new User(wifeName, "Wife");
		User child = new User(childName, "Child");
		return "Family info : "+user.toString()+wife.toString()+child.toString();
	}
	
	//Case2 :- If we have requirement of nested method
	public static int m2(int[] x) {
		int currentVal = 0;
		class Add {
			int a;
			int b;
			public Add(int a, int b) {
				this.a = a;
				this.b = b;
			}
			
			//Nested method.Created using Method local inner class. 
			public int getSum() {
				return a+b;
			}
		}
		for (int i : x) {
			//However this is not the best way to achieve it, We did this in this way just to show how Method local inner class can be used for such requirements.
			Add a = new Add(currentVal, i);
			currentVal = a.getSum();
		}
		return currentVal;
	}

	public static void main(String[] args) {
		// Case1 result.
		String family = m1("Samir", "Swati", "Bunny");
		System.out.println(family);
		
		//Case2 result.
		int[] nums = new int[] {1,2,3,4,5};
		int sum = m2(nums);
		System.out.println(sum);
	}

}
