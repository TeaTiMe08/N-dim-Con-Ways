package de.teatime08;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public interface Banq {
    /**
     * For each method assigned to the @Banq Annotations, define a List of measures stored in this HashMap.
     */
    final Map<String, LinkedList<BanqTick>> banqMeasures = new HashMap<>();

    /**
     * A BanqTick is a wrapper for a measure of ticks made with Banq.
     * @param count The recent number of the tick (identifier)
     * @param tickDate The LocalDateTime of the Tick, after method was executed
     * @param benchNanoTime The performance measure in nano-seconds. How long the method needed to execute.
     */
    public record BanqTick(int count, LocalDateTime tickDate, Long benchNanoTime){
        @Override
        public String toString() {
            return "BanqTick{" + "count=" + count + ", tickDate=" + tickDate +", benchNanoTime=" + benchNanoTime + '}';
        }
    }

    /**
     * Stores a measurement for execution time.
     * @param key the key to search for in the measurements
     * @param exectimeNanos the nanoseconds the execution took
     */
    public default void banq(String key, Long exectimeNanos) {
        LinkedList<BanqTick> keyTimes = banqMeasures.get(key);
        if (keyTimes == null) {
            keyTimes = new LinkedList<>();
            banqMeasures.put(key, keyTimes);
        }

        BanqTick tick = new BanqTick(banqMeasures.size(), LocalDateTime.now(), exectimeNanos);
        keyTimes.add(tick);
    }

    /**
     * @return Gets the current stored Measures.
     */
    public default Map<String, LinkedList<BanqTick>> getBanqMeasures() {
        return banqMeasures;
    }

    /**
     * Prints all the measures to a big String, implemented for logging etc. Unix Line seperator.
     * @return A big string for all measures made.
     */
    public default String printToString() {
        StringBuilder sb = new StringBuilder();
        banqMeasures.forEach((x, y) -> {
            y.forEach(z -> sb.append(String.format("%-40s", x) + z.toString() + "\n"));
        });
        return sb.toString();
    }

    public default void printMedians() {
        Set<String> unordered = new HashSet<>();
        banqMeasures.forEach((x, y) -> unordered.add(
            String.format("%-20s", x) + "| " +
                calculateMedian(y.stream().map(BanqTick::benchNanoTime).collect(Collectors.toList())) / 1_000_000 //milliseconds
        ));
        unordered.stream().sorted().forEach(System.out::println);
    }

    /**
     * Calculates the median value for a given key
     * @param key the key to search for in the measurements
     * @return the median value of bench times
     */
    public default double median(String key) {
        return calculateMedian(banqMeasures.get(key).stream().map(x -> x.benchNanoTime).collect(Collectors.toList()));
    }

    public static double calculateMedian(List<Long> measurements) {
        if (measurements.isEmpty()) {
            return 0.0; // Handle the case of an empty list as appropriate for your use case.
        }

        Collections.sort(measurements);

        int middle = measurements.size() / 2;
        if (measurements.size() % 2 == 0) {
            // If even number of elements, take the average of the two middle values
            double middle1 = measurements.get(middle - 1);
            double middle2 = measurements.get(middle);
            return (middle1 + middle2) / 2.0;
        } else {
            // If odd number of elements, return the middle value
            return measurements.get(middle);
        }
    }

    /**
     * Represents a boxplot.
     * @param min total minimum value of the boxplot
     * @param max total maximum value of the boxplot
     * @param median the median of all values
     * @param qLow the 25 percentile
     * @param qHigh the 75 percentile
     */
    public record BoxPlot(double min, double max, double median, double qLow, double qHigh){
        @Override
        public String toString() {
            return "BoxPlot{" + "min=" + min + ", max=" + max + ", median=" + median +
                ", qLow=" + qLow + ", qHigh=" + qHigh + '}';
        }
    }

    /**
     * Creates a boxplot from the measurement values.
     * @param key the key to search for in the measurements
     * @return a boxplot
     */
    public default BoxPlot boxPlot(String key) {
        return createBoxPlot(banqMeasures.get(key).stream().map(x -> x.benchNanoTime).collect(Collectors.toList()));
    }

    public static BoxPlot createBoxPlot(List<Long> measurements) {
        Collections.sort(measurements);

        double min = measurements.get(0);
        double max = measurements.get(measurements.size() - 1);
        double median = calculateMedian(measurements);
        double q1 = calculatePercentile(measurements, 25);
        double q3 = calculatePercentile(measurements, 75);

        return new BoxPlot(min, max, median, q1, q3);
    }

    /**
     * Calculates the value for percentile of the measurements
     * @param key the key to search for in the measurements
     * @param percentile the percentile to be measured at
     * @return percentile
     */
    public default double percentile(String key, int percentile) {
        return calculatePercentile(
            banqMeasures.get(key).stream().map(x -> x.benchNanoTime).collect(Collectors.toList()),
            percentile
        );
    }

    public static double calculatePercentile(List<Long> measurements, int percentile) {
        if (measurements.isEmpty()) {
            return 0.0; // Handle the case of an empty list as appropriate for your use case.
        }

        Collections.sort(measurements);

        double position = (percentile / 100.0) * (measurements.size() + 1);
        int index = (int) position;
        double fraction = position - index;

        if (index == 0) {
            return measurements.get(0);
        } else if (index >= measurements.size()) {
            return measurements.get(measurements.size() - 1);
        } else {
            double lowerValue = measurements.get(index - 1);
            double upperValue = measurements.get(index);
            return lowerValue + fraction * (upperValue - lowerValue);
        }
    }
}
