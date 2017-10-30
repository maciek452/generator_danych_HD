package main.java;

import java.util.Random;

/**
 * Created by Maciek on 30.10.2017.
 */
public class TestResultsGenerator {

    private static Random random;

    public TestResultsGenerator() {
        random = new Random();
    }

    public int nextResult(double middle){
        Double result = middle + random.nextGaussian()*15;
        return result.intValue() <= 100 ? result.intValue() : 100;
    }
}
