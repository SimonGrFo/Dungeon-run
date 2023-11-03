package com.SimonGradinForsgren.oop;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Logic.printHeading("testing header methods");
        Logic.anythingToContinue();
        Logic.clearConsole();
        int input = Logic.readInt("Enter 1, 2 or 3: ", 3);
        System.out.println("you chose number" + input);


    }



}
