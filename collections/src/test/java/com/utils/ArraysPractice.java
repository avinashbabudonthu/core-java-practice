package com.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

@Slf4j
public class ArraysPractice {

    @Test
    public void convertArrayToList(){
        String[] stringArray = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(stringArray);
        log.info("list={}", list);
    }
}