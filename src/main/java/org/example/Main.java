package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class Main {
    public static void main(String[] args) {
        GenericApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(Book.class, "The Hunger Games");
        context.refresh();
        System.out.println("The book's title is " + context.getBean(Book.class).getTitle());
    }
}
