package com.string.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringJoinerPractice {

	@Test
	public void commaSeparatedString() {
		StringJoiner str = new StringJoiner(",");
		str.add("jack").add("jim").add("jill");
		log.info("str={}", str); // str=jack,jim,jill

		StringJoiner str2 = new StringJoiner(",", "{", "}");
		str2.add("jack").add("jim").add("jill");
		log.info("str2={}", str2); // str2={jack,jim,jill}

		StringJoiner str3 = new StringJoiner("],[", "[", "]");
		str3.add("jack").add("jim").add("jill");
		log.info("str3={}", str3); // str3=[jack],[jim],[jill]

		StringJoiner str4 = new StringJoiner(",", "{", "}");
		str4.add("jack");
		log.info("str4={}", str4); // str4={jack}

		StringJoiner str5 = new StringJoiner(",", "{", "}");
		log.info("str5={}", str5); // str5={}

		StringJoiner str6 = new StringJoiner(",");
		str6.setEmptyValue("EMPTY");
		log.info("str6={}", str6); // str6=EMPTY

		StringJoiner str7 = new StringJoiner(",", "{", "}");
		str7.setEmptyValue("EMPTY");
		log.info("str7={}", str7); // str7=EMPTY
	}

	@Test
	public void stringJoin() {
		String str = String.join(",", "jack", "john", "jim", "jane");
		System.out.println("str:" + str); // str:jack,john,jim,jane
	}

	@Data
	@AllArgsConstructor
	private class Employee {
		private String firstName;
	}

	@Test
	public void listOfEmployeeToCommaSeparatedFirstName() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("jack"));
		employeeList.add(new Employee("john"));
		employeeList.add(new Employee("jim"));
		employeeList.add(new Employee("jane"));

		String str = employeeList.stream().map(x -> x.getFirstName())
				.collect(Collectors.joining(",", "prefix-", "-suffix"));
		System.out.println("str:" + str);
	}

	/**
	 * Output:
	 * 	stringJoiner1=jack,john,jim,jane
		stringJoiner2={aaro,ace,abhi,adele}
		mergedString1=jack,john,jim,jane,aaro,ace,abhi,adele
		mergedString2={aaro,ace,abhi,adele,jack,john,jim,jane,aaro,ace,abhi,adele}
	 */
	@Test
	public void merge() {
		StringJoiner stringJoiner1 = new StringJoiner(",");
		stringJoiner1.add("jack");
		stringJoiner1.add("john");
		stringJoiner1.add("jim");
		stringJoiner1.add("jane");

		StringJoiner stringJoiner2 = new StringJoiner(",", "{", "}");
		stringJoiner2.add("aaro");
		stringJoiner2.add("ace");
		stringJoiner2.add("abhi");
		stringJoiner2.add("adele");

		System.out.println("stringJoiner1=" + stringJoiner1);
		System.out.println("stringJoiner2=" + stringJoiner2);

		StringJoiner mergedString1 = stringJoiner1.merge(stringJoiner2);
		StringJoiner mergedString2 = stringJoiner2.merge(stringJoiner1);

		System.out.println("mergedString1=" + mergedString1);
		System.out.println("mergedString2=" + mergedString2);
	}

	/**
	 * Output:
	 * 	stringJoiner.length==18
	 */
	@Test
	public void length() {
		StringJoiner stringJoiner = new StringJoiner(",");
		stringJoiner.add("jack");
		stringJoiner.add("john");
		stringJoiner.add("jim");
		stringJoiner.add("jane");

		System.out.println("stringJoiner.length==" + stringJoiner.length());
	}

}