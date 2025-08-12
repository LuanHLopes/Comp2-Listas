package lista4;
import java.util.concurrent.atomic.AtomicInteger;

class Ex4 extends Thread {
    private static final int LIMITE_GOLS = 500;
    private static final int LIMITE_TOQUES = 5;
    private static final int LIMITE_TOQUES_ALTERNADOS = 3;

    private static final Object travaBola = new Object();
    private static AtomicInteger golsTimeA = new AtomicInteger(0);
    private static AtomicInteger golsTimeB = new AtomicInteger(0);

    private String nome;
    private char time;
    private int toquesConsecutivos;
    private boolean toquesAlternados;

    public Ex4(String nome, char time) {
        this.nome = nome;
        this.time = time;
        this.toquesConsecutivos = 0;
        this.toquesAlternados = false;
    }

    private void marcarGol() {
        if (time == 'A') {
            golsTimeA.incrementAndGet();
        } else {
            golsTimeB.incrementAndGet();
        }

        System.out.println("GOOOOL! " + golsTimeA.get() + " - " + golsTimeB.get() +
                " (" + (toquesAlternados ? "Tabelinha" : "5 toques") + ")");
    }

    private boolean atingiuLimiteGols() {
        int golsA = golsTimeA.get();
        int golsB = golsTimeB.get();
        return Math.abs(golsA - golsB) >= LIMITE_GOLS && (golsA > LIMITE_GOLS || golsB > LIMITE_GOLS);
    }

    private void jogar() {
        while (!atingiuLimiteGols()) {
            synchronized (travaBola) {
                if (toquesAlternados) {
                    toquesConsecutivos++;
                    if (toquesConsecutivos == LIMITE_TOQUES_ALTERNADOS) {
                        marcarGol();
                        toquesConsecutivos = 0;
                        toquesAlternados = false;
                        travaBola.notifyAll();
                    }
                } else {
                    toquesConsecutivos++;
                    if (toquesConsecutivos == LIMITE_TOQUES) {
                        marcarGol();
                        toquesConsecutivos = 0;
                        toquesAlternados = true;
                        travaBola.notifyAll();
                    }
                }
            }

            try {
                sleep(500); // Simulando um intervalo entre os toques
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        jogar();
    }

    public static void main(String[] args) {
        Ex4[] amigos = {
                new Ex4("Joaozinho", 'A'),
                new Ex4("Amigo2", 'B'),
                new Ex4("Amigo3", 'A'),
                new Ex4("Amigo4", 'B'),
                new Ex4("Amigo5", 'A'),
                new Ex4("Amigo6", 'B'),
                new Ex4("Amigo7", 'A'),
                new Ex4("Amigo8", 'B'),
                new Ex4("Amigo9", 'A'),
                new Ex4("Amigo10", 'B'),

        };

        for (Ex4 amigo : amigos) {
            amigo.start();
        }

        for (Ex4 amigo : amigos) {
            try {
                amigo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
