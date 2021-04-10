package com.tp.sec3.lamda_expressions;

import java.util.HashMap;

/*
 * In this part we will see few more examples of Lambda expressions
 */

interface Month {	
	public String getMonth(int m);
}

public class Part2_LambdaExample {
	static HashMap<Integer, String> months = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;
		{
			put(1, "January");
			put(2, "February");
			put(3, "March");
			put(4, "April");
			put(5, "May");
			put(6, "June");
			put(7, "July");
			put(8, "August");
			put(9, "September");
			put(10, "October");
			put(11, "November");
			put(12, "December");
		}
	};
	
	public static void main(String[] args) {
		Month s = m -> {
			return m > 0 && m <= 12 ? months.get(m):"Invalid Number";
		};
		
		String month1 = s.getMonth(7);
		System.out.println(month1);
		String month2 = s.getMonth(0);
		System.out.println(month2);		
				
	}
}
