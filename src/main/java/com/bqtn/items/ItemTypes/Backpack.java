package com.bqtn.items.ItemTypes;
import java.util.List;
import java.util.ArrayList;

import com.bqtn.characters.InventorySlot;
import com.bqtn.items.Item;
import com.bqtn.items.ItemProperties.*;

public class Backpack extends Item implements Container, Wearable {

    private int maxCapacity;
    private int baseWeight;
    
    private List<Item> content;
    private int contentValue;
    
    private boolean isNested;
    private boolean isBeingWorn;

    public Backpack(String name, String description, int weight, int baseVolume,int maxCapacity,int baseValue) {
        super(name,description,weight,baseVolume,baseValue);
        this.content = new ArrayList<>();
        this.maxCapacity = maxCapacity;
        this.baseWeight = weight;
        this.isNested = false;
    }

    public String toString(){
        return "Name: "+this.getName()+"  Description: "+this.getDescription()+"\n"+
                "Content Weight: "+this.weight+"g\n"+
                "Volume: "+this.getContentVolume()+"/"+this.maxCapacity+"ml";
    }
    
    @Override
    public boolean isNested() {
        return this.isNested;
    }

    @Override
    public List<Item> getContent() {
        return this.content;
    }

    @Override
    public int getContentValue(){
        int contentValue = 0;
        for (Item item : content) {
            contentValue += item.getBaseValue();
        }
        return contentValue;
    }

    public int getTotalValue(){
        return this.getContentValue() + this.getBaseValue();
    }

    @Override
    public int getBaseWeight() {
        return this.baseWeight;
    }

    @Override
    public int getTotalWeight() {
        return this.getTotalWeight();
    }

    @Override
    public int getCapacityMax() {
        return this.maxCapacity;
    }

    @Override
    public boolean isBeingWorn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCurrentlyWorn'");
    }

    @Override
    public InventorySlot getWearableSlot() {
        return InventorySlot.BACKPACK;
    }

    @Override
    public void setIsBeingWorn(){
        this.isBeingWorn = true;
    }

    public void unsetIsBeingWorn(){
        this.isBeingWorn = false;
    }

}