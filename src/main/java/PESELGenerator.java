package main.java;

import java.util.Random;

/**
 * Created by Maciek on 30.10.2017.
 */
public class PESELGenerator {
    private static int[] codes = {21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    private static Random random;


    public PESELGenerator() {
        random = new Random();
    }

    public String nextPESEL(int year){
        String PESEL = Integer.toString(year).substring(2);
        PESEL+=Integer.toString(getRandom(codes));
        PESEL+=random.nextInt(3);
        for(int i = 0; i < 6; i++)
            PESEL+=random.nextInt(10);
        return PESEL;
    }

    private static int getRandom(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}
