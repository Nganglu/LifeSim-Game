package com.bqtn.lifesim.game.components;

public class Measurements implements Component {
    int height; // in cm
    int weight; // in grams

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
