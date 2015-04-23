package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Book {
    private String name, author;
    private int yearOfPublishment;

    public Book(String name, String author, int yearOfPublishment) {
        this.name = name;
        this.author = author;
        this.yearOfPublishment = yearOfPublishment;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYearOfPublishment() {
        return this.yearOfPublishment;
    }

    public ArrayList<Object> getDetails() {
        ArrayList<Object> bookDetails = new ArrayList<Object>();
        bookDetails.add(this.getName());
        bookDetails.add(this.getAuthor());
        bookDetails.add(this.getYearOfPublishment());
        return bookDetails;
    }
}
