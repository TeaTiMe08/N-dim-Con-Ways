package de.teatime08;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void pointsOfHyperSphere() {
    }

    @Test
    void generateMask() {
        // rad 1
        assertEquals(2, Cell.generateMask(1, 1).size());
        assertEquals(8, Cell.generateMask(2, 1).size());
        assertEquals(26, Cell.generateMask(3, 1).size());
        assertEquals(80, Cell.generateMask(4, 1).size());
        assertEquals(242, Cell.generateMask(5, 1).size());
        assertEquals(728, Cell.generateMask(6, 1).size());
        assertEquals(2186, Cell.generateMask(7, 1).size());
        Instant begin = Instant.now();
        assertEquals(6560, Cell.generateMask(8, 1).size());
        System.out.println("For 8 dimensional: " + Duration.between(begin, Instant.now()).toMillis() + "ms");
        begin = Instant.now();
        assertEquals(19682, Cell.generateMask(9, 1).size());
        System.out.println("For 9 dimensional: " + Duration.between(begin, Instant.now()).toMillis() + "ms");
        begin = Instant.now();
        assertEquals(59048, Cell.generateMask(10, 1).size());
        System.out.println("For 10 dimensional: " + Duration.between(begin, Instant.now()).toMillis() + "ms");
        begin = Instant.now();

        // rad 2
        assertEquals(2, Cell.generateMask(1, 2).size());
        assertEquals(16, Cell.generateMask(2, 2).size());
        assertEquals(98, Cell.generateMask(3, 2).size());

        // rad 3
        assertEquals(2, Cell.generateMask(1, 3).size());
        assertEquals(24, Cell.generateMask(2, 3).size());
        assertEquals(218, Cell.generateMask(3, 3).size());

        // rad 5 - test radius
        begin = Instant.now();
        System.out.println(Cell.generateMask(5, 4).size());
        System.out.println("For 6 dimensional with 4 radius: " + Duration.between(begin, Instant.now()).toMillis() + "ms");
        begin = Instant.now();
        System.out.println(Cell.generateMask(5, 8).size());
        System.out.println("For 5 dimensional with 8 radius: " + Duration.between(begin, Instant.now()).toMillis() + "ms");
        begin = Instant.now();
        System.out.println(Cell.generateMask(5, 10).size());
        System.out.println("For 5 dimensional with 10 radius: " + Duration.between(begin, Instant.now()).toMillis() + "ms");
        begin = Instant.now();
    }

}