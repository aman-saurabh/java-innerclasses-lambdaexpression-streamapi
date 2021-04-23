package com.tp.sec4.double_colon_operator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.IntFunction;

/*
 * Demo program for how to use a static method as method reference in double colon operator.
 */

public class Part03_StaticMethodAsMethodReference {
	
	static String getWeekBeforedate(int weekCount){
		LocalDate l = LocalDate.now().minusWeeks(weekCount);
		DateTimeFormatter f = DateTimeFormatter.ofPattern("uuuu-MM-dd");
		return l.format(f);
	}
	
	public static void main(String[] args) {
		//Using lamda expression
		IntFunction<String> i1 = w -> {
			LocalDate l = LocalDate.now().minusWeeks(w);
			DateTimeFormatter f = DateTimeFormatter.ofPattern("uuuu-MM-dd");
			return l.format(f);
		};
		System.out.println(i1.apply(2));
		
		//Using double colon operator and static method getWeekBeforedate as method reference
		//Here since we are using static method hence object reference and hence object is not required.
		//We can refer static methods using class reference
		IntFunction<String> i2 = Part03_StaticMethodAsMethodReference::getWeekBeforedate;
		System.out.println(i2.apply(2));
	}
}
