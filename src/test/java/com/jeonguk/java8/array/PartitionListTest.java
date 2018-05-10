package com.jeonguk.java8.array;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Partition a List in Java
 */
public class PartitionListTest {

	@Test
	public void givenList_whenParitioningIntoNSublists_thenCorrect() {
		List<Integer> intList = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8);
		List<List<Integer>> subSets = Lists.partition(intList, 3);

		List<Integer> lastPartition = subSets.get(2);
		List<Integer> expectedLastPartition = Lists.newArrayList(7, 8);
		assertThat(subSets.size(), equalTo(3));
		assertThat(lastPartition, equalTo(expectedLastPartition));
	}
}
