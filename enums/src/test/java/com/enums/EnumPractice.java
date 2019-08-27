package com.enums;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class EnumPractice {

    /**
     * Access one enum value
     */
    @Test
    public void accessEnumValue(){
        Day monday = Day.MONDAY;
        log.info("monday={}", monday);
    }
}
