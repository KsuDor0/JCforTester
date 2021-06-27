package lesson4;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main {

    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {

        firstArr();
        secondArr();

    }

    public static void firstArr() {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1);
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Первый метод, время заполнения по формуле - " + (System.currentTimeMillis() - a));

    }

    public static void secondArr() {
        float[] arr = new float[SIZE];
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];

        Arrays.fill(arr, 1);

        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        System.out.println("Второй метод, время разбивки на два массива - " + (System.currentTimeMillis() - a));

        Thread t1 = new Thread(() -> {
            long b = System.currentTimeMillis();

                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

            System.out.println("Второй метод, время заполнения первого массива - " + (System.currentTimeMillis() - b));
        });


        Thread t2 = new Thread(() -> {
            long b = System.currentTimeMillis();

                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

            System.out.println("Второй метод, время заполнения второго массива - " + (System.currentTimeMillis() - b));
        });
        long c = System.currentTimeMillis();
        t1.start();
        t2.start();

        while (true) {
            if (!t1.isAlive() && !t2.isAlive()) {
                System.out.println("Второй метод, два потока отработали за время - " + (System.currentTimeMillis() - c));
                break;
            }
        }

        a = System.currentTimeMillis();
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);

        System.out.println("Второй метод, время склейки двух массивов - " + (System.currentTimeMillis() - a));

    }

}