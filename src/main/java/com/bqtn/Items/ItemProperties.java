package com.bqtn.Items;

import java.util.List;

import com.bqtn.Characters.Character;
import com.bqtn.Characters.InventorySlot;

public interface ItemProperties {

    // public interface Consumable {
    //     int getFreshness();
    //     boolean isPerishable();
        
    //     void onConsumption(Character character);
    // }

    public interface Wearable {
        InventorySlot getWearableSlot();
        int getThickness();
        int getInsulation();
        boolean isCurrentlyWorn();
    }

    public interface Container {
        boolean isNested();
        List<Item> getContent();
        
        int getCapacityLeft();
        int getCapacityMax();
        int getBaseWeight();
        int getTotalWeight();

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