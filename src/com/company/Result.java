package com.company;

public class Result {
    public int displayCurrentResult(int gameOverSignal, int currentPlayerId) {
        if(gameOverSignal == 3){
            System.out.println("The Game Has Ended In  A Draw");
            return 0;
        }
        System.out.println("Player "+currentPlayerId+ " has won the Game !!!");
        return 1;

    }
}
