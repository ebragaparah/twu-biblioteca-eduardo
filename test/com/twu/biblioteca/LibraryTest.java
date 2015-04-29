package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryTest {
    private Library library;
    private Book book1, book2, book3;
    private  Movie movie1, movie2, movie3;

    @Before
    public void setUp() {
        library = new Library();
        book1 = new Book("Book1", "John Doe", 1995);
        book2 = new Book("Book2", "John Doe", 1998);
        book3 = new Book("Book3", "John Doe", 2004);
        movie1 = new Movie("Movie1", "Tarantino", 2015, 8);
        movie2 = new Movie("Movie2", "Tarantino", 2015, 5);
        movie3 = new Movie("Movie3", "Tarantino", 2015, 7);
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(movie1);
        library.addItem(movie2);
        library.addItem(movie3);
    }

    @Test
    public void listsAllBooksInTheLibrary() throws Exception {
        ArrayList<String> listOfBooks = library.listAllBooks();
        assertThat(listOfBooks, contains("Book1", "Book2", "Book3"));
    }

    @Test
    public void listsTheDetailsOfAllBooksInTheLibrary() throws Exception {
        ArrayList<Object> book1 = new ArrayList<Object>() {{ add("Book1"); add("John Doe"); add(1995); }};
        ArrayList<Object> book2 = new ArrayList<Object>() {{ add("Book2"); add("John Doe"); add(1998); }};
        ArrayList<Object> book3 = new ArrayList<Object>() {{ add("Book3"); add("John Doe"); add(2004); }};
        assertThat(library.listDetailsOfAllBooks(), contains(new Object[] {book1, book2, book3}));
    }

    @Test
    public void listsAllMoviesInTheLibrary() throws Exception {
        ArrayList<String> listOfMovies = library.listAllMovies();
        assertThat(listOfMovies, contains("Movie1", "Movie2", "Movie3"));
    }

    @Test
    public void listsTheDetailsOfAllMoviesInTheLibrary() throws Exception {
        ArrayList<Object> movie1 = new ArrayList<Object>() {{ add("Movie1"); add("Tarantino"); add(2015); add(8); }};
        ArrayList<Object> movie2 = new ArrayList<Object>() {{ add("Movie2"); add("Tarantino"); add(2015); add(5); }};
        ArrayList<Object> movie3 = new ArrayList<Object>() {{ add("Movie3"); add("Tarantino"); add(2015); add(7); }};
        assertThat(library.listDetailsOfAllMovies(), contains(new Object[] {movie1, movie2, movie3}));
    }
}