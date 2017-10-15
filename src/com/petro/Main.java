package com.petro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Game myGame = new Game();
        while(!myGame.end()) {
            Scanner S = new Scanner(System.in);
            String first = S.next();
            String second = S.next();
            EPosition start = myGame.convertToEnum(first);
            EPosition end = myGame.convertToEnum(second);
            if (start != null && end != null){
                //EGameOffer offer1 = myGame.convertToEnumOffer(first);
                //EGameOffer offer2 = myGame.convertToEnumOffer(second);
                //if(!offer1.equals(EGameOffer.ERROR) && !offer2.equals(EGameOffer.ERROR)) {
                    myGame.makeMove(start, end);
                //}
            }else{
                System.out.println("Illegal move, try again");
            }

        }
        System.out.println("Game ended. " + myGame.getResult().toUpperCase() + ".");
    }
}
