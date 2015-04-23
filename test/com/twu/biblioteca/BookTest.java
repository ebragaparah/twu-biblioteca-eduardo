package com.twu.biblioteca;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class BookTest {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("Book1", "John Doe", 2015);
    }

    @Test
    public void ShouldReturnTrue() {
        assertThat(book.getName(), is("Book1"));
        assertThat(book.getAuthor(), is("John Doe"));
        assertThat(book.getYearOfPublishment(), is(2015));
    }

    @Test
    public void ShouldShowTheDetailsOfABook() {
        assertThat(book.getDetails(), contains(new Object[]{"Book1", "John Doe", 2015}));
    }
}