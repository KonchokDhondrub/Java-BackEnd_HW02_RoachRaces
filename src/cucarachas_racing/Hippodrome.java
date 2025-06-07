package cucarachas_racing;

import cucarachas_racing.participant.Cucaracha;

public class Hippodrome {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Iteration amount & amount of a Participants are missed");
            return;
        }

        int rounds = Integer.parseInt(args[0]);
        int participant = Integer.parseInt(args[1]);

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
}
