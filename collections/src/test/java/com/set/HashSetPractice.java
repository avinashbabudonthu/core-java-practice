package com.set;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

@Slf4j
public class HashSetPractice {

    @Test
    public void create(){
        Set<String> set = new HashSet<>();
        log.info("set={}", set);
    }

    @Test
    public void add(){
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("2"); // this value will be ignored because set does not allow duplicates
        log.info("set={}", set);
    }

    @Test
    public void addAll(){
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        log.info("set1={}", set1);

        Set<String> set2 = new HashSet<>();
        set2.add("e");
        set2.add("f");
        set2.add("g");
        set2.add("h");
        log.info("set2={}", set2);

        set1.addAll(set2);
        log.info("after addAll - set1={}", set1);
    }

    @Test
    public void remove(){
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        log.info("set1={}", set1);

        set1.remove("c");
        log.info("after remove set1={}", set1);

        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(1);
        integerSet.add(2);
        integerSet.add(3);
        integerSet.add(4);
        log.info("integerSet={}", integerSet);

        integerSet.remove(3);
        log.info("after remove integerSet={}", integerSet);
    }

    @Test
    public void iterate(){
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        set1.add("e");
        set1.add("f");
        set1.add("a");

        log.info("{}", "iterate using for each loop");
        for(String str : set1){
            log.info("{}", str);
        }

        log.info("{}", "iterate using jdk8 collection streams");
        // set1.stream().forEach(value -> System.out.println(value)); // lambda
        set1.stream().forEach(System.out::println); // method reference
    }

}
