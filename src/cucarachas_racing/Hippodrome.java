package cucarachas_racing;

import cucarachas_racing.participant.Cucaracha;

import java.util.Scanner;

public class Hippodrome {
    public static void main(String[] args) throws InterruptedException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Setting participants and rounds amount
        System.out.print("Set amount of participant: ");
        int participant = menu(2);
        System.out.print("Set amount of rounds: ");
        int rounds = menu(1);
        Cucaracha.setRounds(rounds);

        // Announcing the start of the race
        System.out.println("Participants: " + participant + ", Rounds: " + rounds);
        System.out.println("Starting the race!\n");

        // Starting the race
        Thread[] participants = startRace(participant);


        // Waiting all participants to finish
        waitingRaceEnd(participants);

        // Winner announcement
        System.out.println("\n******************************************");
        System.out.println("*** Congratulations to " + Cucaracha.getWinner() + "!!! ***");
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

    public static Thread[] startRace(int participant) {
        Thread[] threads = new Thread[participant];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Cucaracha("Cucaracho #" + (i + 1)));
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        return threads;
    }

    public static void waitingRaceEnd(Thread[] participants) {
        for (int i = 0; i < participants.length; i++) {
            try {
                participants[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
