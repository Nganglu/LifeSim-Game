package com.bqtn.utils;

import java.util.Random;

public class GameMaster {
    private Random random;

    // Luck
    private double stdDev = 14.8;
    private double mean = 62.5;

    public GameMaster(Random random) {
        this.random = random;
    }

    public int getNormalDistribution(double stdDev, double mean,int lowLimit,int highLimit){
        double number = this.random.nextGaussian() * stdDev + mean;
        if (number > highLimit) number = highLimit;
        if (number < lowLimit) number = lowLimit;
        return (int) number;
    }

    public int getRandomNumber(){
        return getNormalDistribution(this.stdDev, this.mean, 1, 100);
    }

}
