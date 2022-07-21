// PACKAGE AND IMPORTED LIBRARIES
package main;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.currentTimeMillis;

// MAIN CLASS
public class reactionTime {
    // GLOBAL VARIABLES
    static boolean exit = false;
    static int tries = 0;
    static ArrayList<Long> times = new ArrayList<Long>();

    // OPENING SEQUENCE
    static void opening() {
        System.out.println("**************************************************\n" +
                "\t\t\tWELCOME TO REACTION TIME!\n" +
                "**************************************************\n" +
                "You will be challenged on how fast you can react!\n" +
                "**************************************************\n");
    }

    // RECURRING MENU
    static void menu() {
        Scanner input = new Scanner(System.in);
        int num = 0;

        // DO-WHILE LOOP DETERMINES ACTIONS OF THE USER
        do {System.out.println("1. PLAY!\t2. LEADERBOARD\t3. EXIT\n\n" +
                    "Enter the number for your desired ACTION!");
            num = input.nextInt();
        } while (num > 3);

        // INTERPRETS INPUT TO CORRESPONDING OPTION
        switch (num) {
            case 1:
                System.out.println("You chose the option to PLAY");
                game();
                break;
            case 2:
                System.out.println("You chose the option to view the leaderboard");
                leaderboard(tries, times);
                break;
            case 3:
                System.out.println("You chose the option to exit");
                exit = true;
                break;
        }
    }

    // LEADERBOARDS
    static void leaderboard(int tries, ArrayList<Long> times) {
        System.out.println("RANK\tTIME");

        // loops for the amount of tries by the player
        for (int i = 0; i < tries; i++) {
            System.out.println((i+1) + "\t\t" + times.get(i) + "ms");
        }

        // setting to return to main menu
        System.out.println("\n**************************************************\n");
    }

    // REACTION TIME GAME SEGMENT
    static long game() {
        // PRE - PAUSE PHASE
        System.out.println("ENTER 1 WHEN YOU SEE - GO -\n");
        Scanner input = new Scanner(System.in);
        long pauseStart = currentTimeMillis();
        long pauseCurrent = currentTimeMillis();
        int gameInput = 0;

        while ((pauseCurrent - pauseStart) < 5000) {
            pauseCurrent = currentTimeMillis();
        }

        // POST PAUSE PHASE
        long playerStart = 0;
        while (gameInput > 1 || gameInput < 1) {
            System.out.println("ENTER 1!!!");
            playerStart = currentTimeMillis();
            gameInput = input.nextInt();
        }

        long playerEnd = currentTimeMillis();
        long playerResult = playerEnd - playerStart - 250;
        System.out.println("YOUR REACTION TIME IS: " + playerResult + "ms!");
        times.add(playerResult);
        return playerResult;
    }

    // MAIN METHOD
    public static void main(String[] args) {
        // WHILE-LOOP TO GO THROUGH MENU SETTINGS UNTIL EXIT IS ENTERED
        opening();
        menu();
        tries++;

        while (!exit) {
            menu();
            tries++;
        }

        // ENDING SCREEN
        System.out.println("\n**************************************************\n" +
                "THANK YOU FOR PLAYING!!!\n" +
                "**************************************************");
    }
}