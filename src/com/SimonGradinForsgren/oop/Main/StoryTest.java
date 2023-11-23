package com.SimonGradinForsgren.oop.Main;

import org.junit.jupiter.api.Test;


class StoryTest {

    //Testing all story progressions (text that is displayed when moving to the next floor which
    // happens when you level up).

    //I tried over the last 6 or so hours to write tests on other methods but was unable to, they run completely
    // fine when playing the game, but I cannot find a way to make the test run them, the issue seems to be the fact
    // almost everything uses Input and "Logic.anythingToContinue();" which requires To be Input from the user and I
    // have not gotten it to work with Junit.

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