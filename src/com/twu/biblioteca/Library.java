package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Session> sessions;
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Library() {
        this.sessions = new ArrayList<Session>();
        this.books = new ArrayList<Book>();
        this.movies = new ArrayList<Movie>();
    }

    public ArrayList<Book> getBooks() { return books; }
    public ArrayList<Movie> getMovies() { return movies; }

    public void setSessions(Session session) {
        this.sessions.add(session);
    }

    public void addItem(Item item) {
        if(item instanceof Book) {
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

    public ArrayList<String> listAllBooks() {
        ArrayList<String> listOfBooks = new ArrayList<String>();
        for(Book book: books) {
            listOfBooks.add(book.getName());
            System.out.println(book.getName());
        }
        return listOfBooks;
    }

    public ArrayList<String> listAllMovies() {
        ArrayList<String> listOfMovies = new ArrayList<String>();
        for(Movie movie: movies) {
            listOfMovies.add(movie.getName());
            System.out.println(movie.getName());
        }
        return listOfMovies;
    }

    public ArrayList<ArrayList<Object>> listDetailsOfAllBooks() {
        ArrayList<ArrayList<Object>> listOfBooksDetailed = new ArrayList<ArrayList<Object>>();
        System.out.print(" |        Name        |       Author      |       Year        |\n");
        System.out.print("  ------------------------------------------------------------\n");
        for(Book book: books) {
            listOfBooksDetailed.add(book.getDetails());
            for(Object detail: book.getDetails()){
                System.out.print("|        " + detail + "       ");
            }
            System.out.print("|\n");
        }
        return listOfBooksDetailed;
    }

    public ArrayList<ArrayList<Object>> listDetailsOfAllMovies() {
        ArrayList<ArrayList<Object>> listOfMoviesDetailed = new ArrayList<ArrayList<Object>>();
        System.out.print(" |        Name        |       Author      |       Year        |       Rate        |\n");
        System.out.print("  ---------------------------------------------------------------------------------\n");
        for(Movie movie: movies) {
            listOfMoviesDetailed.add(movie.getDetails());
            for(Object detail: movie.getDetails()){
                System.out.print("|        " + detail + "       ");
            }
            System.out.print("|\n");
        }
        return listOfMoviesDetailed;
    }

    public String checkout(String itemName, Session session) {
        Item item = this.getItemByName(itemName);
        if(item != null) {
            session.addItem(item);
            this.removeItem(item);
            return Message.successfulCheckoutMessage();
        } else {
            return Message.unsuccessfulCheckoutMessage();
        }
    }

    public String returnItem(String itemName, Session session) {
        return session.returnItem(itemName);
    }

    private Item getItemByName(String name) {
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
}