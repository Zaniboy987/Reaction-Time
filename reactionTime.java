package main;
// imported libraries

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.currentTimeMillis;

// main class
public class reactionTime {
    // opening sequence
    static void opening() {
        System.out.println("********************" +
                "WELCOME TO REACTION TIME!\n\n" +
                "You will be challenged on how fast you can react!\n" +
                "*************************************************\n");
    }

    // recurring menu
    static void menu() {
        // Initialize variables
        Scanner input = new Scanner(System.in);
        int num;

        // do-while loop to determine action of the user
        do {
            System.out.println("1. PLAY!\t2. LEADERBOARD\t3. EXIT\n\n" +
                    "Enter the number for your desired ACTION: ");
            num = input.nextInt();
        } while(num != 1 || num != 2 || num != 3);

    }

    // leaderboards
    static void leaderboard(int tries, ArrayList<Long> times) {
        System.out.println("RANK\tTIME");

        // loops for the amount of tries by the player
        for (int i = 0; i < tries; i++) {
            System.out.println(i + "\t" + times.get(i));
        }

        // setting to return to main menu
        System.out.println("******************************************" +
                "Enter 1 to return to the main menu\n\n");
    }

    // main method
    public static void main(String[] args) {
        // initialize variables
        int tries = 0;

        opening();
        menu();

    }
}
