package com.bqtn.items;

import java.util.List;

import com.bqtn.characters.InventorySlot;

public interface ItemProperties {

    // public interface Consumable {
    //     int getFreshness();
    //     boolean isPerishable();
    //     LocalDate getExpirationDate();
    // }

    public interface Wearable {
        InventorySlot getWearableSlot();
        // int getThickness();
        // int getInsulation();
        boolean isBeingWorn();
        void setIsBeingWorn();
        void unsetIsBeingWorn();
    }

    public interface Equipable {
        InventorySlot getEquipableSlot();
        InventorySlot getEquipedSlot();
    }

    public interface Container {
        boolean isNested();
        List<Item> getContent();
        int getBaseWeight();
        
        int getCapacityMax();
        int getTotalWeight();
        
        int getVolume();
        void setVolume(int volume);
        int getWeight();
        void setWeight(int weight);
        
        default int getCapacityLeft() {
            return getCapacityMax() - getContentVolume();
        }

        default void addItem(Item item) {
            if (!this.isNested()){
    
                if (item.getVolume() <= this.getCapacityLeft()){
                    this.getContent().add(item);
                    this.setVolume(this.getVolume()+item.getVolume());
                    this.setWeight(this.getWeight()+item.getWeight());
                }else{
                    System.out.println("Item can't fit.");
                }
            } else {
                System.out.println("Item is nested. Remove from container first.");
            }
        }

        default void removeItem(Item item) {
            if (!this.isNested()){
    
                if (this.getContent().contains(item)){
                    this.getContent().remove(item);
                    this.setVolume(this.getVolume()-item.getVolume());
                    this.setWeight(this.getWeight()-item.getWeight());
                } else {
                    System.out.println("No item to remove.\n");
                }
            } else {
                System.out.println("Item is nested. Remove from container first.\n");
            }
        }

        default int getContentVolume(){
            int volume = 0;
            for (Item item : this.getContent()) {
                volume += item.getVolume();
            }
            return volume;
        }
    
        default int getContentWeight(){
            int weight = 0;
            for (Item item : this.getContent()) {
                weight += item.getWeight();
            }
            return weight;
        }
    }

    // public interface Furniture {
    //     boolean isFixed();
    // }

    // public interface Weapon {
    //     int getBaseDamage();
    //     boolean canBlock();
    // }
    
    // public interface Vehicle {
    //     int getMaxSpeed();
    //     boolean isMotorized();
    // }
}