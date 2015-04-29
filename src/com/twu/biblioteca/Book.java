package com.twu.biblioteca;
import java.util.ArrayList;

public class Book extends Item {
    private String author;

    public Book(String name, String author, int year) {
        super(name, year);
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }
}
