package com.twu.biblioteca;

public class Message {

    public static String welcomeMessage(String name) {
        System.out.println("Welcome, " + name + "! The Library is available.");
        return "Welcome, " + name + "! The Library is available.";
    }

    public static String successfulCheckoutMessage() {
        System.out.println("Thank you! Enjoy the book.");
        return "Thank you! Enjoy the book.";
    }

    public static String unsuccessfulCheckoutMessage() {
        System.out.println("The book is not available.");
        return "The book is not available.";
    }

    public static String successfulReturnMessage() {
        System.out.println("Thank you for returning the book.");
        return "Thank you for returning the book.";
    }

    public static String unsuccessfulReturnMessage() {
        System.out.println("That is not a valid book to return.");
        return "That is not a valid book to return.";
    }
}