package com.bqtn.characters;

import java.time.*;

import com.bqtn.items.Item;

import java.text.DecimalFormat;

public class Character {

    //?? Character extends Entity ??
    //?? private Attributes attributes ??
    private String lastName;
    private String firstName;
    private String gender;
    private LocalDate dateOfBirth;
    private int health;
    private int energy;
    private int encumbrance; // total weight of items in grams

    private Stats stats;
    private Body body;
    private Inventory inventory;

    private CharacterState currentState;

    public Character(String lastName,String firstName,String gender,LocalDate dateOfBirth,int physicalAgeInDays,int percentile,int strength,int dexterity,int intelligence,int constitution){
        this.initDetails(lastName,firstName,gender,dateOfBirth);
        this.initInventory();
        this.initCharacterSheet(strength, dexterity, intelligence, constitution);
        this.initBody(physicalAgeInDays,gender,percentile);
        this.initDerivatedStats();
        this.currentState = CharacterState.IDLE;
    }

    public String toString(){
        return this.getFullName() + " (" + this.gender.toUpperCase() + ")\n" +
        "Date of Birth: " + this.dateOfBirth + "\n" + getBody()+getStats()+getInventory();
    }

    public String bodyToString(){
        return this.body.toString();
    }

    // Initialization methods
    private void initDetails(String lastName,String firstName,String gender,LocalDate dateOfBirth){
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    
    private void initInventory(){
        this.inventory = new Inventory();
    }

    public void initBody(int physicalAgeInDays,String gender,int percentile){
        this.body = new Body(physicalAgeInDays,gender,percentile);
    }

    public void initCharacterSheet(int strength,int dexterity,int intelligence,int constitution){
        this.stats = new Stats(strength, dexterity, intelligence, constitution);
    }

    public void initDerivatedStats(){
        this.health = this.stats.getMaxHealth();
        this.energy = this.stats.getMaxEnergy();
        this.encumbrance = 0;
    }

    public void wearItemOnSlot(Item item, InventorySlot slot) {
        this.inventory.wearItemOnSlot(item, slot);
    }

    protected void removeItemFromSlot(InventorySlot slot) {
        this.inventory.removeItemFromSlot(slot);
    }

    public Body getBody(){
        return this.body;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public Stats getStats(){
        return this.stats;
    }
    
    public void growInDays(int nbOfDays){
        this.body.simulateGrowth(nbOfDays);
    }

    public void growInYears(int nbOfYears){
        this.growInDays(nbOfYears * 365);
    }
    
    public String getLastName(){
        return this.lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getFullName(){
        return this.firstName+" "+this.lastName;
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    public int getPhysicalAge(){
        return this.body.getPhysicalAge();
    }

    public CharacterState getState(){
        return this.currentState;
    }

    public String getGender(){
        return this.gender;
    }

    public int getPercentile(){
        return this.body.getPercentile();
    }

    // Character Sheet

    public int getStrength(){
        return this.stats.getDexterity();
    }
    public int getDexterity(){
        return this.stats.getDexterity();
    }
    public int getIntelligence(){
        return this.stats.getIntelligence();
    }
    public int getConstitution(){
        return this.stats.getConstitution();
    }

    public double getBaseSpeed(){
        return this.stats.getBaseSpeed();
    }
    

}