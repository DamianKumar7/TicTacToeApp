package com.company;

public class Board {
    char[][] board;
    void resetBoard() {
        board = new char[3][3];
        char boardFiller = '1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = boardFiller++;
            }
        }
    }

    public boolean validatePosition(char currentPosition) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == currentPosition && board[i][j] != 'X' && board[i][j] != 'O') {
                    return true;
                }
            }
        }
        return false;
    }

    public void updateBoard(char currentPosition, Player currentPlayer) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == currentPosition) {
                    board[i][j] = currentPlayer.playerPiece;
                }
            }
        }

    }

    public GameState getGameState() {
        if (diagonalHasSameElements() || rowHasSameElements() || columnHasSameElements()) {
            return GameState.ENDED;
        }

        if(!checkMovesLeft()) return GameState.DRAW;

        return GameState.ONGOING;
    }

    private boolean checkMovesLeft() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' || board[i][j] != 'O') return false;
            }
        }
        return true;
    }

    private boolean columnHasSameElements() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                // System.out.println("The Game is Over");
                return true;
            }
        }
        return false;
    }

    private boolean rowHasSameElements() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][0] == board[i][2]) {

                //// System.out.println("The Game is Over");
                return true;
            }
        }
        return false;
    }

    public boolean diagonalHasSameElements() {
        if ((board[0][0] == board[1][1] && board[2][2] == board[0][0]) || board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            // System.out.println("The Game is Over");
            return true;
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
//                System.out.print(board[i][j]+" | ");
                if (board[i][j] == 'X' || board[i][j] == 'O') {
                    System.out.print(board[i][j] + " | ");
                } else {
                    System.out.print("_" + " | ");
                }
            }
            // System.out.println();
            // System.out.println("============");
        }
    }
}
