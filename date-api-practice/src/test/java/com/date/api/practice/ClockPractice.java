package com.date.api.practice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.Clock;

@Slf4j
public class ClockPractice {

    @Test
    public void createClock(){
        Clock clock = Clock.systemUTC();
        log.info("instant={}, millis={}", clock.instant(), clock.millis());

        Clock clock2 = Clock.systemDefaultZone();
        log.info("instant={}, millis={}", clock2.instant(), clock2.millis());
    }
}
