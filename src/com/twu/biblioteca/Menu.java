package com.twu.biblioteca;
import java.util.ArrayList;

public class Menu {
    private ArrayList<String> options;

    public Menu() {
        this.options = new ArrayList<String>();
    }

    public ArrayList<String> getOptions() {
        return this.options;
    }

    public void addOptions(String option) {
        this.options.add(option);
    }

    public String printMenu() {
        String menuString = "";
        for(String item: options) {
            menuString += item + "\n";
        }
        return menuString;
    }
}
