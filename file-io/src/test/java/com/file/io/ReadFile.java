package com.file.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class ReadFile {

	@Test
	public void readFromFile() throws IOException {
		try (BufferedReader bufferedReader = Files
				.newBufferedReader(Paths.get("src/main/resources/file1.txt").toAbsolutePath())) {
			System.out.println(bufferedReader.readLine());
		}

		System.out.println("--- using FileSystems ---");
		try (BufferedReader bufferedReader = Files
				.newBufferedReader(FileSystems.getDefault().getPath("src/main/resources/file1.txt"))) {
			System.out.println(bufferedReader.readLine());
		}

		System.out.println("-- Read all lines using Files --");
		List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/file3.txt"));
		allLines.stream().forEach(System.out::println);
	}
}
