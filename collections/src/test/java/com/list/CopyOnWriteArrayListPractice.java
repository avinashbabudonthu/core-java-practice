package com.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Slf4j
public class CopyOnWriteArrayListPractice {

    @Test
    public void add(){
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        log.info("list={}", list);
    }
}
