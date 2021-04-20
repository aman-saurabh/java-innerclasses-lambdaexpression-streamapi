package com.tp.sec5.stream_api;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * 
 */

class Student {
	private String name;
	private Set<String> topics;
	public Student(String name) {
		this.name = name;		
	}
	public Student(String name, String[] discussionTopics) {
		this.name = name;
		for (String topic: discussionTopics) {
			addTopic(topic);
		}
	}
	
	public void addTopic(String name) {
		if(this.topics == null) {
			this.topics = new HashSet<String>();
		}
		this.topics.add(name);
	}
	
	public Set<String> getTopics() {
		return this.topics;
	}
	
}

public class Part13_Intermediate_flatMap3 {
	public static void main(String[] args) {
		Student s1 = new Student("Aman");
		s1.addTopic("Java Basics");
		s1.addTopic("Multithreading in Java");
		s1.addTopic("JS fundamental");
		
		Student s2 = new Student("Manish", new String[] {"JS fundamental", "AngularJs Fundamentals", "AngularJS advance concepts"});
		s2.addTopic("NodeJs basics");
		
		Student s3 = new Student("vivek");
		s3.addTopic("Java Basics");
		s3.addTopic("Advance Java");
		s3.addTopic("NodeJs basics");
		
		List<Student> list = Arrays.asList(s1, s2, s3);
		
		
		Set<String> allDistinctTopics = list.stream().map(e -> e.getTopics()).flatMap(set -> set.stream()).collect(Collectors.toSet());
		System.out.println("All topics need to be discussed with requesting number of students : ");
		for(String topic: allDistinctTopics) {
			long numberOfStudents = list.stream().filter(e -> e.getTopics().contains(topic)).count();
			System.out.format("Topic : %s, Requesting number of students : %d\n", topic, numberOfStudents);
		}
		System.out.println();
		Set<String> jsTopics = list.stream().map(e -> e.getTopics()).flatMap(set -> set.stream()).filter(e -> e.toLowerCase().contains("js")).collect(Collectors.toSet());
		System.out.println("All JS related topics : ");
		Iterator<String> itr = jsTopics.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
