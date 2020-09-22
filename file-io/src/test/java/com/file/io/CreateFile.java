package com.file.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateFile {

	@Test
	public void writeToFile() throws IOException {
		try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("src/main/resources/file4.txt"));
				Formatter formatter = new Formatter(bufferedWriter)) {
			formatter.format("core java %s", "file io");
			bufferedWriter.newLine();
			formatter.format("core java %s %s", "file io", "practice");
		}

		File file2 = new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\new-file2.txt");
		boolean isFile2Created = file2.createNewFile();
		System.out.println("isFile2Created: " + isFile2Created);
		System.out.println("FileIOPractice -> createFile() -> writing file2 using OutputStream");
		String fileData = "New file created. Let's write some data";
		byte[] fileDataAsByteArray = fileData.getBytes(StandardCharsets.UTF_8);
		try (OutputStream outputStream = new FileOutputStream(file2);) {
			outputStream.write(fileDataAsByteArray, 0, fileDataAsByteArray.length);
		}
	}

	@Test
	public void createZipFile() throws IOException, URISyntaxException {
		Map<String, String> properties = new HashMap<>();
		properties.put("create", "true");
		URI zipURI = new URI("jar:file", Paths.get("src/main/resources/empty.zip").toUri().getPath(), null);
		try (FileSystem zipFileSystem = FileSystems.newFileSystem(zipURI, properties)) {
			log.info("zip file created");
		} catch (Exception e) {
			log.error("exception", e);
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

			log.info("-- using Files --");
			Files.write(zipFileSystem.getPath("file2-copy.txt"), Arrays.asList(data), Charset.defaultCharset(),
					StandardOpenOption.CREATE);
		} catch (Exception e) {
			log.error("exception", e);
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
			log.error("exception", e);
		}
	}

	/**
	 * Create Zip file with single file
	 */
	@Test
	public void createZipFileWithOneFile() {
		byte[] buffer = new byte[1024];

		// we are using try-with-resource, so closing of resources will be done automatically
		try (FileOutputStream fos = new FileOutputStream(
				"E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/resources/myZip.zip");
				ZipOutputStream zos = new ZipOutputStream(fos);
				InputStream is = getClass().getClassLoader().getResourceAsStream("file1.txt");) {

			System.out.println("fos: " + fos);
			System.out.println("zos: " + zos);
			System.out.println("is: " + is);

			ZipEntry zipEntry = new ZipEntry("file1.log");
			zos.putNextEntry(zipEntry);

			int length;
			while ((length = is.read(buffer)) > 0) {
				zos.write(buffer, 0, length);
			}

			zos.closeEntry();

			System.out.println("Zip file created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create zip file with files present in a folder
	 * @throws IOException 
	 */
	@Test
	public void createZipWithFilesInFolder() throws IOException {
		List<String> sourceFileNamesList = new ArrayList<>();
		String sourceFolder = "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/resources/folder1";
		String outputZipFile = "E:/Backup/JavaPrep/practiceProjects/CoreJavaPractice/src/main/resources/myZip2.zip";

		//get all files names in a source folder
		//if this directory contains sub-directories, iterate recursively to get all file names
		//refer listFilesAndDirectories(File directory) method in this class
		File sourceDirectory = new File(sourceFolder);
		String[] sourceFileNames = sourceDirectory.list();
		for (String sourceFileName : sourceFileNames) {
			int startIndex = Integer.parseInt(String.valueOf(sourceDirectory.length()));
			int endIndex = sourceFileName.length();
			sourceFileNamesList.add(sourceFileName.substring(startIndex, endIndex));
		}

		System.out.println("sourceFileNamesList: " + sourceFileNamesList);

		// create zip file
		byte[] buffer = new byte[1024];

		try (FileOutputStream fos = new FileOutputStream(outputZipFile);
				ZipOutputStream zos = new ZipOutputStream(fos);) {
			for (String file : sourceFileNamesList) {

				// to read file using class loader that file should be in class path else we need to complete path of file and create input stream
				try (InputStream is = getClass().getClassLoader().getResourceAsStream(file);) {
					ZipEntry zipEntry = new ZipEntry(file);
					zos.putNextEntry(zipEntry);

					int length;
					while ((length = is.read(buffer)) > 0) {
						zos.write(buffer, 0, length);
					}

					System.out.println("File Added: " + file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Zip file created");
	}

	/**
	 * java.io.OutputStream.write() method
	 * @throws IOException
	 */
	@Test
	public void writeMethod() throws IOException {
		try (OutputStream os = new FileOutputStream(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file3.txt"))) {
			byte data = 100;
			os.write(data);
		}
		System.out.println("---- file file3.txt created. check the path. ---------");

		// java.io.Writer.write() method
		try (Writer writer = new FileWriter(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file4.txt"))) {
			char data = 'A';
			writer.write(data);
		}
		System.out.println("---- file file4.txt created. check the path. ---------");

		// java.io.Writer.write(char[] data) method
		try (Writer writer = new FileWriter(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file5.txt"))) {
			char[] data = { 'A', 'B', 'C', 'D' };
			writer.write(data);
		}
		System.out.println("---- file file5.txt created. check the path. ---------");

		// java.io.Writer.write(String data) method
		try (Writer writer = new FileWriter(new File(
				"E:\\Backup\\JavaPrep\\practiceProjects\\CoreJavaPractice\\src\\main\\resources\\file6.txt"))) {
			String data = "jack";
			writer.write(data);
		}
		System.out.println("---- file file6.txt created. check the path. ---------");
	}
}