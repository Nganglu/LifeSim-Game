package com.bqtn.Characters;

import java.time.*;

import com.bqtn.Items.Item;

import java.text.DecimalFormat;

public class Character {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;

    private CharacterSheet characterSheet;
    private Body body;
    private Inventory inventory;

    private int hitPoints;
    private int fatigue;
    private int encumbrance; // total weight of items in grams

    private boolean isUnconscious;

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Character(String firstName,String lastName,String gender,LocalDate dateOfBirth,int physicalAgeInDays,int percentile,int strength,int dexterity,int intelligence,int health){
        this.initDetails(firstName,lastName,gender,dateOfBirth);
        this.initInventory();
        this.initCharacterSheet(strength, dexterity, intelligence, health);
        this.initBody(physicalAgeInDays,gender,percentile);
        this.initDerivatedStats();
    }

    public String toString(){
        return this.firstName + " " + this.lastName + " (" + this.gender.toUpperCase() + ")\n" +
        "Date of Birth: " + this.dateOfBirth + "\n" +
        "Height: " + df.format(this.body.getHeight()) + "cm / Weight: " + df.format(this.body.getWeight()) + "kg\n";
    }

    public String bodyToString(){
        return this.body.toString();
    }

    // Initialization methods
    private void initDetails(String firstName,String lastName,String gender,LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    
    private void initInventory(){
        this.inventory = new Inventory();
    }

    public void initBody(int physicalAgeInDays,String gender,int percentile){
        this.body = new Body(physicalAgeInDays,gender,percentile);
    }

    public void initCharacterSheet(int strength,int dexterity,int intelligence,int health){
        this.characterSheet = new CharacterSheet(strength, dexterity, intelligence, health);
    }

    public void initDerivatedStats(){
        this.hitPoints = this.characterSheet.getMaxHitPoints();
        this.fatigue = this.characterSheet.getMaxFatigue();
        this.encumbrance = 0;
        this.isUnconscious = false;
    }

    public Item retrieveItemFromSlot(InventorySlot slot) {
        this.inventory.removeItemFromSlot(slot);
        return this.inventory.getItemFromSlot(slot);
    }

    public Body getBody(){
        return this.body;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public CharacterSheet getCharacterSheet(){
        return this.characterSheet;
    }
    
    public void growInDays(int nbOfDays){
        this.body.simulateGrowth(nbOfDays);
    }

    public void growInYears(int nbOfYears){
        this.growInDays(nbOfYears * 365);
    }
    
    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }



}