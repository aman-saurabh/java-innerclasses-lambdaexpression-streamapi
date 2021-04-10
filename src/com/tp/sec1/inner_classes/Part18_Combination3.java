package com.tp.sec1.inner_classes;


/*
 * Combination 3 - Interface inside an interface.
 * Best example of this combination is 'Map' and 'Entry' interface. 
 * Please note that - Every interface present inside an interface is always 'public' and 'static', irrespective of whether we declare it or not.
 * It is due to the fact that every member of an interface is always 'public' and 'static'.
 * Hence we can implement inner interface directly without implementing outer interface.
 * Similarly to implement outer interface, it is not required to implement inner interface as well.
 * i.e we can implement outer and inner interfaces independently.
 * let's understand it with an example.
 */

interface OuterPart18{
	public void outerMethod();
	
	interface InnerPart18{
		public void innerMethod();
	}
}

class OuterImpl implements OuterPart18{
	@Override
	public void outerMethod() {
		System.out.println("Outer interface method called");
	}
}

class InnerImpl implements OuterPart18.InnerPart18{
	@Override
	public void innerMethod() {
		System.out.println("Inner interface method called");
	}
}

public class Part18_Combination3 {
	public static void main(String[] args) {
		//Calling outer interface method.
		OuterImpl o = new OuterImpl();
		o.outerMethod();
		
		//Calling inner interface method.
		InnerImpl i = new InnerImpl();
		i.innerMethod();
	}
}
