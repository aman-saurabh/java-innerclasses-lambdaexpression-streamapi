package com.tp.sec3.lamda_expressions;

import java.util.HashMap;
import java.util.function.Function;

/*
 * Java 8 another important predefined functional interface is 'Function' interface which is defined in 'java.util.function' package.
 * It accepts one argument and returns processed data.
 * SAM of 'Function' interface is 'apply'. 
 */

@FunctionalInterface
interface NumberInWords {
	public String getNumberInWord(int num);
}

public class Part10_FunctionExample {
	private static HashMap<String, String> m = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{
			put("1", "one");
			put("2", "two");
			put("3", "three");
			put("4", "four");
			put("5", "five");
			put("6", "six");
			put("7", "seven");
			put("8", "eight");
			put("9", "nine");
			put("11", "eleven");
			put("12", "twelve");
			put("13", "thirteen");
			put("14", "fourteen");
			put("15", "fifteen");
			put("16", "sixteen");
			put("17", "seventeen");
			put("18", "eighteen");
			put("19", "ninteen");
			put("10", "ten");
			put("20", "twenty");
			put("30", "thirty");
			put("40", "fourty");
			put("50", "fifty");
			put("60", "sixty");
			put("70", "seventy");
			put("80", "eighty");
			put("90", "ninty");
		}
	};
	
	private static String valueInWords(int num) {
		if (num == 0)
			return "zero";

		String s = String.valueOf(num);
		int len = s.length();
		char[] c = s.toCharArray();

		String result = "";
		boolean nextDisable = false;
		for (int i = 0; i < len; i++) {
			if (nextDisable) {
				nextDisable = false;
				continue;
			}
			int reverseIndex = len - (i + 1);
			String strVal = null;
			String currentVal = String.valueOf(c[i]);
			switch (reverseIndex) {
			case 0:
				strVal = m.get(currentVal);
				break;
			case 1: {
				int numVal = Integer.parseInt(currentVal);
				String s1;
				if (numVal == 1) {
					s1 = numVal + String.valueOf(c[i + 1]);
					nextDisable = true;
				} else {
					s1 = numVal + "0";
				}
				if (m.get(s1) != null)
					strVal = m.get(s1);
				break;
			}
			case 2:
				if (m.get(currentVal) != null)
					strVal = m.get(currentVal) + " hundred";
				break;
			case 3:
				if (m.get(currentVal) != null)
					strVal = m.get(currentVal) + " thousand";
				break;
			case 4: {
				int numVal = Integer.parseInt(currentVal);
				String s1;
				if (numVal == 1 || c[i + 1] == '0') {
					s1 = numVal + String.valueOf(c[i + 1]);
					if (m.get(s1) != null)
						strVal = m.get(s1) + " thousand";
					nextDisable = true;
				} else {
					s1 = numVal + "0";
					if (m.get(s1) != null)
						strVal = m.get(s1);
				}
				break;
			}
			case 5:
				if (m.get(currentVal) != null)
					strVal = m.get(currentVal) + " lakh";
				break;
			case 6: {
				int numVal = Integer.parseInt(currentVal);
				String s1;
				if (numVal == 1 || c[i + 1] == '0') {
					s1 = numVal + String.valueOf(c[i + 1]);
					if (m.get(s1) != null)
						strVal = m.get(s1) + " lakh";
					nextDisable = true;
				} else {
					s1 = numVal + "0";
					if (m.get(s1) != null)
						strVal = m.get(s1);
				}
				break;
			}
			default:
				break;
			}

			result += strVal != null ? result != "" ? " " + strVal : strVal : "";
		}

		return result;
	}

	public static void main(String[] args) {
		//Functionality to get numbers in word format using custom defined Functional interface NumberInWords
		//Here we have used double colon operator to provide functionality for SAM of NumberInWords interface.
		//We did so to reuse same function in Function interface implementation also.
		//For more details about Double colon operator check section 4
		NumberInWords n = Part10_FunctionExample::valueInWords;
		
		//Equivalent functionality using Function interface, so that we don't have to define custom FUnctional interface explecitely
		Function<Integer, String> f = Part10_FunctionExample::valueInWords;
		System.out.println("Please enter a number upto 9999999 to get its value in words.");
		String val1 = n.getNumberInWord(635758);
		String val2 = n.getNumberInWord(160900);
		String val3 = n.getNumberInWord(500016);
		String val4 = n.getNumberInWord(9995651);
		String val5 = n.getNumberInWord(0);
		String val6 = n.getNumberInWord(110);
		String val7 = n.getNumberInWord(1001);
		String val8 = n.getNumberInWord(100);
		String val9 = n.getNumberInWord(1000);
		String val10 = n.getNumberInWord(70300);
		// Don't start interger with '0', otherwise Java will consider it 'octal' number and implecitely convert it to equivalent decimal value.
		// Hence Java will consider '010' as octal number and will implecitely convert it to its equivalent decimal number 8 and hence we will get response as 'eight'.
		String inval = n.getNumberInWord(010);
		System.out.println(val1);
		System.out.println(val2);
		System.out.println(val3);
		System.out.println(val4);
		System.out.println(val5);
		System.out.println(val6);
		System.out.println(val7);
		System.out.println(val8);
		System.out.println(val9);
		System.out.println(val10);
		System.out.println(inval);
		//Testing some of above values using 'Function' interface implementation.
		String val11 = f.apply(635758);
		String val12 = f.apply(9995651);
		String val13 = f.apply(1000);
		String val14 = f.apply(70300);
		System.out.println(val11);
		System.out.println(val12);
		System.out.println(val13);
		System.out.println(val14);
	}
}
