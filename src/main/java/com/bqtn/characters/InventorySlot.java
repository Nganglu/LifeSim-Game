package com.bqtn.characters;

public enum InventorySlot {
    TORSO("Torso"),
    LEGS("Legs"),
    HEAD("Head"),
    FACE("Face"),
    FEET("Feet"),
    GLOVES("Gloves"),
    R_HAND("Right Hand"),
    L_HAND("Left Hand"),
    BOTH_HANDS("Both Hands"),
    WAIST("Waist"),
    BACKPACK("Backpack");

    private final String slotName;

    InventorySlot(String slotName){
        this.slotName = slotName;
    }

    public String getName() {
        return slotName;
    }
}
