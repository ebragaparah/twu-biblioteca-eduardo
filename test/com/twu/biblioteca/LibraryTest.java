package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryTest {
    private Library library;

    @Before
    public void setUp() {
        library = new Library();
        Book book1 = new Book("Book1", "John Doe", 1995);
        Book book2 = new Book("Book2", "John Doe", 1998);
        Book book3 = new Book("Book3", "John Doe", 2004);
        library.registerBook(book1);
        library.registerBook(book2);
        library.registerBook(book3);
    }

    @Test
    public void shouldListAllBooks() throws Exception {
        ArrayList<String> listOfBooks = library.listAllBooks();
        assertThat(listOfBooks, contains("Book1", "Book2", "Book3"));
    }

    @Test
    public void shouldListAllBooksDetailed() throws Exception {
        ArrayList<Book> libraryBooks = library.getBooks();
        assertThat(libraryBooks.size(), is(3));
    }
}
