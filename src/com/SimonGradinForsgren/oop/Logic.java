package com.SimonGradinForsgren.oop;
import com.SimonGradinForsgren.oop.enemies.Enemy;

import java.util.Scanner;

public class Logic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    //random encounters
    public static String[] encounters = {" Battle ", " Battle ", " Battle ", " Rest ", " Rest "};

    //enemy names
    public static String[] enemies = {" Shade " , " Shade " , " Banshee " , " Banshee " , " Ghost " };

    //story elements
    public static int place = 0, act = 1;
    public static String[] places = {"3rd floor", "2nd floor", "1st floor" };

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
        System.out.println("\nEnter anything to continue...");
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
        System.out.println("Apartments");
        System.out.println("By Simon");
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

    //method that changes the games values based on how much xp the player has
    public static void checkAct(){
        //change acts based on xp
        if(player.xp >= 10 && act == 1){
            act = 2;
            place = 1;
            //story
            Story.printFirstActOutro();
            //let the player level up
            player.chooseTrait();
            //story
            Story.printSecondActIntro();
            //assign values to enemies
            enemies[0] = "Shade";
            enemies[1] = "Shade";
            enemies[2] = "Shade";
            enemies[3] = "Shade";
            enemies[4] = "Shade";
            //assign values to encounters
            encounters[0] = "battle";
            encounters[1] = "battle";
            encounters[2] = "battle";
            encounters[3] = "battle";
            encounters[4] = "battle";
        }else if(player.xp >= 50 && act == 2) {
            act = 3;
            place = 2;
            //story
            Story.printSecondActOutro();
            //let the player level up
            player.chooseTrait();
            //story
            Story.printThirdActIntro();
            //assign values to enemies
            enemies[0] = "Shade";
            enemies[1] = "Shade";
            enemies[2] = "Banshee";
            enemies[3] = "Banshee";
            enemies[4] = "Shade";
            //assign values to encounters
            encounters[0] = "battle";
            encounters[1] = "battle";
            encounters[2] = "battle";
            encounters[3] = "battle";
            encounters[4] = "battle";
        }else if(player.xp >= 100 && act == 3){
            act = 4;
            place = 3;
            //story
            Story.printThirdActOutro();
            //let the player level up
            player.chooseTrait();
            //story
            Story.printFourthActIntro();
            //fully heal the player before the final boss
            player.hp = player.maxHp;
            //start the final boss battle
            finalBattle();

        }

    }

    //method to calculate a random encounter
    public static void randomEncounter() {
        //random number between 0 and the length of the encounters array
        int encounter = (int) (Math.random() * encounters.length);
        //calling the respective methods
        if (encounters[encounter].trim().equals("Battle")) {
            randomBattle();
        } else if (encounters[encounter].trim().equals("Rest")) {
            takeRest();
        } else {
            shop();
        }
    }


    //method to continue the journey
    public static void continueJourney() {
        //Check if player must progress to the next act
        checkAct();
        //Check if the player is in the last act (final boss) and if the player is not in last act then play a random
        //enemy encounter
        if (act != 4)
            randomEncounter();
    }

    //printing out the most important information about the player character
    public static void characterInfo() {
        clearConsole();
        printHeading("STATUS");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);
        // player xp and souls
        System.out.println("XP: " + player.xp + "\tSouls" + player.souls);
        printSeparator(20);
        // number of heals
        System.out.println("# of heals; " + player.heals);
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

    //shop
    public static void shop(){
        clearConsole();
        printHeading("You encounter a stranger. \n He offers you a bargain");
        int price = (int) (Math.random()* (10 + player.heals*3) + 10 + player.heals);
        System.out.println("- Heal; " + price + " souls.");
        printSeparator(20);
        //ask the player to buy one
        System.out.println("Do you want to buy one?\n(1) Yes.\n(2) No.");
        int input = readInt("-> ", 2);
        if(input == 1){
            clearConsole();
            //check if the player has enough souls to buy the healing item
            if(player.souls >= price){
                printHeading("You bought a healing item for " + price + "souls");
                player.souls++;
                player.souls -= price;
            }else
                printHeading("You are unable to afford the item.");
            anythingToContinue();
        }
    }

    //rest
    public static void takeRest(){
        clearConsole();
        if(player.restsLeft >= 1){
            printHeading("do you want to take a rest? (" + player.restsLeft + " rest(s) left.");
            System.out.println("(1) Yes\n(2) No");
            int input = readInt("-> ", 2);
            if (input == 1){
                //player rests
                clearConsole();
                if(player.hp < player.maxHp){
                    int hpRestored = (int) (Math.random() * player.xp/4 + 1) + 10;
                    player.hp += hpRestored;
                    if (player.hp > player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("you rested and restored " + hpRestored + " health.");
                    System.out.println("You are now at " + player.hp + "/" + player.maxHp + "health.");
                    player.restsLeft--;
                }
            }else
                System.out.println("You are already at full health");
            anythingToContinue();
        }
    }

    //create random battle
    public static void randomBattle(){
        clearConsole();
        printHeading("You came upon an entity and prepare to fight");
        anythingToContinue();
        //random enemy
        battle(new Enemy(enemies[(int)(Math.random()*enemies.length)], player.xp));
    }

    //main BATTLE method
    public static void battle(Enemy enemy){
        //main battle loop
        while(true){
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose an action");
            printSeparator(20);
            System.out.println("(1) Fight\n(2) Heal\n(3) Escape");
            int input = readInt("-> ", 3);
            if(input == 1){
                //FIGHT!!!
                //calculate damage dealt and taken by and to enemies
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();
                //check that dmg and dmgTook isn't negative so player doesn't heal from enemy attack vice versa
                if(dmgTook < 0){
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if (dmg < 0)
                    dmg = 0;
                player.hp -= dmgTook;
                enemy.hp -= dmg;
                //print information about that happened in the round of the battle
                clearConsole();
                printHeading("BATTLE");
                System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                printSeparator(15);
                System.out.println("The " + enemy.name + "dealt " + dmgTook + " damage to you.");
                anythingToContinue();
                //check if the player is still alive
                if(player.hp <= 0){
                    playerDied(); //method that ends the game since you didn't pop off and win
                    break;
                } else if(enemy.hp <= 0){
                    //woah you won!!!!!!!!!!!!
                    clearConsole();
                    printHeading("you bested the " + enemy.name + "!");
                    // TODO would be cool to add specialised death messages for each enemy
                    // increase xp for killing enemy
                    player.xp += enemy.xp;
                    System.out.println("you earned "+ enemy.xp + "XP!");
                    //random loot
                    boolean addRest = (Math.random()*5 + 1 <= 2.25);
                    int soulsEarned = (int) (Math.random()*enemy.xp);
                    if (addRest){
                        player.restsLeft++;
                        System.out.println("you earned the chance to get an additional rest!");
                    }
                    if(soulsEarned > 0){
                        player.souls += soulsEarned;
                        System.out.println("you collect " + soulsEarned + "souls from the " + enemy.name + "!");
                    }
                    anythingToContinue();
                    break;
                }
            }else if(input == 2){
                //heal
                clearConsole();
                if(player.heals > 0 && player.hp < player.maxHp){
                    //player CAN heal
                    //ask if player is sure they want to heal
                    printHeading("Do you want to heal? (" + player.heals + "left).");
                    System.out.println("(1) Yes\n(2) No");
                    input = readInt("-> ", 2);
                    if (input == 1){
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You healed, your health is not at " + player.maxHp);
                        anythingToContinue();
                    }
                }else{
                    //player CAN'T heal
                    printHeading("You are unable to heal.");
                    anythingToContinue();

                }
            }else{
                //RUN
                clearConsole();
                //
                if(Math.random()*10 + 1 <= 3.5){
                    printHeading("You ran away from the " + enemy.name + "!");
                    anythingToContinue();
                    break;
                }else{
                    printHeading("Your escape attempt was unsuccessful and the" + enemy.name + "blocked your path.");
                    //calculate how much damage you took in your failed escape attempt
                    int dmgTook = enemy.attack();
                    System.out.println("You took " + dmgTook + "damage.");
                    anythingToContinue();
                    //see if the player survived
                    if(player.hp <= 0)
                        playerDied();

                }

            }

        }
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

    //final boss
    public static void finalBattle(){
        battle(new Enemy("Shape", 300));
        //print ending
        Story.printEnd(player);
        isRunning = false;

    }

    //method for when player dies
    public static void playerDied(){
        clearConsole();
        printHeading("you were unable to escape, you died");
        printHeading("you attained " + player.xp + "XP in your attempt");
        isRunning = false;
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

