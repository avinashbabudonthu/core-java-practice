package com.file.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
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
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateFile {

	private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Test
	public void writeToFile() {
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("src/main/resources/file4.txt"));
				Formatter formatter = new Formatter(bufferedWriter)) {
			formatter.format("core java %s", "file io");
			bufferedWriter.newLine();
			formatter.format("core java %s %s", "file io", "practice");
		} catch (Exception e) {
			LOGGER.error("Error while creating file={}", "src/main/resources/file4.txt");
		}
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
	public void writeToFileInZip1() throws URISyntaxException {
		Map<String, String> properties = new HashMap<>();
		properties.put("create", "true");
		URI zipUri = new URI("jar:file", Paths.get("src/main/resources/files2.zip").toUri().getPath(), null);
		String[] data = new String[] { "abc", "def", "ghi", "jkl" };
		try (FileSystem zipFileSystem = FileSystems.newFileSystem(zipUri, properties);
				BufferedWriter bufferedWriter = Files.newBufferedWriter(zipFileSystem.getPath("/file1-copy.txt"))) {
			for (String d : data) {
				bufferedWriter.write(d);
				bufferedWriter.newLine();
			}

			System.out.println("-- using Files --");
			Files.write(zipFileSystem.getPath("file2-copy.txt"), Arrays.asList(data), Charset.defaultCharset(),
					StandardOpenOption.CREATE);
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
}
