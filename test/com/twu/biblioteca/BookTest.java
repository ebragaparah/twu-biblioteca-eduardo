package com.twu.biblioteca;

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
    public void checksBookAttributes() {
        assertThat(book.getName(), is("Book1"));
        assertThat(book.getAuthor(), is("John Doe"));
        assertThat(book.getYear(), is(2015));
    }
}