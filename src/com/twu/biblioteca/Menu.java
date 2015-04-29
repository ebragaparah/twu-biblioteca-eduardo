package com.twu.biblioteca;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<String> selectableOptions;

    public Menu() {
        this.selectableOptions = new ArrayList<String>();
    }

    public ArrayList<String> getSelectableOptions() {
        return this.selectableOptions;
    }

    public void addOptions(String option) {
        this.selectableOptions.add(option);
    }

    public String printMenu() {
        System.out.println("Escolha uma das opcoes do menu abaixo:\n");
        String menuString = "";
        for(String item: selectableOptions) {
            menuString += item + "\n";
        }
        System.out.println(menuString);
        return menuString;
    }

    public String getChoiceFromKeyboard() {
        Scanner keyboard = new Scanner(System.in);
        String choice = keyboard.nextLine();
        return choice;
    }

    public boolean ChoiceIsValid(String choice) {
        return this.selectableOptions.contains(choice);
    }
}
