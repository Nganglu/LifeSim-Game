package com.bqtn.characters;

public enum CharacterState {
    IDLE("Idle"),
    UNCONSCIOUS("Unconscious"),
    BUSY("Busy");

    private final String stateName;

    CharacterState(String stateName){
        this.stateName = stateName;
    }

    public String getName() {
        return stateName;
    }
}
