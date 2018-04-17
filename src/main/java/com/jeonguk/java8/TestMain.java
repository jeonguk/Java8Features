package com.jeonguk.java8;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {
	public static void main(String[] args) {
		// List<String> flowers = Arrays.asList("Ageratum", "Allium", "Poppy", "Catmint");
		String[] flowers = { "Ageratum", "Allium", "Poppy", "Catmint" };
		// List<String> flowerList = Arrays.asList(flowers); // UnsupportedOperationException
		List<String> flowerList = new ArrayList<>(Arrays.asList(flowers));
		flowerList.add("Celosia");

		List<String> list = ImmutableList.of("a","b","c");
		list.stream().forEach(System.out::println);

		Arrays.stream(new int[] {1, 2, 3})
				.map(n -> 2 * n + 1)
				.average()
				.ifPresent(System.out::println);

	}
}
