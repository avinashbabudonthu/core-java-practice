package com.interfaces;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class InterfacesPractice {

    @Test
    public void callDefaultMethodOfInterface(){
        InterfaceWithDefaultMethodImpl interfaceWithDefaultMethod = new InterfaceWithDefaultMethodImpl();
        log.info("method1 result={}", interfaceWithDefaultMethod.callMethod1());
    }
}
