package com.SimonGradinForsgren.oop;
import java.util.Scanner;

import java.sql.SQLOutput;

public class Logic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    //method to get user input from console
    public static int readInt(String prompt, int userChoices) {
        int input;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                input = -1;
                System.out.println("Please enter an integer");
            }
        } while (input < 1 || input > userChoices);
        return input;
    }

    //method to simulate clearing the console
    public static void clearConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }

    //method to print a separator with the length n
    public static void printSeparator(int n) {
        for (int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //method to print a heading cuz that's cool yk
    public static void printHeading(String title) {
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //method to stop the game from doing anything until the users starts yapping
    public static void anythingToContinue() {
        System.out.println("/nEnter anything to continue...");
        scanner.next();
    }

    //method to start game
    public static void startGame(){
        boolean nameSet = false;
        String name;
        //print title screen
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("THIS IS A GAME");
        System.out.println("REALLY COOL GAME!!!!");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        //let the player choose a name
        do{
            clearConsole();
            printHeading("What is your name?");
            name = scanner.next();
            //asking the player if this is their name
            clearConsole();
            printHeading("your name is " + name + ".\nIs that correct?");
            System.out.println("(1) Yes!");  //proceed with chosen name
            System.out.println("(2) Sorry i lied");  //restart loop letting the player enter a new name
            int input = readInt("-> ", 2);
            if(input == 1)
                nameSet = true;
        }while(!nameSet);

        //create new player object with the name
        player = new Player(name);

        //start main game loop
        //gameLoop();
    }

}
