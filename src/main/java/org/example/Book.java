package org.example;

public class Book {
    private final String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return title == book.title || (title != null && title.equals(book.title));
    }

    public int hashCode() {
        return title == null ? 0 : title.hashCode();
    }
}
