package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SessionTest {
    private Library library;
    private Session app;
    private Book book1, book2, book3;
    private Movie movie1, movie2, movie3;

    @Before
    public void setUp() {
        library = new Library();
        app = new Session("Eduardo", library);
        book1 = new Book("Book1", "John Doe", 1995);
        book2 = new Book("Book2", "John Doe", 1998);
        book3 = new Book("Book3", "John Doe", 2004);
        movie1 = new Movie("Movie1", "Tarantino", 2015, 8);
        movie2 = new Movie("Movie2", "Tarantino", 2015, 8);
        movie3 = new Movie("Movie3", "Tarantino", 2015, 8);
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(book3);
        library.addItem(movie1);
        library.addItem(movie2);
        library.addItem(movie3);
    }

    @Test
    public void shouldShowWelcomeMessage() throws Exception {
        String welcomeMessage = app.welcomeMessage();
        assertThat(welcomeMessage, is("Welcome, Eduardo! The Library is available."));
    }

    @Test
    public void checkoutsABook() throws Exception {
        ArrayList<Book> booksInLibrary = library.getBooks();
        assertThat(booksInLibrary.size(), is(3));
        assertThat(library.getBooks(), contains(book1, book2, book3));
        assertThat(library.listAllBooks(), contains("Book1", "Book2", "Book3"));
        assertThat(app.getBooks().size(), is(0));
        library.checkout("Book2", app);
        assertThat(app.getBooks().size(), is(1));
        assertThat(app.getBooks(), contains(book2));
        assertThat(library.getBooks(), contains(book1, book3));
        assertThat(library.listAllBooks(), contains("Book1", "Book3"));
        assertThat(booksInLibrary.size(), is(2));
    }

    @Test
    public void checkoutsAMovie() throws Exception {
        ArrayList<Movie> moviesInLibrary = library.getMovies();
        ArrayList<Movie> moviesInSession = app.getMovies();
        assertThat(moviesInLibrary.size(), is(3));
        assertThat(library.listAllMovies(), contains("Movie1", "Movie2", "Movie3"));
        library.checkout("Movie1", app);
        assertThat(moviesInSession.size(), is(1));
        assertThat(app.listAllMovies(), contains("Movie1"));
        assertThat(moviesInLibrary.size(), is(2));
        assertThat(library.listAllMovies(), contains("Movie2", "Movie3"));
    }

    @Test
    public void returnsABook() throws Exception {
        ArrayList<Book> booksInLibrary = library.getBooks();
        ArrayList<Book> booksInSession = app.getBooks();
        library.checkout("Book1", app);
        assertThat(booksInLibrary.size(), is(2));
        assertThat(booksInLibrary, contains(book2, book3));
        assertThat(booksInSession.size(), is(1));
        assertThat(booksInSession, contains(book1));
        library.returnItem("Book1", app);
        assertThat(booksInLibrary.size(), is(3));
        assertThat(booksInLibrary, containsInAnyOrder(book1, book2, book3));
        assertThat(booksInSession.size(), is(0));
    }

    @Test
    public void displaysSuccessfulCheckoutMessage() throws Exception {
        assertThat(library.checkout("Book1", app), is("Thank you! Enjoy the book."));
    }

    @Test
    public void displaysUnsuccessfulCheckoutMessage() throws Exception {
        assertThat(library.checkout("Book4", app), is("The book is not available."));
    }

    @Test
    public void failsTheReturnOfBookThatWasntBorrowed() throws Exception {
        assertThat(library.returnItem("Book5", app), is("That is not a valid book to return."));
    }
}