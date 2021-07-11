package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {
    @Test
    void testForChangingPlayerControlFromCurrentPlayer() {
        TicTacToeGame newGame = new TicTacToeGame();
        int controlForPlayerSwitched = newGame.switchPlayerControl(1);
        assertEquals(2,controlForPlayerSwitched);
    }
}