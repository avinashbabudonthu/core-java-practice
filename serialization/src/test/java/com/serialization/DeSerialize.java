package com.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeSerialize {

	/**
	 * @see Serialize#saveEmployeeObject()
	 */
	@Test
	public void readEmployee() {
		try (ObjectInputStream objectInputStream = new ObjectInputStream(
				Files.newInputStream(Paths.get("src/main/resources/emp.dat")))) {
			Employee employee = (Employee) objectInputStream.readObject();
			log.info("employee={}", employee);
		} catch (IOException | ClassNotFoundException e) {
			log.error("exception", e);
		}
	}
}
