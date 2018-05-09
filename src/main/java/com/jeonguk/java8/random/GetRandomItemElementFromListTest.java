package com.jeonguk.java8.random;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Slf4j
public class GetRandomItemElementFromListTest {

	public static void main(String[] args) {
		//givenList_whenNumberElementsChosen_shouldReturnRandomElementsRepeat();
		//givenList_whenNumberElementsChosen_shouldReturnRandomElementsNoRepeat();
		//givenList_whenSeriesLengthChosen_shouldReturnRandomSeries();
	}

	// Single Random Item
	public static void givenList_shouldReturnARandomElement() {
		List<Integer> givenList = Arrays.asList(1, 2, 3);
		Random rand = new Random();
		int randomElement = givenList.get(rand.nextInt(givenList.size()));
		log.info("Single Random Item randomElement {}", randomElement);
	}

	// Select Random Items With Repetitions
	public static void givenList_whenNumberElementsChosen_shouldReturnRandomElementsRepeat() {
		Random rand = new Random();
		List<String> givenList = Arrays.asList("one", "two", "three", "four");

		int numberOfElements = 2;

		for (int i = 0; i < numberOfElements; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			String randomElement = givenList.get(randomIndex);
			log.info("Select Random Items With Repetitions randomElement {} - {}", i, randomElement);
		}
	}

	// Select Random Items Without Repetitions
	public static void givenList_whenNumberElementsChosen_shouldReturnRandomElementsNoRepeat() {
		Random rand = new Random();
		List<String> givenList = Lists.newArrayList("one", "two", "three", "four");

		int numberOfElements = 2;

		for (int i = 0; i < numberOfElements; i++) {
			int randomIndex = rand.nextInt(givenList.size());
			String randomElement = givenList.get(randomIndex);
			givenList.remove(randomIndex);
			log.info("Select Random Items Without Repetitions randomElement {}", randomElement);
		}
	}

	// Select Random Series
	public static void givenList_whenSeriesLengthChosen_shouldReturnRandomSeries() {
		List<Integer> givenList = Lists.newArrayList(1, 2, 3, 4, 5, 6);
		Collections.shuffle(givenList);

		int randomSeriesLength = 3;

		List<Integer> randomSeries = givenList.subList(0, randomSeriesLength);
		log.info("Select Random Series randomSeries {}", randomSeries);
	}

}
