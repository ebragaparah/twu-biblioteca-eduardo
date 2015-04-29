package com.twu.biblioteca;

public class Message {

    public static String welcomeMessage(String name) {
        System.out.println("Welcome, " + name + "! The Library is available.");
        return "Welcome, " + name + "! The Library is available.";
    }

    public static String successfulCheckoutMessage(String username) {
        System.out.println("Thank you, " + username + "! Enjoy the book.");
        return "Thank you, " + username + "! Enjoy the book.";
    }

    public static String unsuccessfulCheckoutMessage(String username) {
        System.out.println("Sorry, " + username + ". The book is not available.");
        return "Sorry, " + username + ". The book is not available.";
    }

    public static String successfulReturnMessage(String username) {
        System.out.println("Thank you for returning the book, " + username + ".");
        return "Thank you for returning the book, " + username + ".";
    }

    public static String unsuccessfulReturnMessage(String username) {
        System.out.println("Sorry, " + username +  ". That is not a valid book to return.");
        return "Sorry, " + username +  ". That is not a valid book to return.";
    }
}