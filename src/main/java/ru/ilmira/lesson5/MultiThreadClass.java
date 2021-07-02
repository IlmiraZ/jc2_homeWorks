package ru.ilmira.lesson5;

import java.util.stream.IntStream;

public class MultiThreadClass {
    private static final int SIZE = 10000000;
    private static final int HALF_SIZE = SIZE / 2;
    private static final float[] ARRAY = new float[SIZE];

    public static void main(String[] args) {
        startOneThread();
        startTwoThreads();
    }

    public static void calculate(int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex; i++) {
            ARRAY[i] = (float) (ARRAY[i] * Math.sin(0.2f + i / 5.0 * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0)));
        }
    }

    public static void startOneThread() {
        IntStream.range(0, ARRAY.length).forEach(i -> ARRAY[i] = 1.0f); // или Arrays.fill(ARRAY, 1.0f);
        long a1 = System.currentTimeMillis();
        calculate(0, ARRAY.length);
        System.out.println("Время работы однопоточной обработки: " + (System.currentTimeMillis() - a1));
    }

    public static void startTwoThreads() {
        IntStream.range(0, ARRAY.length).forEach(i -> ARRAY[i] = 1.0f); // или Arrays.fill(ARRAY, 1.0f);
        long a2 = System.currentTimeMillis();

        Thread thread = new Thread(() -> calculate(0, HALF_SIZE));
        thread.start();

        calculate(HALF_SIZE, ARRAY.length);

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Время работы многопоточной обработки: " + (System.currentTimeMillis() - a2));
    }
}

