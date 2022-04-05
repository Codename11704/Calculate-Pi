package me.Sean.CalcPi;

import java.util.Random;

public class Main extends Thread {

    public volatile static double percentDone = 0;
    public static volatile boolean flag = true;

    public static boolean isOnLine(int a, int b) {
        while(b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a != 1;
    }


    public static void main(String[] args) {
        final double trials = 2147483647;
        int coprime = 0;

        Counter thread = new Counter();
        thread.start();

        for(int i = 0; i < trials; i++) {
            percentDone = ((double)i/trials);
            Random rng = new Random();

            int num1 = rng.nextInt(2147483647 - 3) + 2;
            int num2 = rng.nextInt(2147483647 - 3) + 2;

            if(!isOnLine(num1, num2)) coprime++;

        }

        flag = false;
        double probability = (double)coprime/trials;
        double pi = Math.sqrt((double)6/probability);
        System.out.println(pi);

    }
}
