package com.repeating.annotation;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;

@Slf4j
public class BookTest {

    public static void main(String[] args) {
        Class<Book> bookClass = Book.class;
        Author annotations = bookClass.getAnnotation(Author.class);
        log.info("{}", annotations);
    }
}
