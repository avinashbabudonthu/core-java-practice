package com.date.api.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;

@Slf4j
public class LocalDatePractice {

    @Test
    public void createLocalDateWithCurrentDate(){
        LocalDate localDate = LocalDate.now();
        log.info("local-date={}", localDate);
    }
}
