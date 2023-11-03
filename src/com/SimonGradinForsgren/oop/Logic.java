package com.SimonGradinForsgren.oop;
import java.util.Scanner;

import java.sql.SQLOutput;

public class Logic {
    static Scanner scanner = new Scanner(System.in);

    //method to get user input from console
    public static int readInt(String prompt, int userChoices) {
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            }catch (Exception e){
                input = -1;
                System.out.println("Please enter an integer");
            }
        }while(input < 1 || input > userChoices);
        return input;
    }

    //method to simulate clearing the console
    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.println();
    }

    //method to print a separator with the length n
    public static void printSeparator (int n){
        for(int i = 0; i <n; i++)
            System.out.print("-");
        System.out.println();
    }

    //method to print a heading cuz that's cool yk
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //method to stop the game from doing anything until the users starts yapping
    public static void anythingToContinue(){
        System.out.println("/nEnter anything to continue...");
        scanner.next();
    }


}
