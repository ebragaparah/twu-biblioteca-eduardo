package com.twu.biblioteca;

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
}
