package com.file.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReadFile {

	@SneakyThrows
	@Test
	public void readFileUsingBufferedReaderAndRelativePath() {
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
		// method 1
		List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/file1.txt"));
		allLines.stream().forEach(System.out::println);
	}

	@Test
	public void paths() {
		// read 1 file
		Path path = Paths.get("file1.txt");
		log.info("file-name={}, absolute-path={}", path.toString(), path.toAbsolutePath().toString());

		log.info("-- reading multiple files ---");
		Path paths = Paths.get("file1.txt", "file2.txt");
		paths.forEach(eachPath -> {
			log.info("file-name={}, absolute-path={}", eachPath.toString(), eachPath.toAbsolutePath().toString());
		});

	}

	@Test
	public void readFileByteByByteUsingFileInputStream() throws FileNotFoundException, IOException {
		// read each byte
		File file = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		try (InputStream insInputStream = new FileInputStream(file)) {
			int intValue = -1;
			StringBuffer fileContent = new StringBuffer();
			while ((intValue = insInputStream.read()) >= 0) {
				char charValue = (char) intValue;
				fileContent.append(charValue);
			}

			log.info("file-content={}", fileContent);
		}
	}

	@Test
	public void readFileByByteArrayUsingFileInputStream() throws FileNotFoundException, IOException {
		File file = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		try (InputStream insInputStream = new FileInputStream(file)) {
			int length;
			byte[] byteBuffer = new byte[20];
			StringBuffer fileContent = new StringBuffer();
			while ((length = insInputStream.read(byteBuffer)) >= 0) {
				for (int i = 0; i < length; i++) {
					char value = (char) byteBuffer[i];
					fileContent.append(value);
				}
			}

			log.info("file-content={}", fileContent);
		}
	}

	@Test
	public void readFileCharByCharUsingInputStreamReader() throws FileNotFoundException, IOException {
		File file = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		try (InputStream inputStream = new FileInputStream(file); Reader reader = new InputStreamReader(inputStream)) {
			int intValue;
			StringBuffer fileContent = new StringBuffer();
			while ((intValue = reader.read()) >= 0) {
				char value = (char) intValue;
				fileContent.append(value);
			}
			log.info("file-content={}", fileContent);
		}
	}

	@Test
	public void readFileByCharUsingInputStreamReader() throws FileNotFoundException, IOException {
		File file = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		try (InputStream inputStream = new FileInputStream(file); Reader reader = new InputStreamReader(inputStream)) {
			int length;
			char[] charBuffer = new char[10];
			StringBuffer fileContent = new StringBuffer();
			while ((length = reader.read(charBuffer)) >= 0) {
				for (int i = 0; i < length; i++) {
					fileContent.append(charBuffer[i]);
				}
			}
			log.info("file-content={}", fileContent);
		}
	}

	@Test
	public void copyFileUsingFileStreams() throws IOException {
		log.info("------- using FileStreams ----------");
		File srcFile2 = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		File destFile2 = new File(Paths.get("src/main/resources/file-" + System.currentTimeMillis() + ".txt")
				.toAbsolutePath().toString());
		try (FileInputStream input = new FileInputStream(srcFile2);
				FileOutputStream output = new FileOutputStream(destFile2)) {
			byte[] buf = new byte[1024];
			int bytesRead;

			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
		}
		log.info("------- files copied using FileStreams ----------");

	}

	@Test
	public void copyFileUsingFiles() throws IOException, FileNotFoundException {
		log.info("----- using java.nio.file.Files.copy() ---------");
		Path source = Paths.get("src/main/resources/file1.txt");
		Path out = Paths.get("src/main/resources/file-" + System.currentTimeMillis() + ".txt");
		log.info("\n source={}, \n out={}", source, out);
		Files.copy(source, out);
		log.info("------ file copied successfully using java.nio.file.Files ---------");

		log.info("------ using java.nio.channels.FileChannel.transferTo() --------");
		File sourceFile = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		File destinationFile = new File(Paths.get("src/main/resources/file-" + System.currentTimeMillis() + ".txt")
				.toAbsolutePath().toString());
		try (FileInputStream sourceFileInputStream = new FileInputStream(sourceFile);
				FileOutputStream destinationFileInputStream = new FileOutputStream(destinationFile);) {
			FileChannel sourceFileChannel = sourceFileInputStream.getChannel();
			FileChannel destinationFileChannel = destinationFileInputStream.getChannel();
			sourceFileChannel.transferTo(0, sourceFile.length(), destinationFileChannel);
		}
		log.info("------ files copied using java.nio.channels.FileChannel.transferTo() --------");
	}

	@Test
	public void copyFileUsingApacheCommons() throws IOException {
		log.info("-------- using apache commons ----------");
		File srcFile = new File(Paths.get("src/main/resources/file1.txt").toAbsolutePath().toString());
		File destFile = new File(Paths.get("src/main/resources/file-" + System.currentTimeMillis() + ".txt")
				.toAbsolutePath().toString());

		log.info("\n srcFile={}, \n destFile={}", srcFile, destFile);
		FileUtils.copyFile(srcFile, destFile);
		// use above or below
		//IOUtils.copy(new FileInputStream(srcFile), new FileOutputStream(destFile));
		log.info("----- file copied successfully using apache commons --------");
	}

	@Test
	public void deleteFile() {
		File file = new File(Paths.get("src/main/resources/file2.txt").toAbsolutePath().toString());
		if (file.delete()) {
			log.info("{} deleted", file.getName());
		} else {
			log.info("{} deletion failed", file.getName());
		}
	}

	/**
	 * Method to iterate list of files in directories and sub directories
	 */
	@Test
	public void listFilesAndDirectories() {
		File directory = new File("E:/Backup/JavaPrep/practiceProjects/images");
		listFilesAndDirectories(directory);
	}

	private void listFilesAndDirectories(File directory) {
		File[] listOfFiles = directory.listFiles();
		for (File file : listOfFiles) {
			if (file.isDirectory())
				listFilesAndDirectories(file);
			System.out.println(file.getPath() + "\\" + file.getName());
		}
	}

	/**
	 * Read file using relative path
	 */
	@Test
	public void readFileWithRelativePath() throws IOException {
		URL url = getClass().getClassLoader().getResource("file1.txt");

		File file = new File(url.getPath());
		System.out.println("readFileWithRelativePath() -> file.getAbsolutePath(): " + file.getAbsolutePath());

		System.out.println("-----------------method 1 - reading content--------------------------");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

		System.out.println("-----------------method 2 - reading content--------------------------");
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("file1.txt");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}
	}

	/**
	 * Read file with relative path from static method
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void readFileWithRelativePathFromStaticMethod() throws FileNotFoundException, IOException {

		URL url = ReadFile.class.getClassLoader().getResource("file1.txt");
		File file = new File(url.getPath());
		System.out.println(
				"readFileWithRelativePathFromStaticMethod() -> file.getAbsolutePath(): " + file.getAbsolutePath());

		System.out.println("-----------------method 1 - reading content--------------------------");
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

		System.out.println("-----------------method 2 - reading content--------------------------");
		try (InputStream inputStream = ReadFile.class.getClassLoader().getResourceAsStream("file1.txt");
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = "";
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
			}
		}

	}

	@Test
	public void lineNumberReader() throws IOException {
		URL url = getClass().getClassLoader().getResource("file1.txt");
		File file = new File(url.getPath());

		Reader reader = new FileReader(file);
		try (LineNumberReader lineNumberReader = new LineNumberReader(reader)) {

			String line;
			while (null != (line = lineNumberReader.readLine()))
				System.out.println(lineNumberReader.getLineNumber() + ": " + line);
		}
	}

}