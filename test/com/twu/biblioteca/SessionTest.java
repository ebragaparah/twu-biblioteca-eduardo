package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SessionTest {
    private Session app;

    @Before
    public void setUp() {
        app = new Session("Eduardo");
        Book book1 = new Book("Book1", "John Doe", 1995);
        Book book2 = new Book("Book2", "John Doe", 1998);
        Book book3 = new Book("Book3", "John Doe", 2004);
        app.addBook(book1);
        app.addBook(book2);
        app.addBook(book3);
    }

    @Test
    public void shouldShowWelcomeMessage() throws Exception {
        String welcomeMessage = app.welcomeMessage();
        assertThat(welcomeMessage, is("Welcome, Eduardo! The Library is available."));
    }

    @Test
    public void shouldCheckoutABook() throws Exception {
        ArrayList<Book> booksInThisSession = app.getSessionBooks();
        assertThat(booksInThisSession.size(), is(3));
        assertThat(app.listAllBooks(), contains("Book1", "Book2", "Book3"));
        app.checkout("Book2");
        assertThat(app.listAllBooks(), contains("Book1", "Book3"));
        assertThat(booksInThisSession.size(), is(2));
    }

    @Test
    public void shouldDisplaySuccessfulCheckoutMessage() throws Exception {
        assertThat(app.checkout("Book1"), is("Thank you! Enjoy the book."));
    }

    @Test
    public void shouldDisplayUnsuccessfulCheckoutMessage() throws Exception {
        assertThat(app.checkout("Book4"), is("The book is not available."));
    }
}