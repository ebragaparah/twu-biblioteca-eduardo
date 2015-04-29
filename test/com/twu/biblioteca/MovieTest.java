package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MovieTest {
    private Movie movie;

    @Before
    public void setUp() {
        movie = new Movie("Avengers", "Spielberg", 2015, 9);
    }

    @Test
    public void checksMovieAttributes() throws Exception {
        assertThat(movie.getName(), is("Avengers"));
        assertThat(movie.getDirector(), is("Spielberg"));
        assertThat(movie.getYear(), is(2015));
        assertThat(movie.getRate(), is(9));
    }

    @Test
    public void ShouldShowTheDetailsOfAMovie() {
        assertThat(movie.getDetails(), contains(new Object[]{"Avengers", "Spielberg", 2015, 9}));
    }
}
