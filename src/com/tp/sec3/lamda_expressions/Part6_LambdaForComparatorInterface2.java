package com.tp.sec3.lamda_expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

class Customer implements Comparable<Customer> {
	int id;
	String name;

	public Customer(String name) {
		this.id = ThreadLocalRandom.current().nextInt(1000, 10000);
		this.name = name;
	}

	//Compare to return Customer with smaller id will come first. 
	@Override
	public int compareTo(Customer e) {
		return this.id > e.id ? 1 : this.id < e.id ? -1 : 0;
	}
	
	@Override
	public String toString() {
		return "(" + name + " : "+id+")";
	}

}

public class Part6_LambdaForComparatorInterface2 {
	public static void main(String[] args) {
		List<Customer> l = new ArrayList<Customer>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Customer("Aman"));
				add(new Customer("Saurabh"));
				add(new Customer("Sumit"));
				add(new Customer("Pawan"));
				add(new Customer("Nitin"));
			}
		};
		
		System.out.println("Before Sorting : "+l);
		//Sorting using Comparable interface compareTo() method.
		Collections.sort(l);		
		System.out.println("After Sorting : "+l);
		
		//Compare to return Customer with greater id will come first.
		Comparator<Customer> c = (e1, e2) -> e2.compareTo(e1);
		//Sorting using Comparator interface compare() method.
		Collections.sort(l,c);
		System.out.println("After Reverse Sorting : "+l);
	}
}
