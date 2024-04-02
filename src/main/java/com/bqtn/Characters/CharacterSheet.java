package com.bqtn.Characters;

import java.text.DecimalFormat;

public class CharacterSheet {
    // Main Stats
    private int strength;
    private int dexterity;
    private int intelligence;
    private int constitution;

    // Derivated
    private int willpower;
    private int perception;
    private int maxHealth;
    private int maxEnergy;

    private double baseSpeed; // in meters/second
    private double baseLift; // in kg

    //Skill list separated by main stat?

    private static final DecimalFormat df = new DecimalFormat("0.00");

    protected CharacterSheet(int strength,int dexterity,int intelligence,int constitution) {
        this.setBaseStats(strength, dexterity, intelligence, constitution);
    }

    public String toString(){
        return "  ======== STATS ========"+
                "\nST "+this.strength+" | DX "+this.dexterity+" | IQ "+this.intelligence+" | HT "+this.constitution+
                "\nWillpower: "+this.willpower+"        Perception: "+this.perception+
                "\nSpeed: "+df.format(this.baseSpeed)+"m/s  Lift: "+df.format(this.baseLift)+"kg"+
                "\n  ------------------------"+
                "\n Max HP: "+this.maxHealth+"  Max Energy: "+this.maxEnergy+
                "\n  ========================";
    }

    protected void setBaseStats(int strength,int dexterity,int intelligence,int constitution) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.constitution = constitution;
        this.updateDerivatedStats();
    }

    protected void updateDerivatedStats(){
        this.maxHealth = this.strength;
        this.willpower = this.intelligence;
        this.perception = this.intelligence;
        this.maxEnergy = this.constitution;
        this.baseSpeed = 1.0 * (this.constitution + this.dexterity) / 4;
        this.baseLift = 1.0 * Math.pow(this.strength,2)/10;
    }

    protected int getStrength(){
        return this.strength;
    }
    protected void setStrength(int strength){
        this.updateDerivatedStats();
        this.strength = strength;
    }
    protected int getDexterity(){
        return this.dexterity;
    }
    protected void setDexterity(int dexterity){
        this.updateDerivatedStats();
        this.dexterity = dexterity;
    }
    protected int getIntelligence(){
        return this.intelligence;
    }
    protected void setIntelligence(int intelligence){
        this.updateDerivatedStats();
        this.intelligence = intelligence;
    }
    protected int getConstitution(){
        return this.constitution;
    }
    protected void setConstitution(int constitution){
        this.updateDerivatedStats();
        this.constitution = constitution;
    }
    protected int getWillpower(){
        return this.willpower;
    }
    protected int getPerception(){
        return this.perception;
    }
    protected int getMaxEnergy(){
        return this.maxEnergy;
    }
    protected int getMaxHealth(){
        return this.maxHealth;
    }
    protected double getBaseSpeed(){
        return this.baseSpeed;
    }

}
