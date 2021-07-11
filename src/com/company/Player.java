package com.company;

import java.util.Scanner;

public class Player {
    Scanner sc;
    char playerPiece;
    Player(char playerPiece){
        sc = new Scanner(System.in);
        this.playerPiece = playerPiece;
    }
    public char getPositionAsInputFromConsole(){
        System.out.println("Take Position From Board Where You Want To Place The Item");
        char positionOnBoard = sc.next().charAt(0);
        return positionOnBoard;
    }


}
