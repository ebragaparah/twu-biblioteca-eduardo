package com.twu.biblioteca;

public class Item {
    private String name;
    private int year;

    public Item(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }
}
