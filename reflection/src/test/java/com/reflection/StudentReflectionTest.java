package com.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class StudentReflectionTest {

    /**
     * If we know the class name at compile time
     */
    @Test
    public void classObject1(){
        Class<Student> studentClass = Student.class;
        log.info("studentClass={}", studentClass);
    }

    /**
     * If we know the full packaged class name at run time
     */
    @Test
    public void classObject2() throws Exception{
        Class<? extends Object> studentClass = Class.forName("com.reflection.Student");
        log.info("studentClass={}", studentClass);
    }

    /**
     * We know class name at compile time
     * Class has zero argument constructor
     *
     * @throws Exception
     */
    @Test
    public void createObjectUsingClassNewInstance() throws Exception {
        Class<Student> studentClass = Student.class;
        Student student = studentClass.newInstance();
        log.info("studentClass={}, student={}", studentClass, student);
    }

    /**
     * We know the full packaged class name at run time
     * Class has zero argument constructor
     */
    @Test
    public void createObjectKnowClassNameAtRuntimeWithZeroArgumentConstructor(){

    }
}
