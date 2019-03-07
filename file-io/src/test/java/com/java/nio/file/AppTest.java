package com.java.nio.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class AppTest {

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

	@Test
	public void readFileContent() throws IOException {
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

	@Test
	public void createZipFile() throws IOException, URISyntaxException {
		Map<String, String> properties = new HashMap<>();
		properties.put("create", "true");
		URI zipURI = new URI("jar:file", Paths.get("src/main/resources/empty.zip").toUri().getPath(), null);
		try (FileSystem zipFileSystem = FileSystems.newFileSystem(zipURI, properties)) {
			System.out.println("zip file created");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void copyToZip() throws URISyntaxException {
		Map<String, String> properties = new HashMap<>();
		properties.put("create", "true");
		URI zipUri = new URI("jar:file", Paths.get("src/main/resources/files.zip").toUri().getPath(), null);
		try (FileSystem zipFileSystem = FileSystems.newFileSystem(zipUri, properties)) {
			Path file1 = Paths.get("src/main/resources/file1.txt");
			Path destinationFile = zipFileSystem.getPath("/file1-copy.txt");
			Files.copy(file1, destinationFile, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void writeToFileInZip1() throws URISyntaxException {
		Map<String, String> properties = new HashMap<>();
		properties.put("create", "true");
		URI zipUri = new URI("jar:file", Paths.get("src/main/resources/files2.zip").toUri().getPath(), null);
		String[] data = new String[] { "abc", "def", "ghi", "jkl" };
		try (FileSystem zipFileSystem = FileSystems.newFileSystem(zipUri, properties);
				BufferedWriter bufferedWriter = Files
						.newBufferedWriter(zipFileSystem.getPath("/file1-copy.txt"))) {
			for (String d : data) {
				bufferedWriter.write(d);
				bufferedWriter.newLine();
			}

			System.out.println("-- using Files --");
			Files.write(zipFileSystem.getPath("file2-copy.txt"), Arrays.asList(data),
					Charset.defaultCharset(), StandardOpenOption.CREATE);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}