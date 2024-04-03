package com.bqtn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bqtn.Characters.Character;
import com.bqtn.Characters.CharacterState;

public class Combat {
    private Character instigator;
    private Character opponent;

    private List<Character> turnOrder;
    private int currentTurn;

    private int round;
    private boolean isOver;

    public Combat(Character intigator,Character opponent){
        this.instigator = intigator;
        this.opponent = opponent;
        this.turnOrder = new ArrayList<>();
        this.updateInitiative();
        this.currentTurn = 0;
        this.round = 1;
    }

    private void updateInitiative(){
        Collections.sort(this.turnOrder, (char1, char2) -> {

            int speedComparison = Double.compare(char1.getBaseSpeed(), char2.getBaseSpeed());
            if (speedComparison == 0) {

                int dexComparison = Double.compare(char1.getDexterity(), char2.getDexterity());
                if (dexComparison == 0) {
                    return char1.getLastName().compareTo(char2.getLastName());
                }
                return dexComparison;
            }
            return speedComparison;
        });
    }

    public List<Character> getTurnOrderList(){
        return this.turnOrder;
    }

    public void nextTurn(){
        this.currentTurn++;
        if (this.currentTurn >= this.turnOrder.size()) {
            this.currentTurn = 0;
            this.round++;
        }
    }

    public CharacterState getCurrentFighterState(){
        return this.turnOrder.get(this.currentTurn).getState();
    }

}