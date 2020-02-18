package com.streams;

import java.util.Arrays;
import java.util.function.LongConsumer;
import java.util.stream.LongStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongStreams {

	@Test
	public void rangeEndExclusive() {
		LongStream longStream = LongStream.range(0, 11);
		LongConsumer longConsumer = (long l) -> log.info("l={}", l);
		longStream.forEach(longConsumer);
	}

	@Test
	public void rangeEndInclusive() {
		LongStream longStream = LongStream.rangeClosed(0, 11);
		LongConsumer longConsumer = (long l) -> log.info("l={}", l);
		longStream.forEach(longConsumer);
	}

	@Test
	public void longStreamToArray() {
		LongStream longStream = LongStream.range(0, 11);
		long[] intArray = longStream.toArray();
		log.info("intArray={}", Arrays.toString(intArray));
	}
}
