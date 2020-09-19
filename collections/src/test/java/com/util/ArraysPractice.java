package com.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

	@Test
	public void parallelSortPractice() {
		int[] intArray = new int[] { 5, 8, 6, 7, 9, 4, 2, 3, 0, 1 };

		String result;

		result = Arrays.stream(intArray).boxed().map(String::valueOf).collect(Collectors.joining(","));
		System.out.println("intArray before sorting: " + result);

		Arrays.parallelSort(intArray);
		result = Arrays.stream(intArray).boxed().map(String::valueOf).collect(Collectors.joining(","));
		System.out.println("intArray after sorting: " + result);

		// with external comparator
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return str2.compareTo(str1);
			}
		};
		String[] strArray = new String[] { "def", "ghi", "abc", "wer" };
		result = Arrays.stream(strArray).collect(Collectors.joining(","));
		System.out.println("strArray before sorting: " + result);

		Arrays.parallelSort(strArray, comparator);
		result = Arrays.stream(strArray).collect(Collectors.joining(","));
		System.out.println("strArray after sorting: " + result);

		// with lambda expression
		String[] strArray2 = new String[] { "weqwqew", "avdas", "desf", "abqwec" };
		Comparator<String> lengthComparator = (str1, str2) -> Integer.valueOf(str1.length()).compareTo(str2.length());
		Arrays.parallelSort(strArray2, lengthComparator);
		result = Arrays.stream(strArray2).collect(Collectors.joining(","));
		System.out.println("strArray2 after length sorting using lambda: " + result);
	}

	@Test
	public void parallelSetAllPractice() {
		String[] names = new String[] { "jack", "john", "jay", "jim" };
		System.out.println("names: before: " + Arrays.stream(names).collect(Collectors.joining(",")));

		Arrays.parallelSetAll(names, index -> "Hi " + names[index]);
		System.out.println("names: after: " + Arrays.stream(names).collect(Collectors.joining(",")));

		Arrays.setAll(names, index -> "Hello " + names[index]);
		System.out.println("names: after: " + Arrays.stream(names).collect(Collectors.joining(",")));
	}

	@Test
	public void parallelPrefixPractice() {
		String[] names = new String[] { "jack", "john", "jay", "jim", "jill", "jane" };
		System.out.println("names: before: " + Arrays.stream(names).collect(Collectors.joining(",")));
		Arrays.parallelPrefix(names, (x, y) -> x + "-" + y);
		System.out.println("names: after: " + Arrays.stream(names).collect(Collectors.joining(",")));

		names = new String[] { "jack", "john", "jay", "jim", "jill", "jane" };
		System.out.println("names: before: " + Arrays.stream(names).collect(Collectors.joining(",")));
		Arrays.parallelPrefix(names, 1, 3, (x, y) -> x + "-" + y);
		System.out.println("names: after: " + Arrays.stream(names).collect(Collectors.joining(",")));

	}

	@Test
	public void deepEqualsPractice() {
		Integer[] array1 = new Integer[] { 1, 2, 3, 4, 5 };
		Integer[] array2 = new Integer[] { 1, 2, 3, 4, 5 };
		Integer[] array3 = new Integer[] { 6, 7, 8, 9, 0 };

		System.out.println("Arrays.deepEquals(null, null) : " + Arrays.deepEquals(null, null));
		System.out.println("Arrays.deepEquals(array1, null) : " + Arrays.deepEquals(array1, null));
		System.out.println("Arrays.deepEquals(array1, array2) : " + Arrays.deepEquals(array1, array2));
		System.out.println("Arrays.deepEquals(array1, array3) : " + Arrays.deepEquals(array1, array3));
	}

	@Test
	public void hashCodePractice() {
		Integer[] array1 = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println("Arrays.hashCode(array1) : " + Arrays.hashCode(array1));
	}

	@Test
	public void deepHashCodePractice() {
		Integer[] array1 = new Integer[] { 1, 2, 3, 4, 5 };
		System.out.println("Arrays.deepHashCode(array1) : " + Arrays.deepHashCode(array1));
	}

	/**
	 * Assigns the specified long/int/double value to each element of the specified array of longs/ints/doubles
	 */
	@Test
	public void fill() {
		int[] ints = new int[5];
		Arrays.fill(ints, 1);
		Arrays.stream(ints).boxed().forEach(System.out::println);

		double[] doubles = new double[5];
		Arrays.fill(doubles, 1.2);
		Arrays.stream(doubles).boxed().forEach(System.out::println);
	}

}