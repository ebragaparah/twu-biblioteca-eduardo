package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void registerBook(Book book) {
        this.books.add(book);
    }

    public ArrayList<String> listAllBooks() {
        ArrayList<String> listOfBooks = new ArrayList<String>();
        for(Book book: books) {
            listOfBooks.add(book.getName());
        }
        return listOfBooks;
    }

    public ArrayList<ArrayList<Object>> listAllBooksDetailed() {
        ArrayList<ArrayList<Object>> listOfBooksDetailed = new ArrayList<ArrayList<Object>>();
        for(Book book: books) {
            listOfBooksDetailed.add(book.getDetails());
        }
        return listOfBooksDetailed;
    }
}
