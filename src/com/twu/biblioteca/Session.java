package com.twu.biblioteca;
import java.util.ArrayList;

public class Session {
    private String user;
    private ArrayList<Book> sessionBooks;
    private ArrayList<Book> borrowedBooks;

    public Session(String user) {
        this.user = user;
        this.sessionBooks = new ArrayList<Book>();
        this.borrowedBooks = new ArrayList<Book>();
    }

    public ArrayList<Book> getSessionBooks() {
        return this.sessionBooks;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public ArrayList<String> listAllBooks() {
        ArrayList<String> listOfBooks = new ArrayList<String>();
        for(Book book: this.sessionBooks) {
            listOfBooks.add(book.getName());
        }
        return listOfBooks;
    }

    public String welcomeMessage() {
        return "Welcome, " + user + "! The Library is available.";
    }

    public void addBook(Book book) {
        this.sessionBooks.add(book);
    }

    public String checkout(String bookName) {
        Book book = this.getBookByName(bookName);
        if(book != null) {
            this.borrowedBooks.add(book);
            this.sessionBooks.remove(book);
            return this.successfulCheckoutMessage();
        } else
            return this.unsuccessfulCheckoutMessage();
    }

    public String returnBook(String bookName) {
        Book book = this.getBorrowedBookByName(bookName);
        if(book != null) {
            this.sessionBooks.add(book);
            this.borrowedBooks.remove(book);
            return "Thank you for returning the book.";
        } else
            return "That is not a valid book to return.";
    }

    private Book getBookByName(String name) {
        for(Book book: sessionBooks) {
            if(book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    private Book getBorrowedBookByName(String name) {
        for(Book book: borrowedBooks) {
            if(book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    private String successfulCheckoutMessage() {
        System.out.println("Thank you! Enjoy the book.");
        return "Thank you! Enjoy the book.";
    }

    private String unsuccessfulCheckoutMessage() {
        System.out.println("The book is not available.");
        return "The book is not available.";
    }
}