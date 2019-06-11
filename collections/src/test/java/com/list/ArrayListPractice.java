package com.list;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
public class ArrayListPractice {

    @Test
    public void add(){
        log.info("---- method 1 ---");
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        log.info("list1={}", list1);

        log.info("---  method 2 ---");
        List<String> list2 = Arrays.asList("4","5","6");
        log.info("list={}", list2);
    }

    @Test
    public void addAll(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        log.info("before list1={}", list1);

        List<String> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("4");
        log.info("before list2={}", list2);

        list1.addAll(list2);
        log.info("after list1={}", list1);
    }

    @Test
    public void remove(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        log.info("original - list1={}", list1);

        list1.remove("1");
        log.info("remove element 1 - list1={}", list1);

        list1.remove(2);
        log.info("remove element by index - list1={}", list1);
    }

    @Test
    public void removeAll(){
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        log.info("list1 before={}", list1);

        List<String> list2 = new ArrayList<>();
        list2.add("c");
        log.info("list2={}", list2);

        list1.removeAll(list2);
        log.info("list1 after={}", list1);
    }

    @Test
    public void subList(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");
        log.info("before list1={}", list1);

        List<String> subList = list1.subList(1, 3);
        log.info("sublist(1, 3)={}", subList);

        // adding element to subList will reflect in actual list
        log.info("-- add element 6 to sublist --");
        subList.add("6");
        log.info("subList={}", subList);
        log.info("list1={}", list1);

        // deleting element from subList will reflect in actual list
        log.info("-- remove element 3 from sublist --");
        subList.remove("3");
        log.info("subList={}", subList);
        log.info("list1={}", list1);
    }

    @Test
    public void iterate(){
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");
        list1.add("5");

        // using iterator
        log.info("-- iterate using iterator --");
        Iterator<String> list1Iterator = list1.iterator();
        while(list1Iterator.hasNext()){
            log.info("iterator.element={}", list1Iterator.next());
        }

        // using for loop
        log.info("-- iterate using for loop --");
        for(int i=0;i<list1.size();i++){
            log.info("list1[{}]={}", i, list1.get(i));
        }

        // for each
        log.info("-- iterate using for each loop --");
        for(String element : list1){
            log.info("element={}", element);
        }

        // stream
        log.info("-- iterate using stream --");
        list1.stream().forEach(element -> log.info("element={}", element));
    }

    @Test
    public void toArray() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        // to object array
        log.info("-- to Object array : Object[] --");
        Object[] objectArray = list1.toArray();
        Stream.of(objectArray).forEach(element -> log.info("element={}", element));

        // to String array
        log.info("-- to String array, passing array size: String[] --");
        String[] stringArray = list1.toArray(new String[list1.size()]);
        Stream.of(stringArray).forEach(element -> log.info("element={}", element));

        log.info("-- to String array without passing array size : String[] ");
        String[] stringArray2 = list1.toArray(new String[]{});
        Stream.of(stringArray2).forEach(element -> log.info("element={}", element));
    }
}
