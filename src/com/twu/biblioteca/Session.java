package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.deploy.util.StringUtils;

public class Session {
    private String user;
    public ArrayList<Book> sessionBooks;

    public Session(String user) {
        this.user = user;
        this.sessionBooks = new ArrayList<Book>();
    }

    public String welcomeMessage() {
        return "Welcome, " + user + "! The Library is available.";
    }

    public void addBook(Book book) {
        this.sessionBooks.add(book);
    }

    public ArrayList<String> listAllBooks() {
        ArrayList<String> listOfBooks = new ArrayList<String>();
        for(Book book: sessionBooks) {
            listOfBooks.add(book.name);
        }
        return listOfBooks;
    }
}