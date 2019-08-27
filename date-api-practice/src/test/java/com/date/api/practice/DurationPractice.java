package com.date.api.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

@Slf4j
public class DurationPractice {

    @Test
    public void durationBetweenTwoDates(){
        LocalDateTime from = LocalDateTime.of(2018, Month.JULY, 20, 0, 0, 0);
        LocalDateTime to = LocalDateTime.of(2019, Month.JULY, 20, 23, 59, 59);

        final Duration duration = Duration.between(from, to);

        log.info("days={}, hours={}, minutes={}, milli-seconds={}, nano-seconds={}",
                duration.toDays(), duration.toHours(), duration.toMinutes(),
                duration.toMillis(), duration.toNanos());
    }
}
