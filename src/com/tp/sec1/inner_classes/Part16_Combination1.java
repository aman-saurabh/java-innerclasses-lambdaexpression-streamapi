package com.tp.sec1.inner_classes;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import com.tp.sec1.inner_classes.University.Department;

/*
 * Using the concept of inner classes,we can define a class or an interface inside another class or interface.
 * So now we will see various combinations of inner classes and interfaces.
 * Mainly there can exist 4 combinations of inner classes and interfaces.
 * 	1.) Class inside a class
 * 	2.) Interface inside a class
 * 	3.) Interface inside an interface
 * 	4.)	Class inside interface 
 * In this part we will see first combination i.e 'Class inside a class'.
 * However we have already seen several examples of this combination in previous sections.But still let's see an example of this combination here. 
 */

class University{
	class Department{
		String name;
		String hod;
		private Department(String name, String hod) {
			this.name = name;
			this.hod = hod;
		}
		@Override
		public String toString() {
			return "Department : "+name+", HOD : "+hod;
		}
	}
	
	Department physics = new Department("Physics", "Mr. I. Newton");
	Department mathematics = new Department("Mathematics", "Mr. S. Ramanujan");
	Department biology = new Department("Biology", "Mr. J.C. Bose");
	
	public List<Department> getDepartments() {
		return Arrays.asList(physics, mathematics, biology);
	}
}

public class Part16_Combination1 {
	public static void main(String[] args) {
		University u = new University();
		//We can using 'Department' directly and not as 'University.Department'.It is because we have imported 'Department' from its path in the top of this file.
		List<Department> departmentList = u.getDepartments();
		ListIterator<Department> litr = departmentList.listIterator();
		while (litr.hasNext()) {
			Department department = (Department) litr.next();
			System.out.println(department);
		}
	}
}
