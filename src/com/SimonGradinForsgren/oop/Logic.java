package com.SimonGradinForsgren.oop;
import java.util.Scanner;

import java.sql.SQLOutput;

public class Logic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    //story elements
    public static int place = 0, act;
    public static String[] places = {"Apartments", "backyard", };

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

        //print story intro
        Story.printIntro();

        //create new player object with the name
        player = new Player(name);

        //print first story act intro
        Story.printFirstActIntro();

        //setting isRunning to true, so the game loop can continue
        isRunning = true;


        //start main game loop
        gameLoop();
    }


    //method to continue the journey
    public static void continueJourney() {

    }

    //printing out the most important information about the player character
    public static void characterInfo() {
        clearConsole();
        printHeading("STATUS");
        System.out.println(player.name + "/tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        System.out.println("XP: " + player.xp);
        printSeparator(20);


        //printing the chosen traits
        if (player.numAtkUpgrades > 0) {
            System.out.println("Offensive trait: " + player.AtkUpgrades[player.numAtkUpgrades - 1]);
        }
        if (player.numDefUpgrades > 0) {
            System.out.println("Defensive trait: " + player.DefUpgrades[player.numDefUpgrades - 1]);
        }

        anythingToContinue();
    }

    //printing the main menu
    public static void printMenu() {
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action");
        printSeparator(20);
        System.out.println("(1) RESUME");
        System.out.println("(2) STATUS");
        System.out.println("(3) EXIT GAME");

    }

    //main game loop
    public static void gameLoop(){
        while(isRunning){
            printMenu();
            int input = readInt("-> ", 3);
            if(input == 1)
                continueJourney();
            else if (input == 2)
                characterInfo();
            else
                isRunning = false;
                
        }
    }
}

