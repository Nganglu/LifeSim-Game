package com.bqtn.Items;

import java.util.ArrayList;

import com.bqtn.Characters.Character;

public interface ItemProperties {

    public interface Consumable {
        int getFreshness();
        boolean isPerishable();
        
        void onConsumption(Character character);
    }

    public interface Wearable {
        int getThickness();
        int getInsulation();
        boolean isCurrentlyWorn();
    }

    public interface Container {
        int getCapacity();
        boolean isNested();
        
        ArrayList<Item> getContent();
        int getTotalWeight();
    }

    public interface Furniture {
        boolean isFixed();
    }

    public interface Weapon {
        int getBaseDamage();
        boolean canBlock();
    }
    
    public interface Vehicle {
        int getMaxSpeed();
        boolean isMotorized();
    }
}