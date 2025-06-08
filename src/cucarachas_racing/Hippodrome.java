package cucarachas_racing;

import cucarachas_racing.participant.Cucaracha;

import java.util.Scanner;

public class Hippodrome {
    public static void main(String[] args) throws InterruptedException {

        // Setting participants and rounds amount
        System.out.print("Set amount of participant: ");
        int participant = menu(2);
        System.out.print("Set amount of rounds: ");
        int rounds = menu(1);

        // Announcing the start of the race
        System.out.println("Participants: " + participant + ", Rounds: " + rounds);
        System.out.println("Starting the race!\n");

        // Starting the race
        Cucaracha[] participants = new Cucaracha[participant];
        for (int i = 0; i < participants.length; i++) {
            participants[i] = new Cucaracha((i + 1), rounds);
            participants[i].start();
        }

        // Winner catcher
        int winner = 0;
        while (winner < 1) {
            for (Cucaracha c : participants) {
                if (!c.isAlive()) {
                    winner = c.getNr();
                    break;
                }
            }
        }

        // Waiting all participants to finish
        for (Cucaracha c : participants) {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Winner announcement
        System.out.println("\n*********************************************");
        System.out.println("*** Congratulations to Cucaracho Nr. " + winner + "!!! ***");
    }

    public static int menu(int minValue) {
        Scanner scanner = new Scanner(System.in);
        int result;
        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if (result >= minValue) {
                    break;
                } else {
                    System.out.printf("Not less than %d! ", minValue);
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }
        return result;
    }
}
