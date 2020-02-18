package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntStreams {

	@Test
	public void rangeEndExclusive() {
		IntStream intStream = IntStream.range(0, 11);
		IntConsumer intConsumer = (int i) -> log.info("i={}", i);
		intStream.forEach(intConsumer);
	}

	@Test
	public void rangeEndInclusive() {
		IntStream intStream = IntStream.rangeClosed(0, 10);
		IntConsumer intConsumer = (int i) -> log.info("i={}", i);
		intStream.forEach(intConsumer);
	}

	@Test
	public void intStreamToIntegerList() {
		// solution 1
		List<Integer> numberList = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
		log.info("numberList={}", numberList);

		// solution 2
		List<Integer> numberList2 = IntStream.rangeClosed(11, 20).mapToObj(Integer::valueOf)
				.collect(Collectors.toList());
		log.info("numberList2={}", numberList2);
	}

	@Test
	public void intStreamToLongList() {
		// solution 2
		List<Long> numberList1 = IntStream.rangeClosed(11, 20).mapToLong(Long::valueOf).boxed()
				.collect(Collectors.toList());
		log.info("numberList2={}", numberList1);
	}

	@Test
	public void intStreamToArray() {
		IntStream intStream = IntStream.range(0, 11);
		int[] intArray = intStream.toArray();
		log.info("intArray={}", Arrays.toString(intArray));
	}

}