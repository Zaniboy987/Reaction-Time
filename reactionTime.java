package main;
// imported libraries

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.currentTimeMillis;

// main class
public class reactionTime {
    // opening sequence
    static void opening() {
        System.out.println("**************************************************\n" +
                "\t\t\tWELCOME TO REACTION TIME!\n" +
                "**************************************************\n" +
                "You will be challenged on how fast you can react!\n" +
                "**************************************************\n");
    }

    // recurring menu
    static void menu() {
        // Initialize variables
        Scanner input = new Scanner(System.in);
        int num = 0;

        // do-while loop to determine action of the user
        do {
            System.out.println("1. PLAY!\t2. LEADERBOARD\t3. EXIT\n\n" +
                    "Enter the number for your desired ACTION!");
            num = input.nextInt();
        } while (num > 3);

        // switch cases determine next actions of the user
        switch (num) {
            case 1:
                System.out.println("You chose the option to PLAY");
                game();
                break;
            case 2:
                System.out.println("You chose the option to view the leaderboard");
                break;
        }
    }

    // leaderboards
    static void leaderboard(int tries, ArrayList<Long> times) {
        System.out.println("RANK\tTIME");

        // loops for the amount of tries by the player
        for (int i = 0; i < tries; i++) {
            System.out.println(i + "\t" + times.get(i));
        }

        // setting to return to main menu
        System.out.println("**************************************************\n" +
                "Enter 1 to return to the main menu\n\n");
    }


    // method includes reaction time segment
    static long game() {
        System.out.println("ENTER 1 WHEN YOU SEE - GO -\n");
        Scanner input = new Scanner(System.in);

        // beginning time
        long start = currentTimeMillis();

        // ending time
        long end = currentTimeMillis();

        // result
        long result = end - start;

        System.out.println("YOUR REACTION TIME IS: " + result + "ms!");
        return result;
    }


    // main method
    public static void main(String[] args) {
        // initialize variables
        int tries = 0;

        opening();
        menu();
        // leaderboard();

        // ending screen
        System.out.println("\n**************************************************\n" +
                "THANK YOU FOR PLAYING!!!\n" +
                "**************************************************");

    }
}
