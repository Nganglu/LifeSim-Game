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
    
    private final Body body;

    private Random random;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Character(String firstName,String lastName,String gender,LocalDate dateOfBirth,int physicalAgeInDays,int percentile){
        this.initDetails(firstName,lastName,gender,dateOfBirth);
        this.initInventory();
        this.body = new Body(physicalAgeInDays,gender,percentile);
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
    
    private void initDetails(String firstName,String lastName,String gender,LocalDate dateOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
    
    private void initInventory(){
        inventory = new HashMap<>();
        // Initialize inventory slots
        for (InventorySlot slot : InventorySlot.values()) {
            inventory.put(slot, null);
        }
    }
    
    public void wearItemOnSlot(Item item, InventorySlot slot) {
        if (inventory.get(slot) == null){
            inventory.put(slot, item);
        } else {
            System.out.println(slot + " is already occupied");
        }
    }
    
    public void removeItemFromSlot(InventorySlot slot) {
        inventory.put(slot, null);
    }
    
    public Item getItemInSlot(InventorySlot slot) {
        return inventory.get(slot);
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

    public String bodyToString(){
        return this.body.toString();
    }
}