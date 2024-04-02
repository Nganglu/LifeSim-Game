package com.bqtn.Characters;

import java.text.DecimalFormat;

public class CharacterSheet {
    // Main Stats
    private int strength;
    private int dexterity;
    private int intelligence;
    private int health;

    // Derivated
    private int will;
    private int perception;
    private int maxHitPoints;
    private int maxFatigue;

    private double baseSpeed; // in meters/second
    private double baseLift; // in kg

    //Skill list separated by main stat?

    private static final DecimalFormat df = new DecimalFormat("0.00");

    protected CharacterSheet(int strength,int dexterity,int intelligence,int health) {
        this.setBaseStats(strength, dexterity, intelligence, health);
    }

    public String toString(){
        return "  ======== STATS ========"+
                "\nST "+this.strength+" | DX "+this.dexterity+" | IQ "+this.intelligence+" | HT "+this.health+
                "\nWill: "+this.will+"        Perception: "+this.perception+
                "\nSpeed: "+df.format(this.baseSpeed)+"m/s  Lift: "+df.format(this.baseLift)+"kg"+
                "\n  ------------------------"+
                "\n Max HP: "+this.maxHitPoints+"  Max Fatigue: "+this.maxFatigue+
                "\n  ========================";
    }

    protected void setBaseStats(int strength,int dexterity,int intelligence,int health) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.health = health;
        this.updateDerivatedStats();
    }

    protected void updateDerivatedStats(){
        this.maxHitPoints = this.strength;
        this.will = this.intelligence;
        this.perception = this.intelligence;
        this.maxFatigue = this.health;
        this.baseSpeed = 1.0 * (this.health + this.dexterity) / 4;
        this.baseLift = 1.0 * Math.pow(this.strength,2)/10;
    }

    protected int getStrength(){
        return this.strength;
    }
    protected void setStrength(int strength){
        this.strength = strength;
    }
    protected int getDexterity(){
        return this.dexterity;
    }
    protected void setDexterity(int dexterity){
        this.dexterity = dexterity;
    }
    protected int getIntelligence(){
        return this.intelligence;
    }
    protected void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
    protected int getHealth(){
        return this.health;
    }
    protected void setHealth(int health){
        this.health = health;
    }
    protected int getWill(){
        return this.will;
    }
    protected int getPerception(){
        return this.perception;
    }
    protected int getMaxFatigue(){
        return this.maxFatigue;
    }
    protected int getMaxHitPoints(){
        return this.maxHitPoints;
    }
    protected double getBaseSpeed(){
        return this.baseSpeed;
    }

}
