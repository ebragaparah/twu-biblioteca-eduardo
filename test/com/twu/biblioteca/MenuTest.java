package com.twu.biblioteca;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MenuTest {
    private Menu menu;

    @Before
    public void setUp() {
        menu = new Menu();
        menu.addOptions("List Books");
        menu.addOptions("Quit");
    }

    @Test
    public void ShouldCheckTheMenuOptions() throws Exception {
        assertThat(menu.getSelectableOptions().size(), is(2));
        assertThat(menu.getSelectableOptions(), contains(new String[]{"List Books", "Quit"}));
    }

    @Test
    public void ShouldPrintTheMenu() throws Exception {
        assertThat(menu.printMenu(), is("List Books\nQuit\n"));
    }

    @Test
    public void ShouldCheckOptionEnteredIsValidOrInvalid() throws Exception {
        assertThat(menu.ChoiceIsValid("List Books"), is(true));
        assertThat(menu.ChoiceIsValid("List Musics"), is(false));
    }
}