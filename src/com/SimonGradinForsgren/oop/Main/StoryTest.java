package com.SimonGradinForsgren.oop.Main;

import org.junit.jupiter.api.Test;


class StoryTest {

    //Testing all story progressions (text that is displayed when moving to the next floor which
    // happens when you level up).

    @Test
    void testPrintIntro() {
        //test intro of story
        Story.printIntro();
    }
    @Test
    void testFirstAct() {
        Story.printFirstActIntro();
    }
    @Test
    void firstActOutro() {
        Story.printFirstActOutro();
    }
    @Test
    void testSecondActIntro() {
        Story.printSecondActIntro();
    }
    @Test
    void testSecondActOutro() {
        Story.printSecondActOutro();
    }
    @Test
    void testThirdActIntro() {
        Story.printThirdActIntro();
    }
    @Test
    void testThirdActOutro() {
        Story.printThirdActOutro();
    }
    @Test
    void testFourthActIntro() {
        Story.printFourthActIntro();
    }
}