package com.interfaces;

public class InterfaceWithDefaultMethodImpl implements InterfaceWithDefaultMethod {

    public String callMethod1(){
        return InterfaceWithDefaultMethod.super.method1();
    }
}
