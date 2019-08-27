package com.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    public String name;
    private String[] courses;
    public Date joiningDate;
    private Double grade;
}
