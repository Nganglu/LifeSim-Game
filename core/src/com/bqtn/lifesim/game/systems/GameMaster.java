package com.bqtn.lifesim.game.systems;

import java.util.concurrent.atomic.AtomicLong;

public class GameMaster {
    private AtomicLong seed;

    private final double stdDev = 14.8;
    private final double mean = 47.5;

    public void init(){
        this.seed = new AtomicLong(System.currentTimeMillis());
    }

    public void init(AtomicLong seed){
        this.seed = seed;
    }

    public long nextLong() {
        long x = seed.getAndIncrement();
        long y = seed.get();
        seed.set(y);
        x ^= x << 23;
        seed.set((x ^ y ^ (x >> 17) ^ (y >> 26)) + y);
        return seed.get();
    }

    public int nextInt() {
        return (int) nextLong();
    }

    public int nextIntInRange(int min, int max) {
        long range = (long) max - min + 1;
        long randomNumber = (nextLong() & Long.MAX_VALUE) % range;
        return (int) (randomNumber + min);
    }

    public double nextDouble() {
        return (double) nextLong() / Long.MAX_VALUE;
    }

    public double nextGaussian(double mean, double stdDev) {
        double u1,u2,z0;
        do {
         u1 = nextDouble();
         u2 = nextDouble();
         z0 = Math.sqrt(-2.0 * Math.log(u1)) * Math.cos(2.0 * Math.PI * u2);
        } while (Double.isNaN(z0));
        return mean + z0 * stdDev;
    }

    public int getNormalDistribution(double stdDev, double mean,int lowLimit,int highLimit){
        double number = nextGaussian(mean,stdDev);
        if (number > highLimit) number = highLimit;
        if (number < lowLimit) number = lowLimit;
        return (int) number;
    }

    public int nextRoll(){
        return getNormalDistribution(this.stdDev,this.mean,0,100);
    }
}
