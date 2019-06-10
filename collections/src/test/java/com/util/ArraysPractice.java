package com.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 *
 */
@Slf4j
public class ArraysPractice {

    /**
     * 1. list does not support operations like add, remove, set
     *  because unlike normal list the size of this list is fixed and size equal to the
     *  number of elements of array
     * 2. If we perform any add, remove etc operation on this list then
     *  java.lang.UpsupportedOperationException will be thrown
     */
    @Test
    public void convertArrayToList(){
        String[] namesArray = {"jack", "jim", "john"};
        log.info("namesArray={}",namesArray);
        List<String> namesList = Arrays.asList(namesArray);
        log.info("namesList={}",namesList);
    }
}
