package com.twu.biblioteca;
import java.util.ArrayList;

public class Session {
    private String user;
    private ArrayList<Book> sessionBooks;

    public Session(String user) {
        this.user = user;
        this.sessionBooks = new ArrayList<Book>();
    }

    public ArrayList<Book> getSessionBooks() {
        return this.sessionBooks;
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

    public String checkout(String book) {
        int index = this.getIndexByName(book);
        if(index != -1) {
            this.sessionBooks.remove(this.getIndexByName(book));
            return this.successfulCheckoutMessage();
        }else
            return this.unsuccessfulCheckoutMessage();
    }

    private int getIndexByName(String name) {
        for(Book book: sessionBooks) {
            if(book.getName().equals(name)) {
                return sessionBooks.indexOf(book);
            }
        }
        return -1;
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