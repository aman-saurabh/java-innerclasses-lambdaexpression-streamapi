package com.tp.sec3.lamda_expressions;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/*
 * We can use different predefined functional interfaces in combination also:
 * However there is no such special function for such requirements
 * In this example we will see how to achieve that 
 */

class Student {
	String name;
	int marks;
	String grade;

	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}
}

public class Part16_ChainingDifferentPFI {
	public static void main(String[] args) {
		Predicate<Student> p = s -> s.marks > 60;
		Function<Student, Student> f = s -> {
			int marks = s.marks;
			String grade = null;
			if (marks >= 75)
				grade = "Distinction";
			else if (marks >= 60) 
				grade = "First class";
			else if (marks >=45)
				grade = "Second class";
			else if (marks >= 30) 
				grade = "Third class";
			else 
				grade = "Failed";
			s.grade = grade;
			return s;
		};
		Consumer<Student> c = s -> {
			System.out.format("Student info -> name : %s, marks: %d, grade: %s \n", s.name, s.marks, s.grade);
		};
		
		Student[] students = {
				new Student("Aman", 92),
				new Student("Mohit", 57),
				new Student("Manish", 42),
				new Student("Rajiv", 68),
				new Student("Vikash", 33)
		};
		
		//Student info who secured first class or distinction;
		for(Student stu: students) {
			if(p.test(stu)) {
				c.accept(f.apply(stu));
			}
		}
	}
}
