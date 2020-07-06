package com.collection.streams;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {

	private String name;
	private String course;
}
