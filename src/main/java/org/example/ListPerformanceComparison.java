package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The ListPerformanceComparison class compares the performance of ArrayList and LinkedList
 * for various operations such as add, get, and remove.
 */
public class ListPerformanceComparison {

    /**
     * The main method initializes ArrayList and LinkedList, measures the time for various operations,
     * and prints the results in a formatted table.
     *
     * @param args The command line arguments (not used).
     */
    public static void main(String[] args) {
        int numberOfOperations = 10000; // Set the desired number of operations

        // Create ArrayList and LinkedList
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Build a table for results
        StringBuilder table = new StringBuilder();
        table.append(String.format("%-20s %-20s %-20s%n", "Method", "Number of Operations", "Execution Time (ns)"));

        // Measure time for add operations in ArrayList
        measureTime(table, "ArrayList - Add", numberOfOperations, () -> {
            for (int i = 0; i < numberOfOperations; i++) {
                arrayList.add(i);
            }
        });

        // Measure time for add operations in LinkedList
        measureTime(table, "LinkedList - Add", numberOfOperations, () -> {
            for (int i = 0; i < numberOfOperations; i++) {
                linkedList.add(i);
            }
        });

        // Measure time for get operations in ArrayList
        measureTime(table, "ArrayList - Get", numberOfOperations, () -> {
            for (int i = 0; i < numberOfOperations; i++) {
                arrayList.get(i);
            }
        });

        // Measure time for get operations in LinkedList
        measureTime(table, "LinkedList - Get", numberOfOperations, () -> {
            for (int i = 0; i < numberOfOperations; i++) {
                linkedList.get(i);
            }
        });

        // Measure time for remove operations in ArrayList
        measureTime(table, "ArrayList - Remove", numberOfOperations, () -> {
            for (int i = 0; i < numberOfOperations; i++) {
                arrayList.remove(arrayList.size() - 1);
            }
        });

        // Measure time for remove operations in LinkedList
        measureTime(table, "LinkedList - Remove", numberOfOperations, () -> {
            for (int i = 0; i < numberOfOperations; i++) {
                linkedList.remove(linkedList.size() - 1);
            }
        });

        // Print the results table
        System.out.println(table.toString());
    }

    /**
     * Measures the execution time of a given code block and appends the results to the table.
     *
     * @param table             The StringBuilder representing the results table.
     * @param operation         The name of the operation being measured.
     * @param numberOfOperations The number of operations performed.
     * @param code              The code block to be executed.
     */
    private static void measureTime(StringBuilder table, String operation, int numberOfOperations, Runnable code) {
        long startTime = System.nanoTime();
        code.run();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        table.append(String.format("%-20s %-20s %-20s%n", operation, numberOfOperations, duration));
    }
}
