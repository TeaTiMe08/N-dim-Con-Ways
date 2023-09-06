package de.teatime08;

import de.teatime08.shapes.D2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AGamePerformanceTest2D {

    private static final int timeout = 3000;

    boolean runPerformance = true;
    int runs = 0;

    @BeforeEach
    void setUp() {
        runPerformance =true;
        runs = 0;
    }

    @Test
    public void performanceMinimal() throws InterruptedException {
        Game game = new Game(D2.BLINKER);
        game.print();
        int numInitElements = game.getCells().size();
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < timeout) {
            game.next();
            runs++;
        }
        time = System.currentTimeMillis() - time;
        runPerformance = false;
        int numElementsEnd = game.getCells().size();
        System.out.println("-".repeat(50));
        game.print();
        System.out.println("For " + numInitElements + " Elements begin, and " + numElementsEnd + " finished:");
        System.out.println(runs + " runs in " + time);
    }

    @Test
    public void performanceSingle() throws InterruptedException {
        Game game = new Game(D2.ACHIMS_P11);
        game.print();
        int numInitElements = game.getCells().size();
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < timeout) {
            game.next();
            runs++;
        }
        time = System.currentTimeMillis() - time;
        runPerformance = false;
        int numElementsEnd = game.getCells().size();
        System.out.println("-".repeat(50));
        game.print();
        System.out.println("For " + numInitElements + " Elements begin, and " + numElementsEnd + " finished:");
        System.out.println(runs + " runs in " + time);
    }

    @Test
    public void performanceMulti() throws InterruptedException {
        int measureMillies = 3000;
        Game game = new Game(D2.GLIDER)
            .decorateShape(Cell.move(D2.METHUSELAH_R_PENTOMINO, new int[]{50, 50}))
            .decorateShape(Cell.move(D2.PUFFER_TRAIN, new int[]{-50, -50}))
            .decorateShape(Cell.move(D2.PUFFER_TRAIN, new int[]{50, -50}))
            .decorateShape(Cell.move(D2.ACHIMS_P11, new int[]{-50, 50}))
            .decorateShape(Cell.move(D2.PULSAR, new int[]{-100, 50}))
            ;
        int numInitElements = game.getCells().size();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(measureMillies);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            runPerformance = false;
            int numElementsEnd = game.getCells().size();
            System.out.println("-".repeat(50));
            game.print();
            System.out.println("For " + numInitElements + " Elements begin, and " + numElementsEnd + " finished:");
            System.out.println(runs + " runs in " + measureMillies);
        });

        Thread t2 = new Thread(() -> {
            game.print();
            while (runPerformance){
                game.next();
                runs++;
            }
        });
        t1.start();
        t2.start();

        while (t1.isAlive() && t2.isAlive()) {
            Thread.sleep(150);
        }
    }

}