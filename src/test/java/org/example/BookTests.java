package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookTests {

    @Test
    @DisplayName("Checks that Book is added to the context")
    public void checkBookAddedToContext() {
        GenericApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBean(Book.class, "The Hunger Games");
        context.refresh();

        Book book = context.getBean(Book.class);

        assertEquals(new Book("The Hunger Games"), book);
    }
}
