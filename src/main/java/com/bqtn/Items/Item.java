package com.bqtn.Items;

public class Item {
    private String name;
    private String description;
    protected int weight; // in grams
    protected int volume; // in ml or cm3
    private int condition;

    public Item(String name,String description,int weight,int volume){
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.volume = volume;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getVolume() {
        return this.volume;
    }

    public int getCondition() {
        return this.condition;
    }

    public boolean isContainer() {
        return this.isContainer();
    }
    
}
