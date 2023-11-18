package com.SimonGradinForsgren.oop;

//This class only stores methods to print out the story
public class Story {

    public static void printIntro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("STORY");
        Logic.printSeparator(30);
        System.out.println("As you open your eyes you find yourself in a dimly lit room. The space around you is dusty");
        System.out.println("with peeling wallpapers. A single flickering light bulb casts long shadows over the room.");
        System.out.println("The eerie silence is only broken by the hum of an air conditioner.");
        Logic.anythingToContinue();
    }

    public static void printFirstActIntro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act I");
        Logic.printSeparator(30);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        Logic.anythingToContinue();
    }

    public static void printFirstActOutro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act I END");
        Logic.printSeparator(30);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        Logic.anythingToContinue();
    }

    public static void printSecondActIntro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act II");
        Logic.printSeparator(30);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        Logic.anythingToContinue();
    }

    public static void printSecondActOutro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act II END");
        Logic.printSeparator(30);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        Logic.anythingToContinue();
    }

    public static void printThirdActIntro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act III");
        Logic.printSeparator(30);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        Logic.anythingToContinue();
    }

    public static void printThirdActOutro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act III END");
        Logic.printSeparator(30);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        Logic.anythingToContinue();
    }

    public static void printFourthActIntro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act III END");
        Logic.printSeparator(30);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        Logic.anythingToContinue();
    }

    public static void printEnd(Player player) {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("You escaped the apartment");
        }
}