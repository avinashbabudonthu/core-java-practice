package com.reflection;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReflectionPractice {

	@Test
	public void className() {
		Class<Employee> employeeClass = Employee.class;
		log.info("employeeClass={}", employeeClass.getSimpleName());

		Class<Person> personClass = Person.class;
		log.info("personClass={}", personClass.getSimpleName());
	}
}