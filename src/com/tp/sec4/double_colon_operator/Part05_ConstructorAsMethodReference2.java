package com.tp.sec4.double_colon_operator;

class Customer {
	String name;
	int age;
	String location;
	public Customer(String name, int age, String location) {
		this.name = name;
		this.age = age;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return String.format("Customer info -> name : %s, age : %d, location : %s",name, age, location);
	}
}

interface ObjectCreator{
	public Customer getCustomer(String name, int age, String location);
}

public class Part05_ConstructorAsMethodReference2 {
	public static void main(String[] args) {
		//Using lamda expression
		ObjectCreator cus1 = (name, age, place) -> new Customer(name, age, place); 
		Customer c1 = cus1.getCustomer("Aman", 30, "Noida");
		System.out.println(c1);
		//Using double colon operator
		ObjectCreator cus2 = Customer::new;
		Customer c2 =  cus2.getCustomer("Saurabh", 31, "Gurgoan");
		System.out.println(c2);
	}
}
