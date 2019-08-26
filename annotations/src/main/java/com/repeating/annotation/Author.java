package com.repeating.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

@Repeatable(Authors.class)
public @interface Author {

    String name() default "no author";
}
