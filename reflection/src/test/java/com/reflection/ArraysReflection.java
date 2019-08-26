package com.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Array;

@Slf4j
public class ArraysReflection {

    /**
     * Create int array of size 10
     */
    @Test
    public void intArray(){
        int[] intArray = (int[]) Array.newInstance(int.class, 10);
        log.info("intArray length={}", intArray.length);
    }
}
