package com.jeonguk.java8.array;

import com.google.common.collect.ImmutableList;
import org.apache.commons.collections4.ListUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Immutable ArrayList in Java
 */
public class ImmutableArrayListTest {

	@Test(expected = UnsupportedOperationException.class)
	public void givenUsingTheJdk_whenUnmodifiableListIsCreated_thenNotModifiable() {
		List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
		List<String> unmodifieableList = Collections.unmodifiableList(list);
		unmodifieableList.add("four");
	}

	// With Guava
	@Test(expected = UnsupportedOperationException.class)
	public void givenUsingGuava_whenUnmodifiableListIsCreated_thenNotModifiable() {
		List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
		List<String> unmodifiableList = ImmutableList.copyOf(list);
		unmodifiableList.add("four");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void givenUsingGuavaBuilder_whenUnmodifiableListIsCreated_thenNoLongerModifiable() {
		List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
		ImmutableList<Object> unmodifiableList = ImmutableList.builder().addAll(list).build();
		unmodifiableList.add("four");
	}

	// With the Apache Collections Commons
	@Test(expected = UnsupportedOperationException.class)
	public void givenUsingCommonsCollections_whenUnmodifiableListIsCreated_thenNotModifiable() {
		List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
		List<String> unmodifiableList = ListUtils.unmodifiableList(list);
		unmodifiableList.add("four");
	}
}
