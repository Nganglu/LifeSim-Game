package com.bqtn.controllers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bqtn.characters.Character;
import com.bqtn.characters.CharacterState;

import java.io.*;

public class CombatController {
    private Character instigator;
    private Character opponent;

    private List<Character> turnOrder;
    private int currentTurn;

    private int round;
    private boolean isOver;

    public CombatController(Character intigator,Character opponent){
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

    // public void startConsoleCombat() {
    //     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //     System.out.println("\n============\n"+
    //                         this.instigator.getName()+" vs "+this.opponent.getName()+
    //                         "\n============");
    //     do{
    //         Character currentFighter = this.getCurrentFighter();
    //         System.out.println("Round "+this.round+"  |  Turn: "+currentFighter.getName());

    //         System.out.println("Attacking "+this.getOpponent().getName()+"...");
            

    //     }while (this.instigator.getState() != CharacterState.UNCONSCIOUS || this.opponent.getState() != CharacterState.UNCONSCIOUS);

    // }

    public Character getCurrentFighter(){
        return this.turnOrder.get(this.currentTurn);
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

    public Character getOpponent(){
        Character currentFighter = getCurrentFighter();
        if (currentFighter == this.instigator){
            return this.opponent;
        }
        return this.instigator;
    }

}