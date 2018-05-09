package com.jeonguk.java8.functional;

import java.util.HashMap;
import java.util.Map;

public class FunctionalntfTest {

	public static void main(String[] args) {
		Map<String, Integer> salaries = new HashMap<>();
		salaries.put("John", 40000);
		salaries.put("Freddy", 30000);
		salaries.put("Samuel", 50000);

		//  Two-Arity Function Specializations
		salaries.replaceAll((name, oldValue) ->	name.equals("Freddy") ? oldValue : oldValue + 10000);

		System.out.println(salaries.toString());

		salaries.forEach((name, salary) -> System.out.println(name + " is " + salary ));
	}
}
