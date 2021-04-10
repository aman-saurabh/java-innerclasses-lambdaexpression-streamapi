package com.tp.sec3.lamda_expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Part5_LambdaForComparatorInterface1 {
	public static void main(String[] args) {
		//Defining for reverse alphabetical order.
		Comparator<Object> c = (s1, s2) -> {
			return s2.toString().compareTo(s1.toString());
		};
		List<Object> list = new ArrayList<Object>() {
			private static final long serialVersionUID = 1L;
			{
				add("Aman");
				add(new StringBuilder("Manish"));
				add(new StringBuffer("Saurabh"));
				add("Vivek");
			}
		};
		System.out.println("Before sorting list : "+list);
		Collections.sort(list, c);
		System.out.println("After sorting list : "+list);
	}
}
