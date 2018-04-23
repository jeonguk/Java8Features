package com.jeonguk.java8.stream;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class StreamFilterTest {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("name1");
		p1.setAge(20);
		Person p2 = new Person();
		p2.setName("name1");
		p2.setAge(21);
		Person p3 = new Person();
		p3.setName("name2");
		p3.setAge(33);

		List<Person> personList = new ArrayList<>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);

		final String param = "name1";
		personList.stream().filter(p -> p.getName().equals(param)).forEach(System.out::println);
	}
}

@Data
class Person {
	private String name;
	private int age;
	private String nickName;
}
