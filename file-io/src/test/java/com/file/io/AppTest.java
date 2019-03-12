package com.file.io;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
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