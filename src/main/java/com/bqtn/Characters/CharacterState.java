package com.bqtn.Characters;

public enum CharacterState{
    IDLE {
        @Override
        public void performAction(Character character){

        }
    };
    // WORKING,
    // MOVING,
    // RELAXING,
    // SLEEPING,

    public abstract void performAction(Character character);
}