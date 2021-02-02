package com.file.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileIOPractice {

	/**
	 * Prepare java.io.File object using string path
	 */
	@Test
	public void stringToFileObject() {
		String filePath1 = "file1.txt";
		File file1 = new File(filePath1);
		System.out.println("file1: " + file1);

		String filePath2 = "E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt";
		File file2 = new File(filePath2);
		System.out.println("file2: " + file2);
	}

	/**
	 * convert file to java.io.InputStream
	 * @throws IOException
	 */
	@Test
	public void convertFileToInputstream() throws IOException {
		String filePath1 = "E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file1.txt";
		File file = new File(filePath1);
		InputStream inputStream1 = new FileInputStream(file);
		System.out.println("inputStream1: " + inputStream1 + ", number of bytes:" + inputStream1.available());
		inputStream1.close();

		InputStream inputStream2 = getClass().getClassLoader().getResourceAsStream("file1.txt");
		System.out.println("inputStream2: " + inputStream2 + ", number of bytes:" + inputStream2.available());
		inputStream2.close();

		// from java 7 
		try (InputStream inputStream3 = getClass().getClassLoader().getResourceAsStream("file1.txt")) {
			System.out.println("inputStream3: " + inputStream3 + ", number of bytes:" + inputStream3.available());
		}
	}

	/**
	 * Method to get current project directory
	 */
	@Test
	public void getCurrentProjectDirectory() {
		// method 1
		String projectDirectory1 = System.getProperty("user.dir");
		System.out.println("FileIOPractice -> getCurrentDirectory() -> projectDirectory1: " + projectDirectory1);

		// method 2
		String projectDirectory2 = Paths.get("").toAbsolutePath().toString();
		System.out.println("FileIOPractice -> getCurrentDirectory() -> projectDirectory2: " + projectDirectory2);

		// method 3
		String projectDirectory3 = Paths.get(".").toAbsolutePath().normalize().toString();
		System.out.println("FileIOPractice -> getCurrentDirectory() -> projectDirectory3: " + projectDirectory3);

		// method 4
		URL projectDirectory4 = getClass().getProtectionDomain().getCodeSource().getLocation();
		System.out.println("FileIOPractice -> getCurrentDirectory() -> projectDirectory4: " + projectDirectory4);

		// method 5
		String myCurrentDir = System.getProperty("user.dir") + File.separator + System.getProperty("sun.java.command")
				.substring(0, System.getProperty("sun.java.command").lastIndexOf(".")).replace(".", File.separator);
		System.out.println("FileIOPractice -> getCurrentDirectory() -> myCurrentDir: " + myCurrentDir);
	}

	/**
	 * method to get line separator based on underlying operating system instead of hard coding
	 */
	@Test
	public void lineSeparator() {
		String lineSeparator = System.getProperty("line.separator").toString();
		System.out.println("abc" + lineSeparator + "def");

		String lineSeparator2 = File.separator;
		System.out.println("lineSeperator2: " + lineSeparator2);
	}

	/**
	 * Create a directory
	 */
	@Test
	public void createDirectory() {
		boolean isTestFolderCreated = new File("E:\\Backup\\testFolder").mkdir();
		System.out.println("isTestFolderCreated: " + isTestFolderCreated);

		boolean isFolderStructureCreated = new File("E:\\Backup\\folder1\\folder2").mkdirs();
		System.out.println("isFolderStructureCreated: " + isFolderStructureCreated);

		// from JDK 7 - using java.nio.file package
		try {
			Path path = Paths.get("E:\\Backup\\folder3\\folder4");
			System.out.println("Files.exists(path) : " + Files.exists(path));
			Files.createDirectories(path);
			System.out.println("Files.exists(path) : " + Files.exists(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void convertPathToFile() {
		final Path path = new File(getClass().getClassLoader().getResource("file1.txt").getPath()).toPath();
		log.info("path={}", path);

		File file = path.toFile();
		log.info("file={}", file.getAbsolutePath());
	}

}