package com.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import com.collection.streams.Student;

public class StreamsPractice {

	@Test
	public void findFirstAndFilter() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 7);

		Optional<Integer> integerOptional = list.stream().filter(i -> i == 6).findFirst();
		System.out.println(integerOptional);

		list.stream().filter(i -> i == 6).findFirst().get();
	}

	@Test
	public void test() {
		Student student1 = Student.builder().name("jack").course("java").build();
		Student student2 = Student.builder().name("jack").course("python").build();

		List<Student> studentList = new ArrayList<>();
		studentList.add(student1);
		studentList.add(student2);

		boolean result = studentList.stream().filter(student -> "jack".equalsIgnoreCase(student.getName()))
				//.map(student -> "java".equalsIgnoreCase(student.getCourse()))
				.anyMatch(student -> "java".equalsIgnoreCase(student.getCourse()));
		System.out.println(result);
	}
}
