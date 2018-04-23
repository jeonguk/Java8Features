package com.jeonguk.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamFilteringTest {

	Predicate<Person> pPredicate = person -> person.getName().equals("name2");

	@Test
	public void streamFilter_Test() {
		Person p1 = new Person();
		p1.setName("name1");
		p1.setAge(20);
		Person p2 = new Person();
		p2.setName("name2");
		p2.setAge(20);
		Person p3 = new Person();
		p3.setName("name3");
		p3.setAge(20);
		Person p4 = new Person();
		p4.setName("name3");
		p4.setAge(23);
		Person p5 = new Person();
		p5.setName("name5");
		p5.setAge(25);

		List<Person> personList = new ArrayList<>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);

		personList.stream().filter(p -> p.getName().equals("name3")).collect(Collectors.toList());
		//List<Person> filtered = personList.stream().filter(p -> p.getAge() == 20).collect(Collectors.toList());

		personList.stream().filter(p -> p.getAge() == 20).collect(Collectors.toList()).forEach(System.out::println);

		Predicate<Person> personPredicate = Objects::nonNull;
		Predicate<Person> namePredicate = p -> p.getName().equals("name2");

		Predicate<Person> fullPredicate = personPredicate.and(namePredicate);

		List<Person> personList1 = personList.stream().filter(fullPredicate).collect(Collectors.toList());

		System.out.println(personList1);

		System.out.println("---------------------------------------------------");
		personList.stream().filter(pPredicate).forEach(p -> System.out.println(p));
	}
}
