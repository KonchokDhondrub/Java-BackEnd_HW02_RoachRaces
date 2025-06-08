package cucarachas_racing.participant;

import java.util.concurrent.ThreadLocalRandom;

public class Cucaracha extends Thread {
    private final int nr;
    private final int rounds;

    public Cucaracha(int nr, int rounds) {
        this.nr = nr;
        this.rounds = rounds;
    }

    public int getNr() {
        return nr;
    }

    @Override
    public void run() {
        System.out.println("Cucoracho Nr: " + nr + " started the race!");
        for (int i = 0; i < rounds; i++) {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(2, 6));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Nr: " + nr + " finished lap: " + (i + 1));
        }
        System.out.println("======== Nr: " + nr + " FINISHED! ========");
    }
}