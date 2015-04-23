package com.twu.biblioteca;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import junit.framework.TestCase;

public class BookTest extends TestCase {
    private Book book;

    @Before
    public void setUp() {
        book = new Book("O Pequeno Principe", "John Doe", 2015);
    }

    public void testShouldReturnTrue() {
        assertThat(1, is(1));
    }
}
