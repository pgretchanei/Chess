package com.petro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game myGame = new Game();
        while(!myGame.end()) {
            Scanner S = new Scanner(System.in);
            EPosition start = myGame.convertToEnum(S.next());
            EPosition end = myGame.convertToEnum(S.next());
            if (!start.equals(EPosition.ERROR) && !end.equals(EPosition.ERROR)){
                myGame.makeMove(start, end);
            }else{
                System.out.println("Illegal move, try again");
            }

        }
        System.out.println("Game ended. " + myGame.getResult().toUpperCase() + ".");
    }
}
