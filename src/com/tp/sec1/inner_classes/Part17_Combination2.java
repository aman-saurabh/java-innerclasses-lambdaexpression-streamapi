package com.tp.sec1.inner_classes;

/*
 * Combination 2 - Interface inside a class.
 * However we can define an interface inside a class without declaring its implementation class also, but most of the time we will use it with another inner class declared inside the same outer class, which will implement that inner interface.
 * But here we will see how can we use an interface inside a class without its implementation classes inside the same outer class.
 * If you want to see how to define inner interface and its implementation classes both inside the same outer class, simply put 'Car' class inside 'Vehicle' class and don't define constructor in that as in that cases you can use outer class members directly inside inner class.
 * Please note that in that case you won't be able to create object of 'Car' class inside 'main' method as it is created now, in that case you have to create object of 'Car' class with the help of Vehicle class.    
 */

class Vehicle{
	String brand;
	String model;
	public Vehicle(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	//Inner interface - i.e interface within a class
	interface VehicleWheel{
		int getNumberOfWheels();
	}
}

class Car extends Vehicle implements Vehicle.VehicleWheel{
	public Car(String brand, String model) {
		super(brand, model);
	}
	
	@Override
	public int getNumberOfWheels() {
		return 4;
	}
}

public class Part17_Combination2 {
	public static void main(String[] args) {
		Car car = new Car("Tata", "Safari");
		System.out.println("Name of the car : "+car.brand+" "+car.model);
		System.out.print("Number of wheels in the car : "+car.getNumberOfWheels());
	}
}
