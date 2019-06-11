package com.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Slf4j
public class ListSteamsPractice {

    @Test
    public void min(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Optional<Integer> minNumber = list.stream().min(Integer::compareTo);
        log.info("minNumber={}", minNumber);
    }

    @Test
    public void forEach(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        list.stream().forEach(value -> log.info("value={}",value));
    }

    /**
     * 1. Order is not maintained on using parallelStream
     */
    @Test
    public void forEachUsingParallelStream(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        list.parallelStream().forEach(value -> log.info("value={}", value));
    }

    @Test
    public void filter(){
    }

    @Test
    public void filterAndMin(){

    }

    @Test
    public void filterAndMax(){

    }

    @Test
    public void filterAndSum(){

    }

    @Test
    public void filterAndCount(){

    }

    @Test
    public void averageOfInt(){

    }

    @Test
    public void averageOfDouble(){

    }

    @Test
    public void max(){

    }

    @Test
    public void sum(){

    }

    @Test
    public void count(){

    }

    @Test
    public void reduce(){

    }

    @Test
    public void collect(){

    }

    @Test
    public void groupByUsingParallelStream(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(Employee.builder().name("jim").gender("M").build());
        employeeList.add(Employee.builder().name("jane").gender("F").build());
        employeeList.add(Employee.builder().name("john").gender("M").build());
        employeeList.add(Employee.builder().name("Ani").gender("F").build());

        ConcurrentMap<String, List<Employee>> groupByGender = employeeList.parallelStream()
                .collect(Collectors.groupingByConcurrent(Employee::getGender));
        log.info("groupByGender={}", groupByGender);
    }

}
