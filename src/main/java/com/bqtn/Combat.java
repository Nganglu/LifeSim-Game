package com.bqtn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bqtn.Characters.Character;

public class Combat {
    private List<Character> instigators;
    private List<Character> opponents;

    private List<Character> turnOrder;
    private int currentTurn;

    private boolean isOver;

    public Combat(List<Character> intigators,List<Character> opponents){
        this.instigators = new ArrayList<>(intigators);
        this.opponents = new ArrayList<>(opponents);
        this.turnOrder = new ArrayList<>();
        this.updateInitiative();
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

}
