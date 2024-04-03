package com.bqtn.items;

import com.bqtn.characters.InventorySlot;

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

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVolume() {
        return this.volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCondition() {
        return this.condition;
    }

    public boolean isContainer() {
        return this.isContainer();
    }

    public InventorySlot getWearableSlot(){
        return null;
    }

    public void setIsBeingWorn(){
        System.out.println("Item is not wearable");
    }

    public void unsetIsBeingWorn(){
        System.out.println("Item is not wearable");
    }
    
}
