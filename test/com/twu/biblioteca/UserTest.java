package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserTest {

    private User notValidUser, validUser;

    @Test(expected = Exception.class)
    public void raiseAnExceptionWhenUsernameIsNotValid() throws Exception {
        notValidUser = new User("629-01x9p", "abcdef", "Eduardo", "eduardo@abc.com", "1234-4321");
    }

    @Test(expected = Exception.class)
    public void raiseAnExceptionWhenPhoneIsNotValid() throws Exception {
        notValidUser = new User("629-01x9", "abcdef", "Eduardo", "eduardo@abc.com", "91234-4321");
    }

    @Test
    public void createsAValidUser() throws Exception {
        validUser = new User("001-0149", "abcdef", "Eduardo", "eduardo@abc.com", "1234-4321");
        assertThat(validUser.getName(), is("Eduardo"));
    }

    @Test
    public void checksTheAttributesOfAUser() throws Exception {
        validUser = new User("001-0149", "abcdef", "Eduardo", "eduardo@abc.com", "1234-4321");
        assertThat(validUser.getUsername(), is("001-0149"));
        assertThat(validUser.getEmail(), is("eduardo@abc.com"));
        assertThat(validUser.getPhone(), is("1234-4321"));
    }
}
