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

    static final InventorySlot wearableSlot = InventorySlot.BACKPACK;

    public Backpack(String name, String description, int weight, int baseVolume,int maxCapacity) {
        super(name, description, weight, baseVolume);
        this.content = new ArrayList<>();
        this.maxCapacity = maxCapacity;
        this.baseWeight = weight;
        this.isNested = false;
    }

    public String toString(){
        return "Name: "+this.getName()+"  Description: "+this.getDescription()+"\n"+
                "Items: "+this.weight+"g / Total: "+(this.weight+this.baseWeight)+"g\n"+
                "Volume: "+this.getContentVolume()+"/"+this.maxCapacity;
    }

    public void addItem(Item item) {
        if (!this.isNested){

            if (item.getVolume() <= this.maxCapacity - this.volume){
                this.content.add(item);
                this.volume += item.getVolume();
                this.weight += item.getWeight();
            }else{
                System.out.println("Item can't fit.");
            }
        } else {
            System.out.println("Item is nested. Remove from container first.");
        }
    }
    
    public void removeItem(Item item) {
        if (!this.isNested){

            if (this.content.contains(item)){
                this.content.remove(item);
                this.volume -= item.getVolume();
                this.weight -= item.getWeight();
            } else {
                System.out.println("No item to remove.\n");
            }
        } else {
            System.out.println("Item is nested. Remove from container first.\n");
        }
    }

    public int getContentVolume(){
        int volume = 0;
        for (Item item : this.content) {
            volume += item.getVolume();
        }
        return volume;
    }

    public int getContentWeight(){
        int weight = 0;
        for (Item item : this.content) {
            weight += item.getWeight();
        }
        return weight;
    }
    
    @Override
    public boolean isNested() {
        return this.isNested;
    }

    @Override
    public List<Item> getContent() {
        return new ArrayList<>(this.content);
    }
    
    @Override
    public int getCapacityLeft() {
        return this.maxCapacity - getContentVolume();
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
    public int getThickness() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getThickness'");
    }

    @Override
    public int getInsulation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInsulation'");
    }

    @Override
    public boolean isCurrentlyWorn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isCurrentlyWorn'");
    }

    @Override
    public InventorySlot getWearableSlot() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWearableSlot'");
    }





}