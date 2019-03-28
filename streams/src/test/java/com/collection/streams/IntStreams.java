package com.collection.streams;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntStreams {

	@Test
	public void range() {
		IntStream intStream = IntStream.range(0, 11);
		IntConsumer intConsumer = (int i) -> log.info("i={}", i);
		intStream.forEach(intConsumer);
	}
}
