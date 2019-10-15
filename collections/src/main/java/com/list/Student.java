package com.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Student implements Comparable<Student> {

	private String name;
	private Double grade;

	// sorted order of grade
	@Override
	public int compareTo(Student that) {
		return this.grade.compareTo(that.getGrade());
	}
}
