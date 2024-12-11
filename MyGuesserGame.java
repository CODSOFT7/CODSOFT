package com.codSoft.com;

import java.util.Scanner;

class Guesser {
    int GuesserNum;
    public int GuesserNumb() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Guesser, please guess the number between 1 to 100: ");
            GuesserNum = scan.nextInt();

            if (GuesserNum >= 1 && GuesserNum <= 100) {
                System.out.println("You Entered: " + GuesserNum);
                break;
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
            }
        }
        return GuesserNum;
    }
}

class Player {
    int PlayerNum;
    public int PlayerNumb() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Please guess the number between 1 to 100: ");
            PlayerNum = scan.nextInt();

            if (PlayerNum >= 1 && PlayerNum <= 100) {
                System.out.println("You Entered: " + PlayerNum);
                break;
            } else {
                System.out.println("Invalid input. Please enter a number between 1 and 100.");
            }
        }
        return PlayerNum;
    }
}

class Umpire {
    int Guessernum;
    int[] Playernum = new int[3];

    public void CollectNumFromGuesser() {
        Scanner scan = new Scanner(System.in);
        Guesser Gu = new Guesser();
        Guessernum = Gu.GuesserNumb();
    }

    public void CollectNumFromPlayers() {
        Scanner s = new Scanner(System.in);
        Player[] players = new Player[3];
        for (int a = 0; a < 3; a++) {
            players[a] = new Player();
            System.out.println("Player " + (a + 1) + ", it's your turn:");
            Playernum[a] = players[a].PlayerNumb();

            if (Guessernum > Playernum[a]) {
                System.out.println("Your guess is too low.");
            } else if (Guessernum < Playernum[a]) {
                System.out.println("Your guess is too high.");
            } else {
                System.out.println("Player " + (a + 1) + " guessed correctly!");
            }
        }
    }

    public void Compare() {
        boolean winnerFound = false;
        for (int a = 0; a < 3; a++) {
            if (Guessernum == Playernum[a]) {
                
                System.out.println("Player " + (a + 1) + " won the game!");
                winnerFound = true;
            }
        }
        if (!winnerFound) {
            System.out.println("No player guessed the correct number. All players lost the game.");
        }
    }
}

public class MyGuesserGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("------ Game Started ------");

        Umpire UM = new Umpire();
        UM.CollectNumFromGuesser();
        UM.CollectNumFromPlayers();
        UM.Compare();

        System.out.println("------ Game Over ------");
       // scan.close();
    }
}