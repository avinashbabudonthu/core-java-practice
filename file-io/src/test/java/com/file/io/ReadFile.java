package com.file.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

public class ReadFile {

	@Test
	public void readFileUsingBufferedReaderAndRelativePath() throws IOException {
		try (BufferedReader bufferedReader = Files
				.newBufferedReader(Paths.get("src/main/resources/file1.txt").toAbsolutePath())) {

			Stream<String> lines = bufferedReader.lines();
			lines.forEach(System.out::println);
		}
	}

	@Test
	public void readFileUsingFileSystemsAndRelativePath() throws IOException {
		try (BufferedReader bufferedReader = Files
				.newBufferedReader(FileSystems.getDefault().getPath("src/main/resources/file1.txt"))) {
			Stream<String> lines = bufferedReader.lines();
			lines.forEach(System.out::println);
		}
	}

	@Test
	public void readFileUsingFilesAndRelativePath() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/file3.txt"));
		allLines.stream().forEach(System.out::println);
	}

	@Test
	public void paths() {
		// read 1 file
		Path path = Paths.get("file1.txt");
		System.out.println(path.toString());
		System.out.println(path.toAbsolutePath().toString());

		System.out.println("-- reading multiple files ---");
		Path paths = Paths.get("file1.txt", "file2.txt");
		System.out.println(paths.toString());
		System.out.println(paths.toAbsolutePath().toString());
	}

}
