package com.tp.sec2.java8_interface_enhancement;

/*
 * In java 8 several enhancements were made for various purposes.
 * Some enhancements were made in interfaces also.Here in this section we will discuss mainly 2 topics related to Java 8 interface enhancements.
 * 	1.) Default and static methods in interfaces.
 * 	2.) Functional interfaces.   	
 * Before Java 1.8 version, interfaces in Java was able to contain only abstract methods (i.e methods without any definition).But this feature of interfaces is changed in Java 1.8 version.
 * Now interfaces in Java can have 'default' as well as 'static' methods also.
 * Actually the main problem with previous approach was every method in interfaces in java used to be abstract and public,
 * hence if any class wants to implement any interface, it has to provide implementation for all methods of that interface irrespective of whether it has use of that method or not.
 * Another major problem was - suppose an interface is implemented by several classes and few of those classes needs some extra feature(i.e method), 
 * then for such requirements if we add any new method in the interface then we had to provide implementation for that method in all classes that implements that interface irrespective of whether that class needs that method or not.
 * So to overcome these problems 'default' and 'static' methods were introduced in Java 1.8 version. 
 * We will learn about these methods in details next parts, Now let's see how we could use interfaces prior to Java 1.8 version.    
 */

interface VehiclePart1 {
	//Every variable in interface used to be always public, static and final, irrespective of whether we declare that or not.
	//Hence here 'brand' is also public, static and final even though we have not declared them like so.
	String brand = "Tata";
	//Every method in interface used to be always public and abstract(prior to Java 8).
	public int getNumberOfWheels(); 
	public void start();
}

class CarPart1 implements VehiclePart1{
	String model;
	public CarPart1(String model) {
		this.model = model;
	}
	
	@Override
	public int getNumberOfWheels() {
		return 4;
	}

	@Override
	public void start() {
		System.out.println(brand+" "+model+" started.");
	}	
}

class BusPart1 implements VehiclePart1{

	@Override
	public int getNumberOfWheels() {
		return 6;
	}

	@Override
	public void start() {
		System.out.println(brand+" bus started");
	}
	
}


public class Part1_EnhancementBasics {
	public static void main(String[] args) {
		CarPart1 car = new CarPart1("Safari");
		System.out.println("Number of wheels in the car : "+car.getNumberOfWheels());
		car.start();
		
		BusPart1 bus = new BusPart1();
		System.out.println("Number of wheels in the bus : "+bus.getNumberOfWheels());
		bus.start();
	}
}
