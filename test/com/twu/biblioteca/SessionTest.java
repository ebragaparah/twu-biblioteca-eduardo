package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SessionTest {
    private Session app;
    private Book book1, book2, book3;

    @Before
    public void setUp() {
        app = new Session("Eduardo");
        book1 = new Book("Book1", "John Doe", 1995);
        book2 = new Book("Book2", "John Doe", 1998);
        book3 = new Book("Book3", "John Doe", 2004);
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
    public void shouldAddCheckedOutBookToBorrowedBooksList() throws Exception {
        app.checkout("Book1");
        assertThat(app.getBorrowedBooks().size(), is(1));
        assertThat(app.getBorrowedBooks(), contains(book1));
    }

    @Test
    public void shouldReturnABookToBookSessionList() throws Exception {
        app.returnBook("Book1");
        assertThat(app.getSessionBooks().size(), is(3));
        assertThat(app.getSessionBooks(), contains(book1, book2, book3));
    }

    @Test
    public void shouldFailTheBookReturn() throws Exception {
        assertThat(app.returnBook("Book5"), is("That is not a valid book to return."));
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