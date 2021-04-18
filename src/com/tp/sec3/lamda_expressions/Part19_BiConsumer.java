package com.tp.sec3.lamda_expressions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.BiConsumer;

/*
 * BiConsumer is similar to Consumer.Even their SAM and chaining are same.
 * The only difference is Consumer accepts one argument while BiFunction accepts two arguments.
 */

@FunctionalInterface
interface Delivery {
	public void getDeliveryInfo(int itemCount, int rate);
}

public class Part19_BiConsumer {
	public static String getDate() {
		LocalDate l = LocalDate.now().plusDays(1);
		DateTimeFormatter f = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		String date = l.format(f);
		return date;
	}
	public static void main(String[] args) {
		//Implementing custom functional interface
		Delivery t = (itemCount, rate) -> {
			String date = getDate();
			int price = itemCount*rate;
			System.out.format("Your delivery date is : %s, please pay Rs. %d on delivery\n", date, price);
		};
		//Same functionality with the help of predefined functional interface - BiConsumer
		BiConsumer<Integer, Integer> bc = (itemCount, rate) -> {
			String date = getDate();
			int price = itemCount*rate;
			System.out.format("Your delivery date is : %s, please pay Rs. %d on delivery\n", date, price);
		};
		
		t.getDeliveryInfo(5, 25);
		bc.accept(5, 25);
		
		//To demonstrate chaining of Biconsumers.
		BiConsumer<Integer, Integer> bc2 = (itemCount, rate) -> {
			System.out.format("Item rate is : Rs %d/unit and %d items has been ordered", itemCount, rate);
		};
		bc.andThen(bc2).accept(95, 3);
	}
}
