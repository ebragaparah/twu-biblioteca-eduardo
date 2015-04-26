package com.twu.biblioteca;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LibraryTest {
    private Library library;
    private Book book1, book2, book3;

    @Before
    public void setUp() {
        library = new Library();
        book1 = new Book("Book1", "John Doe", 1995);
        book2 = new Book("Book2", "John Doe", 1998);
        book3 = new Book("Book3", "John Doe", 2004);
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
        ArrayList<Object> book1 = new ArrayList<Object>() {{ add("Book1"); add("John Doe"); add(1995); }};
        ArrayList<Object> book2 = new ArrayList<Object>() {{ add("Book2"); add("John Doe"); add(1998); }};
        ArrayList<Object> book3 = new ArrayList<Object>() {{ add("Book3"); add("John Doe"); add(2004); }};
        assertThat(library.listAllBooksDetailed(), contains(new Object[] {book1, book2, book3}));
    }
}