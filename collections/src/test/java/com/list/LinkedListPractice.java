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

    @Test
    public void iterate(){
        List<String> list1 = new LinkedList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        // using for each
        log.info("-- using for each --");
        for(String element : list1){
            log.info("element={}", element);
        }

        log.info("-- using index --");
        for(int i=0;i<list1.size();i++){
            log.info("list[{}]={}", i, list1.get(i));
        }

        log.info("-- using stream --");
        list1.stream().forEach(element -> log.info("element={}", element));
    }
}
