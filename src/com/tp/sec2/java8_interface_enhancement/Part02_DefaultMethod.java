package com.tp.sec2.java8_interface_enhancement;

/*
 * In this part we will learn about 'default' method of interfaces which were introduced in Java 1.8 version.
 * The main purpose of introducing default method was to provide default implementation for a method in interfaces.
 * So that the class which don't need that method or is OK with default implementation can continue with default implementation. 
 * And the class which is not OK with default implementation and needs to provide customized implementation for the method can override that method.
 * A method inside of an interface is said to be default method if it has implementation and it is declared with 'default' keyword.
 * Please note that I have used the word 'keyword' for default and not 'access modifier'.
 * It is because even though 'default' keyword is used in similar manner as access modifiers in interfaces but it is actually not an access modifier.
 * Default methods are also known as 'Defender method' or 'Virtual extension method'.     
 */

interface VehiclePart2 {
	//Every variable in interface used to be always public, static and final, irrespective of whether we declare that or not.
	//Hence here 'brand' is also public, static and final even though we have not declared them like so.
	String brand = "Tata";
	//default method
	public default int getNumberOfWheels() {
		return 6;
	}
	//abstract method
	public void start();
}

class CarPart2 implements VehiclePart2{
	String model;
	public CarPart2(String model) {
		this.model = model;
	}
	
	//Overriding default method - To provide customized implementation.
	@Override
	public int getNumberOfWheels() {
		return 4;
	}

	@Override
	public void start() {
		System.out.println(brand+" "+model+" started.");
	}	
}

class BusPart2 implements VehiclePart2{
	//No implementation for default method.It is OK with default implementation. 
	@Override
	public void start() {
		System.out.println(brand+" bus started");
	}
}

public class Part02_DefaultMethod {
	public static void main(String[] args) {
		CarPart2 car = new CarPart2("Safari");
		System.out.println("Number of wheels in the car : "+car.getNumberOfWheels());
		car.start();
		
		BusPart2 bus = new BusPart2();
		System.out.println("Number of wheels in the bus : "+bus.getNumberOfWheels());
		bus.start();
	}
}
