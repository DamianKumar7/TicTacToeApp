package com.company;

import java.util.Scanner;

import static com.company.GameState.ONGOING;

public class TicTacToeGame {
    Board board;
    Player player1;
    Player player2;
    Scanner sc;
    TicTacToeGame newGame


    TicTacToeGame(int boardSize) {
        sc = new Scanner(System.in);
        board = new Board();
        newGame = new TicTacToeGame(boardSize);
        board.resetBoard(boardSize);
        newGame.playGame();
    }

    public static void main(String[] args) {


    }

    public void displayCurrentResult(GameState gameOverSignal, int currentPlayerId) {
        if (gameOverSignal == GameState.DRAW) {
            System.out.println("The Game Has Ended In  A Draw");
            return;
        }
        System.out.println("Player " + currentPlayerId + " has won the Game !!!");

    }

    public void playGame() {

        //Instructions newGameInstructions = new Instructions();
        //newGameInstructions.displayGameInstructions();


        player1 = new Player('X');
        player2 = new Player('O');
        int currentPlayerId = 1;


        while (board.getGameState() == ONGOING) {
            makeAValidMove(currentPlayerId);
            board.display();
            if (board.getGameState() != ONGOING) {
                displayCurrentResult(board.getGameState(), currentPlayerId);
                break;
            }

            currentPlayerId = switchPlayerControl(currentPlayerId);

        }

    }

    public int switchPlayerControl(int currentPlayerId) {
        return currentPlayerId == 1?2:1;

    }

    public void makeAValidMove(int currentPlayerId) {
        char currentPosition;
        if (currentPlayerId == 1) {
            // System.out.println("Player1 : ");
            currentPosition = player1.getPositionAsInputFromConsole();
            while (!board.validatePosition(currentPosition)) {
                // System.out.println("Please Enter A Valid Position:");
                currentPosition = player1.getPositionAsInputFromConsole();
            }
            board.updateBoard(currentPosition, player1.playerPiece);

        } else {
            // System.out.println("Player2 : ");
            currentPosition = player2.getPositionAsInputFromConsole();
            while (!board.validatePosition(currentPosition)) {
                // System.out.println("Please Enter A Valid Position:");
                currentPosition = player2.getPositionAsInputFromConsole();
            }
            board.updateBoard(currentPosition, player2.playerPiece);

        }


    }

}

