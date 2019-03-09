package com.string.practice;

import java.lang.invoke.MethodHandles;
import java.util.StringJoiner;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringJoinerPractice {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test
	public void commaSeparatedString() {
		StringJoiner str = new StringJoiner(",");
		str.add("jack").add("jim").add("jill");
		LOGGER.info("str={}", str);

		StringJoiner str2 = new StringJoiner(",", "{", "}");
		str2.add("jack").add("jim").add("jill");
		LOGGER.info("str2={}", str2);

		StringJoiner str3 = new StringJoiner("],[", "[", "]");
		str3.add("jack").add("jim").add("jill");
		LOGGER.info("str3={}", str3);

		StringJoiner str4 = new StringJoiner(",", "{", "}");
		str4.add("jack");
		LOGGER.info("str4={}", str4);

		StringJoiner str5 = new StringJoiner(",", "{", "}");
		LOGGER.info("str5={}", str5);

		StringJoiner str6 = new StringJoiner(",");
		str6.setEmptyValue("EMPTY");
		LOGGER.info("str6={}", str6);

		StringJoiner str7 = new StringJoiner(",", "{", "}");
		str7.setEmptyValue("EMPTY");
		LOGGER.info("str7={}", str7);
	}
}
