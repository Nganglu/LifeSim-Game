package com.bqtn.Items.ItemTypes;
import java.util.List;
import java.util.ArrayList;

import com.bqtn.Characters.InventorySlot;
import com.bqtn.Items.Item;
import com.bqtn.Items.ItemProperties.*;

public class Backpack extends Item implements Container, Wearable {

    private int maxCapacity;
    private int baseWeight;
    
    private List<Item> content;
    
    private boolean isNested;
    private boolean isCurrentlyWorn;

    public Backpack(String name, String description, int weight, int baseVolume,int maxCapacity) {
        super(name, description, weight, baseVolume);
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
    public boolean isCurrentlyWorn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCurrentlyWorn'");
    }

    @Override
    public InventorySlot getWearableSlot() {
        return InventorySlot.BACKPACK;
    }

    @Override
    public void setIsCurrentlyWorn(){
        this.isCurrentlyWorn = true;
    }

    public void unsetIsCurrentlyWorn(){
        this.isCurrentlyWorn = false;
    }

}