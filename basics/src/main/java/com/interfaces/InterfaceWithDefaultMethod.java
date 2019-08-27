package com.interfaces;

public interface InterfaceWithDefaultMethod {

    default String method1(){
        return "hello default method1()";
    }
}
