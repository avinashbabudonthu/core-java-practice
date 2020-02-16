package com.enums;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumPractice {

	/**
	 * Access one enum value
	 */
	@Test
	public void accessEnumValue() {
		Day monday = Day.MONDAY;
		log.info("monday={}", monday);
	}

	@Test
	public void iterateEnumValues() {
		for (Day day : Day.values()) {
			log.info("day={}", day);
		}
	}
}
