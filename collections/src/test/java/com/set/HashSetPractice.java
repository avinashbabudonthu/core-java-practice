package com.set;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class HashSetPractice {

    @Test
    public void add(){
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("2");
        log.info("set={}", set);


    }
}
