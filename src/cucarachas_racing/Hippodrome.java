package cucarachas_racing;

import cucarachas_racing.participant.Cucaracha;

import java.util.Scanner;

public class Hippodrome {
    public static void main(String[] args) {
        Integer[] values = new Integer[2];
        menu(values);
        int participant = values[0];
        int rounds = values[1];

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

    public static Integer[] menu(Integer[] values) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Set amount of participant: ");
        while (true) {
            if (scanner.hasNextInt()) {
                values[0] = scanner.nextInt();
                if (values[0] >= 2) {
                    break;
                } else {
                    System.out.println("Not less than 2!");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }

        System.out.print("Set amount of rounds: ");
        while (true) {
            if (scanner.hasNextInt()) {
                values[1] = scanner.nextInt();
                if (values[1] >= 1) {
                    break;
                } else {
                    System.out.println("Set at least 1!");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
            }
        }

        scanner.close();
        return values;
    }

}
