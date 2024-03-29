package com.bqtn.Items;

public class BaseItem implements Item {
    private String name;
    private String description;
    private int weight;
    private int volume;
    private int condition;

    public BaseItem(String name,String description,int weight,int volume){
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.volume = volume;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }

    @Override
    public int getCondition() {
        return this.condition;
    }
    
}
