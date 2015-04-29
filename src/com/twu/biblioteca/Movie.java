package com.twu.biblioteca;
import java.util.ArrayList;

public class Movie extends Item {
    private String director;
    private int rate;

    public Movie(String name, String director, int year, int rate) {
        super(name, year);
        this.director = director;
        this.rate = rate;
    }

    public String getDirector() {
        return this.director;
    }

    public int getRate() {
        return this.rate;
    }

    public ArrayList<Object> getDetails() {
        ArrayList<Object> bookDetails = new ArrayList<Object>();
        bookDetails.add(this.getName());
        bookDetails.add(this.getDirector());
        bookDetails.add(this.getYear());
        bookDetails.add(this.getRate());
        return bookDetails;
    }
}