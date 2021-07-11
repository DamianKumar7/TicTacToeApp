package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void testValidPositionForPositionOccupied() {
        Board currentBoard = new Board();
        currentBoard.resetBoard();
        currentBoard.board[2][0] = 'X';
        boolean validPositionChecker = currentBoard.validatePosition('7');
        assertFalse(validPositionChecker);

    }
    @Test
    void testValidPositionForPositionNotOccupied() {
        Board currentBoard = new Board();
        currentBoard.resetBoard();
        boolean validPositionChecker = currentBoard.validatePosition('7');
        assertTrue(validPositionChecker);

    }
    @Test
    void testCheckGameOverMethodForGameNotOver() {
        Board currentBoard = new Board();
        currentBoard.resetBoard();
        currentBoard.board[0][1] = currentBoard.board[0][0];
        int checkForGameOver = currentBoard.checkGameOver();
        assertEquals(0,checkForGameOver);
    }
    @Test
    void testCheckGameOverMethodForRowWithSameElements() {
        Board currentBoard = new Board();
        currentBoard.resetBoard();
        currentBoard.board[0][1] = currentBoard.board[0][0];
        currentBoard.board[0][2] = currentBoard.board[0][1];

        int checkForRowWithSameElements = currentBoard.checkGameOver();
        assertEquals(1,checkForRowWithSameElements);
    }
    @Test
    void testCheckGameOverMethodForColumnWithSameElements() {
        Board currentBoard = new Board();
        currentBoard.resetBoard();
        currentBoard.board[1][0] = currentBoard.board[0][0];
        currentBoard.board[2][0] = currentBoard.board[1][0];

        int checkForColumnWithSameElements = currentBoard.checkGameOver();
        assertEquals(1,checkForColumnWithSameElements);
    }
    @Test
    void testForCheckingIfDiagonalHasSameElements() {
        Board currentBoard = new Board();
        currentBoard.resetBoard();
        currentBoard.board[1][1] = currentBoard.board[0][0];
        currentBoard.board[2][2] = currentBoard.board[1][1];
        boolean checkForDiagonalElements = currentBoard.checkDiagonalHasSameElements();
        assertTrue(checkForDiagonalElements);
    }
}