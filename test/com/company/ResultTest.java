package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void displayCurrentResultForGameResultingInDraw() {
        Result currentResult = new Result();
        int resultResturned = currentResult.displayCurrentResult(3,1);
        assertEquals(0,resultResturned);


    }
    @Test
    void displayCurrentResultForEitherPlayerWinningTheGame(){
        Result currentResult = new Result();
        int resultReturned =  currentResult.displayCurrentResult(0,1);
        assertEquals(1,resultReturned);
    }
}