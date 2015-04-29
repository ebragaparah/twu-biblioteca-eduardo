package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() {
        user = new User("629-01x9", "abcdef", "Eduardo", "eduardo@abc.com", "1234-4321");
    }
}
