package com.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HashMapPractice {

    @Test
    public void createHashMap(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");

        log.info("map={}", map);
    }

    @Test
    public void iterateWithForEach(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");

        for(Map.Entry<String, String> entry : map.entrySet()){
            log.info("key={}, value={}", entry.getKey(), entry.getValue());
        }
    }

}
