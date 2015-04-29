package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Menu menu = new Menu();
        Library library = new Library();
//        System.out.println("Gostaria de informar seu nome para iniciar sua sessao?");
//        String username = keyboard.nextLine();
//        String email = keyboard.nextLine();
//        String username = keyboard.nextLine();
//        String username = keyboard.nextLine();
        User user = new User("", "", "", "", "");
        Session session = new Session("", library);
        menu.addOptions("Listar Livros");
        menu.addOptions("Listar Filmes");
        do {
            menu.printMenu();
        } while (menu.ChoiceIsValid(menu.getChoiceFromKeyboard()));
    }
}
