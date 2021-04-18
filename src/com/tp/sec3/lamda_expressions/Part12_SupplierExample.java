package com.tp.sec3.lamda_expressions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

/*
 * Java 8 another important predefined functional interface is 'Supplier' interface which is defined in 'java.util.function' package.
 * It don't accept any argument but returns data which can be of any type.
 * SAM of 'Function' interface is 'get'. 
 */

interface DateFormat {
	public String getYesterdayDateInFormat();
}

public class Part12_SupplierExample {
	public static void main(String[] args) {
		//Using custom functional interface
		DateFormat g = () -> {
			LocalDateTime l = LocalDateTime.now().minusDays(1);
			DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
			return l.format(d);
		};
		
		//Same functionality using predefined functional interface 'Supplier'
		Supplier<String> s = () -> {
			LocalDateTime l = LocalDateTime.now().minusDays(1);
			DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
			return l.format(d);
		};
		
		System.out.println(g.getYesterdayDateInFormat());
		System.out.println(s.get());
	}
}
