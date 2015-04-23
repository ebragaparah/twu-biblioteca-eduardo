package com.twu.biblioteca;
import java.util.ArrayList;

public class Session {
    private String user;
    private ArrayList<Book> sessionBooks;

    public Session(String user) {
        this.user = user;
        this.sessionBooks = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks() {
        return this.sessionBooks;
    }

    public String welcomeMessage() {
        return "Welcome, " + user + "! The Library is available.";
    }

    public void addBook(Book book) {
        this.sessionBooks.add(book);
    }
}