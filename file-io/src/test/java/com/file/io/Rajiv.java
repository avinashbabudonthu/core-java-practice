package com.file.io;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rajiv {

	@Data
	@AllArgsConstructor
	private class LineNumberBytes {
		private long lineNumber;
		private Map<String, Byte> charToByteMap;
		private String line;
		private String word;

		@Override
		public String toString() {
			StringBuilder toString = new StringBuilder();
			return toString.append("\n").append(lineNumber).append("\n").append(line).append("\n").append(word)
					.append("\n").append(charToByteMap).append("\n").toString();
		}
	}

	@SneakyThrows
	@Test
	public void generateBytesForChars() {
		final URL url = ReadFile.class.getClassLoader().getResource("input-file.dat");
		final String filePath = url.getPath();
		final int location = 10;
		final File file = new File(filePath);

		try (FileReader reader = new FileReader(file);
				LineNumberReader lineNumberReader = new LineNumberReader(reader)) {
			List<LineNumberBytes> lineNumberBytesList = lineNumberReader.lines().map(line -> {

				String[] words = line.split("\\^\\|\\^");
				String word = (location < words.length) ? words[location - 1] : "";
				Map<String, Byte> charToByteMap = new LinkedHashMap<>();
				for (int i = 0; i < word.length(); i++) {
					Byte b = (byte) word.charAt(i);
					charToByteMap.put(String.valueOf(word.charAt(i)).trim().length() == 0 ? "EMPTY_STRING"
							: String.valueOf(word.charAt(i)), b);
				}
				return new LineNumberBytes(lineNumberReader.getLineNumber(), charToByteMap, line, word);
			}).collect(Collectors.toList());

			log.info("lineNumberBytesList={}", lineNumberBytesList);
		}
	}

	@Test
	public void stringToBytes() {
		final String word = "WHAT THE &$@  �                     ";
		byte[] bytes = word.getBytes();

		log.info("word-length={}, bytes-length={}", word.length(), bytes.length);
		for (int i = 0; i < word.length(); i++) {
			byte b = (byte) word.charAt(i);
			log.info("i={}, ch={}, b={}, ch={}", i, word.charAt(i), b, (char) b);
		}

	}

}
