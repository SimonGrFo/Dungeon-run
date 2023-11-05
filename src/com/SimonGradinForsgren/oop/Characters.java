package com.SimonGradinForsgren.oop;

public abstract class Characters {

    //variable / attributes all Characters have
    public String name;
    public int maxHp, hp, xp;

    //Constructor for character
    public Characters(String name, int maxHp, int xp){
        this.name = name;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp = maxHp;
    }

    //methods every character has
    public abstract int attack();
    public abstract int defend();



}
