package com.string.practice;

import java.util.StringJoiner;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringJoinerPractice {

	@Test
	public void commaSeparatedString() {
		StringJoiner str = new StringJoiner(",");
		str.add("jack").add("jim").add("jill");
		log.info("str={}", str);

		StringJoiner str2 = new StringJoiner(",", "{", "}");
		str2.add("jack").add("jim").add("jill");
		log.info("str2={}", str2);

		StringJoiner str3 = new StringJoiner("],[", "[", "]");
		str3.add("jack").add("jim").add("jill");
		log.info("str3={}", str3);

		StringJoiner str4 = new StringJoiner(",", "{", "}");
		str4.add("jack");
		log.info("str4={}", str4);

		StringJoiner str5 = new StringJoiner(",", "{", "}");
		log.info("str5={}", str5);

		StringJoiner str6 = new StringJoiner(",");
		str6.setEmptyValue("EMPTY");
		log.info("str6={}", str6);

		StringJoiner str7 = new StringJoiner(",", "{", "}");
		str7.setEmptyValue("EMPTY");
		log.info("str7={}", str7);
	}
}
