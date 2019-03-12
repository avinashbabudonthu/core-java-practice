package com.string.practice;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringPractice {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test
	public void split() {
		String input = "welcome, to String practice";

		LOGGER.info("-- split by space --");
		String[] split1 = input.split(" ");
		Arrays.stream(split1).forEach(str -> LOGGER.info("--{}--", str));

		LOGGER.info("-- split by word break --");
		String[] split2 = input.split("\\b");
		Arrays.stream(split2).forEach(str -> LOGGER.info("--{}--", str));

		LOGGER.info("-- split by word --");
		Arrays.stream(split2).filter(str -> str.matches("\\w+")).forEach(str -> LOGGER.info("--{}--", str));
	}
}
