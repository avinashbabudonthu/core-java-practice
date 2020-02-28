package com.util;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Slf4j
public class ArraysPractice {

	/**
	 * 1. list does not support operations like add, remove, set
	 *  because unlike normal list the size of this list is fixed and size equal to the
	 *  number of elements of array
	 * 2. If we perform any add, remove etc operation on this list then
	 *  java.lang.UpsupportedOperationException will be thrown
	 */
	@Test
	public void convertArrayToList() {
		String[] stringArray = { "a", "b", "c", "d", "e" };
		List<String> list = Arrays.asList(stringArray);
		log.info("list={}", list);
	}

	@Test
	public void arrayStoreException() {
		String[] strArray = new String[3];
		Object[] objArray = strArray;
		objArray[0] = "1";

		try {
			objArray[0] = 2;
		} catch (Exception e) {
			log.error("Exception", e);
		}
	}
}