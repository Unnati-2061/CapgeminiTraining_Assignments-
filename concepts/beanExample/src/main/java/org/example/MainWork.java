package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainWork {
    public static void main(String args[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
        WordCounter count = context.getBean(WordCounter.class);

        System.out.println(count.wordCount());
    }
}
