package com.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WildCards {

	@Test
	public void listOfObjects() {
		List<Object> objects = new ArrayList<>();
		objects.add("jack");
		objects.add(10);

		log.info("objects={}", objects);
	}

	@Test
	public void wildCardList() {
		List<?> wildCardList = new ArrayList<>();
		// wildCardList.add("jack"); // we cannot any object for only wild card list
		wildCardList.add(null);
	}
}