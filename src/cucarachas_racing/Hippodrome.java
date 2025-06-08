package cucarachas_racing;

import cucarachas_racing.participant.Cucaracha;

import java.util.Scanner;

public class Hippodrome {
    public static void main(String[] args) {

        System.out.print("Set amount of participant: ");
        int participant = menu(2);
        System.out.print("Set amount of rounds: ");
        int rounds = menu(1);


        System.out.println("Participants: " + participant + ", Rounds: " + rounds);
        System.out.println("Starting the race!\n");

        Cucaracha[] participants = new Cucaracha[participant];
        for (int i = 0; i < participants.length; i++) {
            participants[i] = new Cucaracha((i + 1), rounds);
            participants[i].start();
        }

        boolean winnerDeclared = false;
        while (!winnerDeclared) {
            for (Cucaracha c : participants) {
                if (!c.isAlive()) {
                    System.out.println("Congratulations to Cucaracho Nr. " + c.getNr() + " finished first!");
                    winnerDeclared = true;
                    break;
                }
            }
        }
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
