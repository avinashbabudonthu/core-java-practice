package com.list;

import lombok.*;

import java.util.Comparator;

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
