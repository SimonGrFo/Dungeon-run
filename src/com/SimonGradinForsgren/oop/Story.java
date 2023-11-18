package com.SimonGradinForsgren.oop;

//This class stores methods to print out the story
//i rewrote this a bunch of times then ran out of time, so it's still pretty bad
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
        System.out.println("You notice a small opening in the wall and crawl into the apartment room to the left.");
        System.out.println("As you make your way through the apartment complex you hear whispers and see shadows move");
        System.out.println("in the corners of your eyes.");
        Logic.anythingToContinue();
    }

    public static void printFirstActOutro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act I END");
        Logic.printSeparator(30);
        System.out.println("You find a staircase leading down to the second floor and proceed downwards. As you make");
        System.out.println("your way down through the dark your eyes start to adjust to the darkness. The staircase");
        System.out.println("stops at a sign that reads SECOND FLOOR, you proceed through the door next to it");
        Logic.anythingToContinue();
    }

    public static void printSecondActIntro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act II");
        Logic.printSeparator(30);
        System.out.println("You are now on the second floor, a long hallway filled with doors leading into other");
        System.out.println("apartments.");
        System.out.println("There is a door at the end of the hallway, there might be a way out there.");
        Logic.anythingToContinue();
    }

    public static void printSecondActOutro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act II END");
        Logic.printSeparator(30);
        System.out.println("You make your way through the door you previously saw at the end of the hallway. As you");
        System.out.println("start to open the door you hear footsteps frantically approaching behind you, you hurry to");
        System.out.println("make your way through the door and close it behind you and look around for a place to hide.");
        System.out.println("You spot a small vent- just big enough to enter and quickly crawl into it.");

        Logic.anythingToContinue();
    }

    public static void printThirdActIntro() {
        Logic.clearConsole();
        Logic.printSeparator(30);
        System.out.println("Act III");
        Logic.printSeparator(30);
        System.out.println("As you crawl through the vent you hear whatever ran after you break through the door.");
        System.out.println("You keep crawling until you find yourself in another room.");
        System.out.println("As you are about to crawl out of the vent it breaks under you and you fall down into");
        System.out.println("another apartment.");
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
        System.out.println("as you make your way to the front exit something moves in the corner of your eye");
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