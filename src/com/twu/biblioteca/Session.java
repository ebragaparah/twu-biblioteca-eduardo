package com.twu.biblioteca;

import java.util.ArrayList;

public class Session {
    private Library library;
    private String user;
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Session(String user, Library library) {
        this.library = library;
        this.library.setSessions(this);
        this.user = user;
        this.books = new ArrayList<Book>();
        this.movies = new ArrayList<Movie>();
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    public ArrayList<Movie> getMovies() {
        return this.movies;
    }

    public void addItem(Item item) {
        if(item instanceof Book){
            this.books.add((Book) item);
        } else {
            this.movies.add((Movie) item);
        }
    }

    public void removeItem(Item item) {
        if(item instanceof Book) {
            this.books.remove((Book) item);
        } else {
            this.movies.remove((Movie) item);
        }
    }

    public String returnItem(String itemName) {
        Item item = this.getItemByName(itemName);
        if(item != null) {
            this.library.addItem(item);
            this.removeItem(item);
            return Message.successfulReturnMessage();
        } else {
            return Message.unsuccessfulReturnMessage();
        }
    }

    public Item getItemByName(String name) {
        for(Book book: books) {
            if(book.getName().equals(name))
                return book;
        }
        for(Movie movie: movies) {
            if(movie.getName().equals(name))
                return movie;
        }
        return null;
    }

    public ArrayList<String> listAllMovies() {
        ArrayList<String> listOfMovies = new ArrayList<String>();
        for(Movie movie: movies) {
            listOfMovies.add(movie.getName());
        }
        return listOfMovies;
    }

    public ArrayList<String> listAllBooks() {
        ArrayList<String> listOfBooks = new ArrayList<String>();
        for(Book book: books) {
            listOfBooks.add(book.getName());
        }
        return listOfBooks;
    }

    public String welcomeMessage() {
        return Message.welcomeMessage(this.user);
    }
}