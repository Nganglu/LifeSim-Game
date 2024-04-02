package com.bqtn.Characters;

import java.time.*;
import java.util.*;

import com.bqtn.Items.Item;

import java.text.DecimalFormat;

public class Character {

    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dateOfBirth;

    private Map<InventorySlot,Item> inventory;
    
    private Body body;
    private CharacterSheet characterSheet;

    private Random random;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Character(String firstName,String lastName,String gender,LocalDate dateOfBirth,int physicalAgeInDays,int percentile,int strength,int dexterity,int intelligence,int health){
        this.initDetails(firstName,lastName,gender,dateOfBirth);
        this.initInventory();
        this.initBody(physicalAgeInDays,gender,percentile);
        this.initCharacterSheet(strength, dexterity, intelligence, health);
    }

    public Character(String firstName,String lastName,String gender,LocalDate dateOfBirth,int physicalAgeInDays){
        this.initDetails(firstName,lastName,gender,dateOfBirth);
        this.initInventory();
        random = new Random();
        int percentile = (int) Math.round(random.nextGaussian() * 15 + 50);
        percentile = (percentile > 100 || percentile < 1)?50:percentile;
        this.body = new Body(physicalAgeInDays,gender,percentile);
    }

    public String toString(){
        return this.firstName + " " + this.lastName + " (" + this.gender.toUpperCase() + ")\n" +
        "Date of Birth: " + this.dateOfBirth + "\n" +
        "Height: " + df.format(this.body.getHeight()) + "cm / Weight: " + df.format(this.body.getWeight()) + "kg\n";
    }
    
    public String inventoryToString(){
        String inventoryString = "== Inventory Content ==\n\n";
        for (InventorySlot slot : inventory.keySet()) {
            if(inventory.get(slot) != null){
                Item item = inventory.get(slot);
                inventoryString += item + "\n";
            }
        }
        inventoryString += "\n=======================\n";
        return inventoryString;
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
        this.inventory = new HashMap<>();
        // Initialize inventory slots
        for (InventorySlot slot : InventorySlot.values()) {
            this.inventory.put(slot, null);
        }
    }

    public void initBody(int physicalAgeInDays,String gender,int percentile){
        this.body = new Body(physicalAgeInDays,gender,percentile);
    }

    public void initCharacterSheet(int strength,int dexterity,int intelligence,int health){
        this.characterSheet = new CharacterSheet(strength, dexterity, intelligence, health);
    }
    
    public void wearItemOnSlot(Item item, InventorySlot slot) {
        if (item.getWearableSlot() == slot){
            if (this.inventory.get(slot) == null){
                this.inventory.put(slot, item);
                item.setIsCurrentlyWorn();
            } else {
                System.out.println(slot + " is already occupied");
            }
        } else {
            System.out.println(slot+" is not a valid slot to wear a "+item.getName()+"...");
        }
    }
    
    public void removeItemFromSlot(InventorySlot slot) {
        Item removedItem = this.inventory.get(slot);
        if (removedItem != null){
            removedItem.unsetIsCurrentlyWorn();
            this.inventory.put(slot, null);
        }
    }
    
    public Item getItemFromSlot(InventorySlot slot) {
        return this.inventory.get(slot);
    }

    public Item retrieveItemFromSlot(InventorySlot slot) {
        this.removeItemFromSlot(slot);
        return this.inventory.get(slot);
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
    
    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    public Body getBody(){
        return this.body;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

}