package com.company;

import java.util.*;
public class TicTacToeGame {
    Board currentBoard;
    Player player1;
    Player player2;
    Scanner sc;
    Result currentResult;
    TicTacToeGame(){
        sc = new Scanner(System.in);
        currentBoard = new Board();
        currentResult = new Result();
    }
    public static  void  main(String[]args){
        TicTacToeGame newGame = new TicTacToeGame();
        newGame.playGame();
    }
    public void playGame(){

        Instructions newGameInstructions = new Instructions();
        newGameInstructions.displayGameInstructions();
        currentBoard.resetBoard();

        player1 = new Player('X');
        player2 = new Player('O');
        int gameOverSignal = 0;

        int currentPlayerId = 1;



        while(gameOverSignal == 0){
                makeAValidMove(currentPlayerId);
                currentBoard.displayBoard();
                gameOverSignal = currentBoard.checkGameOver();
                if(gameOverSignal != 0) {
                    currentResult.displayCurrentResult(gameOverSignal,currentPlayerId);
                    break;
                }

                currentPlayerId = switchPlayerControl(currentPlayerId);

        }

    }

    public int switchPlayerControl(int currentPlayerId) {
        if(currentPlayerId == 1){
            return 2;
        }
        return 1;

    }

    public void makeAValidMove(int currentPlayerId){
        char currentPosition;
        if(currentPlayerId == 1){
            System.out.println("Player1 : ");
            currentPosition = player1.getPositionAsInputFromConsole();

            while(!currentBoard.validatePosition(currentPosition)){
                System.out.println("Please Enter A Valid Position:");
                currentPosition =  player1.getPositionAsInputFromConsole();
            }
            currentBoard.updateBoard(currentPosition,player1);

        }
        else{
            System.out.println("Player2 : ");
            currentPosition = player2.getPositionAsInputFromConsole();
            while(!currentBoard.validatePosition(currentPosition)){
                System.out.println("Please Enter A Valid Position:");
                currentPosition =  player2.getPositionAsInputFromConsole();
            }
            currentBoard.updateBoard(currentPosition,player2);

        }


    }

}

