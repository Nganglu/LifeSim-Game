package com.bqtn.items;

import com.bqtn.characters.InventorySlot;

public class Item {
    private String name;
    private String description;
    protected int weight; // in grams
    protected int volume; // in ml or cm3
    private int condition;

    private int baseValue;

    public Item(String name,String description,int weight,int volume,int baseValue){
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.volume = volume;
        this.baseValue = baseValue;
    }

    public String getName() {
        return this.name+
                "\n\""+this.description+"\""+
                "\nWeight: "+this.weight/1000+"kg  |  "+this.volume+"ml"+
                "\nCondition: "+this.condition;
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

    public void getCondition(int condition) {
        this.condition = condition;
    }

    public int getBaseValue() {
        return this.baseValue;
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

    public boolean canWearOnSlot(InventorySlot slot){
        switch (slot.toString().toLowerCase()) {
            case "right hand":
            case "left hand":
            case "both hands":
                return true;
            default:
                return false;
        }
    }
    
}
