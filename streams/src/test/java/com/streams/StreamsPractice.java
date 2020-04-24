package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

public class StreamsPractice {

	@Test
	public void findFirstAndFilter() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 7);

		Optional<Integer> integerOptional = list.stream().filter(i -> i == 6).findFirst();
		System.out.println(integerOptional);

		list.stream().filter(i -> i == 6).findFirst().get();
	}
}
