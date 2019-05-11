package com.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class LinkedListPractice {

    @Test
    public void add(){
        List<String> list1 = new LinkedList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        log.info("list1={}", list1);
    }
}
