package com.jeonguk.java8.guava;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ImmutableListTest {

	@Test
	public void immutableListTest_ContainsTrue() {
		ImmutableList<String> values = ImmutableList.of("0001","0009");
		assertTrue(ImmutableList.of("0001","0009").contains("0001"));
	}

	@Test
	public void immutableListTest_ContainsFalse() {
		ImmutableList<String> values = ImmutableList.of("0001","0009");
		assertFalse(ImmutableList.of("0001","0009").contains("0003"));
	}

}
