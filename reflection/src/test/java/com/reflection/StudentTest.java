package com.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

@Slf4j
public class StudentTest {

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
     * Get fully packaged class name from class object
     */
    @Test
    public void getName() throws ClassNotFoundException{
        Class<? extends Object> klass = Class.forName("com.reflection.Student");
        log.info("klass name={}", klass.getName());
    }

    /**
     * Get only class name from class object
     * @throws ClassNotFoundException
     */
    @Test
    public void getSimpleName() throws  ClassNotFoundException{
        Class<? extends Object> klass = Class.forName("com.reflection.Student");
        log.info("klass name={}", klass.getSimpleName());
    }

    /**
     * Get public fields using classObject.getFields()
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void getPublicFields() throws ClassNotFoundException{
        Class<? extends Object> klass = Class.forName("com.reflection.Student");
        Field[] fields = klass.getFields();

        Arrays.stream(fields).forEach(field -> {
            log.info("field name={}", field.getName());
        });
    }

    /**
     * Get public and private fields using classObject.getDeclaredFields()
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void getAllFields() throws ClassNotFoundException{
        Class<? extends Object> klass = Class.forName("com.reflection.Student");
        Field[] fields = klass.getDeclaredFields();

        Arrays.stream(fields).forEach(field -> {
            log.info("field name={}", field.getName());
        });
    }

    /**
     * get one private field
     *
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     */
    @Test
    public void getOnePrivateField() throws ClassNotFoundException, NoSuchFieldException{
        Class<? extends Object> klass = Class.forName("com.reflection.Student");
        Field field = klass.getDeclaredField("courses");
        log.info("field name={}", field.getName());
    }

    /**
     * Create object if
     * 1. We know class name at compile time
     * 2. Class has zero argument constructor
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
