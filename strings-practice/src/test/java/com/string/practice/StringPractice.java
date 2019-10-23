package com.string.practice;

import java.util.Arrays;
import java.util.Objects;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringPractice {

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
}
