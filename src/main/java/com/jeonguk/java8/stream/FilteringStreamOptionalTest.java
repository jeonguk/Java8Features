package com.jeonguk.java8.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class FilteringStreamOptionalTest {

	public static void main(String[] args) {
		List<Optional<String>> listOfOptionals = Arrays.asList(
				Optional.empty(), Optional.of("foo"), Optional.empty(), Optional.of("bar"));

		// Using filter()
		List<String> filteredList1 = listOfOptionals.stream()
				.filter(Optional::isPresent)
				.map(Optional::get)
				.collect(Collectors.toList());

		filteredList1.forEach(list -> log.info(list));

		// Using flatMap()
		List<String> filteredList2 = listOfOptionals.stream()
				.flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
				.collect(Collectors.toList());

		filteredList2.forEach(list -> log.info(list));

	}
}
