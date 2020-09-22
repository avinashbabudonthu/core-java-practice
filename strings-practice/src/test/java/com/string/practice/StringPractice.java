package com.string.practice;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringPractice {

	@Test
	public void createString() {
		String s1 = new String("Alia");
		log.info("s1={}", s1);
	}

	@Test
	public void getbyteArrayFromString() {
		String string = "Hello World";

		// method 1
		byte[] byteArray1 = string.getBytes();

		// byteArray1: [B@41a4555e
		System.out.println("byteArray1: " + byteArray1);

		// Arrays.toString(byteArray1): [72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100]
		System.out.println("Arrays.toString(byteArray1): " + Arrays.toString(byteArray1));

		//method 2
		byte[] byteArray2 = string.getBytes(Charset.forName("UTF-8"));

		// byteArray2: [B@3830f1c0
		System.out.println("byteArray2: " + byteArray2);

		// Arrays.toString(byteArray2): [72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100]
		System.out.println("Arrays.toString(byteArray2): " + Arrays.toString(byteArray2));

		// method 3 - from java 7
		byte[] byteArray3 = string.getBytes(StandardCharsets.UTF_8);

		// byteArray3: [B@39ed3c8d
		System.out.println("byteArray3: " + byteArray3);

		// Arrays.toString(byteArray3): [72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100]
		System.out.println("Arrays.toString(byteArray3): " + Arrays.toString(byteArray3));
	}

	@Test
	public void getAsciValueOfCharsInString() {
		String str = "abcdefghijklmnopqrstuvwxyz";
		byte[] strByteArray = str.getBytes();

		// asciValues: [97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122]
		System.out.println("asciValues: " + Arrays.toString(strByteArray));
	}

	@Test
	public void convertByteArrayToString() {
		String str = "Hello World";
		byte[] byteArray = str.getBytes();

		// str: Hello World
		System.out.println("str: " + str);

		// byteArray: [B@41a4555e
		System.out.println("byteArray: " + byteArray);

		String strFromByteArray = new String(byteArray);

		// strFromByteArray: Hello World
		System.out.println("strFromByteArray: " + strFromByteArray);
	}

	@Test
	public void divideString() {
		/*
		 * Hello
			Java
			World
			Welcome
			to
			Java
		 */
		String str = "Hello-Java-World-Welcome-to-Java";
		String[] strs = str.split("-");
		for (String s : strs) {
			System.out.println(s);
		}

		// using StringTokenizer
		/*
		 * Hello
			Java
			World
			Welcome
			to
			Java
		 */
		System.out.println("------- Using StringTokenizer -------- ");
		StringTokenizer stringTokenizer = new StringTokenizer(str, "-");
		for (;; stringTokenizer.hasMoreTokens()) {
			System.out.println(stringTokenizer.nextToken());
		}
	}

	@Test
	public void stringToCharArray() {
		String str = "Hello World";
		byte[] byteArray = str.getBytes();
		String byteString = Arrays.toString(byteArray);

		// [72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100]
		System.out.println(byteString);

		byteString = byteString.substring(1, byteString.length() - 1);

		// 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100
		System.out.println(byteString);

		String[] asciValues = byteString.split(",");

		List<String> charsList = new ArrayList<>();

		for (String asciValue : asciValues) {
			String c = String.valueOf((char) Integer.parseInt(asciValue.trim()));
			charsList.add(c);
		}

		// [H, e, l, l, o,  , W, o, r, l, d]
		System.out.println(charsList);
	}

	/**
	 * Output:
	 * 	capitalStr: HELLO WORLD
		lowerStr: hello world
	 */
	@Test
	public void convertCase() {
		String str = "hello world";
		String capitalStr = str.toUpperCase();
		System.out.println("capitalStr: " + capitalStr);

		String lowerStr = capitalStr.toLowerCase();
		System.out.println("lowerStr: " + lowerStr);
	}

	@Test
	public void capitalizeFirstChar() {
		String hello = "hello";

		String result = hello.substring(0, 1).toUpperCase() + hello.substring(1, hello.length());

		// Hello
		System.out.println(result);
	}

	/**
	 * Output:
	 * 	bcda
		cdab
	 */
	@Test
	public void stringShift() {
		String s = "abcd";
		if (s.isEmpty()) {
			return;
		}
		int leftShift = 1;
		while (leftShift > s.length()) {
			leftShift = leftShift - s.length();
		}
		String leftShiftResult = s.substring(leftShift) + s.substring(0, leftShift);
		System.out.println(leftShiftResult);

		int rightShift = 3;
		int length = 0;
		if (leftShiftResult.length() > rightShift)
			length = leftShiftResult.length() - rightShift;
		else
			length = rightShift - leftShiftResult.length();

		String rightShiftResult = leftShiftResult.substring(length) + leftShiftResult.substring(0, length);
		System.out.println(rightShiftResult);
	}

	/**
	 * Output:
	 * 	[wel, elc, lco, com, ome, met, eto, toj, oja, jav, ava]
		[welc, elco, lcom, come, omet, meto, etoj, toja, ojav, java]
		[welco, elcom, lcome, comet, ometo, metoj, etoja, tojav, ojava]
	 */
	@Test
	public void printAllSubStringsOfSpecifiedLength() {
		String s = "welcometojava";

		// substring of length 3
		List<String> subStrings = new ArrayList<>();
		for (int i = 0; i <= s.length() - 3; i++) {
			subStrings.add(s.substring(i, i + 3));
		}
		System.out.println(subStrings);

		// substring of length 4
		List<String> subStrings2 = new ArrayList<>();
		for (int i = 0; i <= s.length() - 4; i++) {
			subStrings2.add(s.substring(i, i + 4));
		}
		System.out.println(subStrings2);

		// substring of length 5
		List<String> subStrings3 = new ArrayList<>();
		for (int i = 0; i <= s.length() - 5; i++) {
			subStrings3.add(s.substring(i, i + 5));
		}
		System.out.println(subStrings3);
	}

	/**
	 * Output:
	 * 	strList: [Welcome, to, hacker, rank, test]
		sort by length: [to, rank, test, hacker, Welcome]
	 */
	@Test
	public void sortStringsInSentnceByLength() {
		String str = "Welcome to hacker rank test";
		String[] strs = str.split(" ");

		List<String> strList = Arrays.asList(strs);

		System.out.println("strList: " + strList);

		Comparator<String> lengthComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.valueOf(o1.length()).compareTo(Integer.valueOf(o2.length()));
			}
		};

		Collections.sort(strList, lengthComparator);
		System.out.println("sort by length: " + strList);
	}

	/**
	 * Output:
	 * 	C:\output-2018-02-15T16-20-19.002.txt
	 */
	@Test
	public void replaceAll() {
		String filePathWithName = "C:\\output-" + LocalDateTime.now().toString().replaceAll(":", "-") + ".txt";

		System.out.println(filePathWithName);
	}

	/**
	 * Output:
	 * 	Hello welcome to java String practice examples. Have Fun 
		Hello welcome to java String practice examples. Have Fun
	 */
	@Test
	public void removeSpacesInString() {
		String str = "Hello  welcome to  java   String practice  examples.   Have Fun";

		// using for each
		String[] words = str.split(" ");
		StringBuffer sentence = new StringBuffer();
		Stream.of(words).forEach(word -> {
			if (!word.trim().isEmpty())
				sentence.append(word).append(" ");
		});
		System.out.println(sentence);

		// using JDK 8
		String sentence2 = Stream.of(words).filter(word -> !word.trim().isEmpty()).collect(Collectors.joining(" "));
		System.out.println(sentence2);
	}

	/**
	 * Get Last N characters of String
	 * 
	 */
	@Test
	public void lastNCharactersOfString() {
		String alphabets = "abcdefghijklmnopqrstuvwxyz";

		// alphabets=abcdefghijklmnopqrstuvwxyz
		log.info("alphabets={}", alphabets);

		// last5Characters=vwxyz
		String last5Characters = lastNCharactersOfString(alphabets, 5);
		log.info("last5Characters={}", last5Characters);

		// last-10-characters=qrstuvwxyz
		String last10Characters = lastNCharactersOfString(alphabets, 10);
		log.info("last-10-characters={}", last10Characters);
	}

	private String lastNCharactersOfString(String str, int n) {
		String result = str;
		if (Objects.nonNull(str) && str.length() > n) {
			result = str.substring(str.length() - n);
		}
		return result;
	}

	/**
	 * Split the String
	 */
	@Test
	public void split() {
		String input = "welcome, to String practice";

		log.info("-- split by space --");
		String[] split1 = input.split(" ");
		Arrays.stream(split1).forEach(str -> log.info("--{}--", str));

		log.info("-- split by word break --");
		String[] split2 = input.split("\\b");
		Arrays.stream(split2).forEach(str -> log.info("--{}--", str));

		log.info("-- split by word --");
		Arrays.stream(split2).filter(str -> str.matches("\\w+")).forEach(str -> log.info("--{}--", str));
	}

	@Test
	public void subString() {
		String alphabets = "abcdefghijklmnopqrstuvwxyz";

		/*
		 *  5th character to end of String
		 *  
		 *  output: sub-string=fghijklmnopqrstuvwxyz
		 */
		String subString1 = alphabets.substring(5);
		log.info("sub-string1={}", subString1);

		/*
		 * 5th character to 9th (10-1) character
		 * 
		 * output: sub-string2=fghij		
		 */
		String subString2 = alphabets.substring(5, 10);
		log.info("sub-string2={}", subString2);
	}

	@Test
	public void stringToEBCDIC() {
		Charset charsetEBCDIC = Charset.forName("CP037");
		final String word = "Welcome to File IO &$@  �                     ";
		byte[] bytes = word.getBytes(charsetEBCDIC);
		log.info(Arrays.toString(bytes));
	}

	@Test
	public void stringToBytes() {
		final String word = "Hello File IO &$@  �                     ";
		byte[] bytes = word.getBytes();

		log.info("word-length={}, bytes-length={}", word.length(), bytes.length);
		for (int i = 0; i < word.length(); i++) {
			byte b = (byte) word.charAt(i);
			log.info("i={}, ch={}, b={}, ch={}", i, word.charAt(i), b, (char) b);
		}
	}

	/**
	 * input=<html><head></head><body><b>Welcome to Java</b></body></head></html>
	 * result=Welcome to Java
	 */
	@Test
	public void removeHTMLFromString() {
		String input = "<html><head></head><body><b>Welcome to Java</b></body></head></html>";
		log.info("input={}", input);
		String result = input.replaceAll("\\<.*?\\>", "");
		log.info("result={}", result);
	}
}
