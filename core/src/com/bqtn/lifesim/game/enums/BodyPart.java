package com.bqtn.lifesim.game.enums;

public enum BodyPart {
    Head("Head"),
    TORSO("Torso"),
    R_ARM("Right Arm"),
    L_ARM("Left Arm"),
    R_HAND("Right Hand"),
    L_HAND("Left Hand"),
    BOTH_HANDS("Both Hands"),
    R_LEG("Right Leg"),
    L_LEG("Left Leg"),
    R_FOOT("Right Foot"),
    L_FOOT("Left Foot");

    private final String partName;

    BodyPart(String partName){
        this.partName = partName;
    }

    public String toString() {
        return partName;
    }
}