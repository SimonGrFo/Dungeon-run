package com.SimonGradinForsgren.oop;

public class Player extends Characters{



    //integers to store number of upgrades/skills in each path
    public int numAtkUpgrades, numDefUpgrades;


    //Arrays to store skill names
    public String[] AtkUpgrades ={"Attack I", "Attack II", "Attack III", "Attack IV"};
    public String[] DefUpgrades ={"Defense I", "Defense II", "Defense III", "Defense IV"};


    //player specific constructor
    public Player(String name) {
        //calling constructor to superclass
        super(name, 100, 0);
        //setting # of upgrades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        //let player choose a trait when creating a new character
        chooseTrait();
    }

    @Override
    public int attack() {
        return 0;
    }
    @Override
    public int defend() {
        return 0;
    }
    //let player choose a trait of either skill path
    public void chooseTrait(){
        Logic.clearConsole();
        Logic.printHeading("Choose a trait: ");
        System.out.println("(1) " + AtkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + DefUpgrades[numDefUpgrades]);
        //get the player choice
        int input = Logic.readInt("-> ", 2);
        Logic.clearConsole();
        //deal with both cases
        if(input == 1){
            Logic.printHeading("you chose " + AtkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        }else{
            Logic.printHeading("you chose " + DefUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }
        Logic.anythingToContinue();


    }
}
