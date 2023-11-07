package com.SimonGradinForsgren.oop;

//This class only stores methods to print out the story
public class Story {

    public static void printIntro(){
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("STORY");
        Logic.printSeparator(30);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        Logic.anythingToContinue();

    }
}
