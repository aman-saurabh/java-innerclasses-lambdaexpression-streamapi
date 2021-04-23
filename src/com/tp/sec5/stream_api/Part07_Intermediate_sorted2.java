package com.tp.sec5.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * In this part we will see how to use default natural sorting for custom classes.
 */

class Customer implements Comparable<Customer> {
	int id;
	String name;

	public Customer(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Customer id - %d, name - %s", id, name);
	}

	@Override
	public int compareTo(Customer c) {
		return this.id > c.id ? 1 : this.id < c.id ? -1 : 0;
	}

}

public class Part07_Intermediate_sorted2 {
	public static void main(String[] args) {
		Customer[] cust = {
				new Customer(1, "Aman"),
				new Customer(5, "Pawan"),
				new Customer(7, "Mohit"),
				new Customer(3, "Irfan"),
				new Customer(6, "Mike")
		};
		List<Customer> l = Arrays.stream(cust).sorted().collect(Collectors.toList());
		for(Customer c : l) {
			System.out.println(c);
		}
	}
}
