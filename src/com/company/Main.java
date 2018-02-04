package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int GAME_LOW = 0;
        int GAME_HIGH = 5;

        int low = GAME_LOW;
        int high = GAME_HIGH;
        Scanner sc = new Scanner(System.in);

        Random diceRoll = new Random();
        boolean anotherRound = true;

        while (anotherRound) {
            int randomlyPickedNumber = diceRoll.nextInt(high);

            int numOfTimesGuessed = 0;
            boolean ask = true;

            while (ask) {
                numOfTimesGuessed++;
                System.out.println("Please guess a number between " + low + " and " + high);
                String userGuessString = sc.nextLine();
                int userGuessInt = Integer.parseInt(userGuessString);

                if (userGuessInt > randomlyPickedNumber) {
                    System.out.println("TOO HIGH!");
                    high = userGuessInt;
                }
                if (userGuessInt < randomlyPickedNumber) {
                    System.out.println("TOO LOW!");
                    low = userGuessInt;
                }
                if (userGuessInt == randomlyPickedNumber) {
                    System.out.println("YOU GUESSED CORRECTLY!");
                    System.out.println("It took " + numOfTimesGuessed + " to get it correct!");
                    ask = false;

                    System.out.println("Do you want to play again?");
                    String playAgain = sc.nextLine();
                    if (playAgain.equalsIgnoreCase("yes") ||
                            playAgain.equalsIgnoreCase("y")) {
                        high = GAME_HIGH;
                        low = GAME_LOW;
                    } else {
                        anotherRound = false;
                    }

                }

            }
        }
    }
}
