package de.teatime08;

import de.teatime08.shapes.D3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AGamePerformanceTest3D {

    boolean runPerformance = true;
    int runs = 0;

    @BeforeEach
    void setUp() {
        runPerformance =true;
        runs = 0;
    }

    @Test
    public void performanceSingle() throws InterruptedException {
        int measureMillies = 3000;
        Game game = new Game(D3.TUMBLER);
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

    @Test
    public void performanceMulti() throws InterruptedException {
        int measureMillies = 3000;
        Game game = new Game(D3.GLIDER)
            //.decorateShape(Cell.move(D2.PUFFER_TRAIN, new int[]{-50, -50}))
            //.decorateShape(Cell.move(D2.PUFFER_TRAIN, new int[]{50, -50}))
            //.decorateShape(Cell.move(D2.ACHIMS_P11, new int[]{-50, 50}))
            //.decorateShape(Cell.move(D2.PULSAR, new int[]{-100, 50}))
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