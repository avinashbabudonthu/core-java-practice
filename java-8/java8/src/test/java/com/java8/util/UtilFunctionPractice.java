package com.java8.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
public class UtilFunctionPractice {

    @Test
    public void biFunction() {
        /* 1,2 values to generic - argument, 3rd value - return type */
        BiFunction<String, String, String> biFunction = (firstName, lastName) -> firstName.concat(" ").concat(lastName);
        log.info(biFunction.apply("jim", "jack"));
    }

    /**
     * This is lazy operation {@see concatAndConvertCase} do not execute until log.info is called
     */
    @Test
    public void highOrderFunctions() {
        // Function<String, String> function = (input) -> input.toUpperCase(); // same as below line
        Function<String, String> function = String::toUpperCase;
        Supplier<String> supplier = concatAndConvertCase("jim", "jack", function);
        log.info("output={}", supplier.get());
    }

    private Supplier<String> concatAndConvertCase(String firstName, String lastName, Function<String, String> function) {
        return () -> {
            String str1 = firstName;
            String str2 = lastName;

            if (null != function) {
                str1 = function.apply(str1);
                str2 = function.apply(str2);
            }
            return str1.concat(" ").concat(str2);
        };
    }
}