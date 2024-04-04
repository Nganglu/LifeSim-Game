package com.bqtn.controllers;
import java.time.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.bqtn.characters.Character;
import com.bqtn.characters.InventorySlot;
import com.bqtn.events.EventScheduler;
import com.bqtn.items.Item;
import com.bqtn.items.ItemTypes.Backpack;
import com.bqtn.world.World;

import java.util.Random;

public class SimulationController {
    Map<String,Character> characterCatalog;
    Map<String,Item> itemCatalog;
    
    static List<Character> activeCharacters;
    static Character selectedCharacter;
    
    World world;
    EventScheduler scheduler;
    static Random random;

    public SimulationController(){
        this.itemCatalog = new HashMap<>();
        this.characterCatalog = new HashMap<>();
        SimulationController.activeCharacters = new ArrayList<>();
        this.random = new Random();
    }

    void selectWorld(World world){
        this.world = world;
    }

    static void selectCharacter(Character character){
        selectedCharacter = character;
    }

    static void setCharacterAsActive(Character character){
            activeCharacters.add(selectedCharacter);
    }

    static void showInventory(Character character){
        //TODO
    }

    static void tradeMoneyForItem(Character character,Item item){
        //TODO +toPerson
    }

    static void setSelectedCharacterAsActive(){
        if (selectedCharacter != null){
            setCharacterAsActive(selectedCharacter);
        }
    }
    
    public static void main(String[] args) {
        //! FOR TESTING PURPOSE
        System.out.println();

        World world = new World("Test world","This is a test world.",2024, 1, 1);
        Character alter = new Character("Benjamin", "Nguyen", "male", LocalDate.of(1996,01,31), 22*365,29,13,12,15,11);

        Backpack bp = new Backpack("Backpack", "It's a backpack", 100, 100, 5000,240);
        Backpack bp2 = new Backpack("Small Backpack", "It's a small backpack", 50, 20, 1000,120);
        Item item = new Item("Massive Dildo", "It's big... like REALLY big!", 5000, 2000,6969);
        
        alter.wearItemOnSlot(bp, InventorySlot.BACKPACK);
        System.out.println("BREAK");
        alter.wearItemOnSlot(item, InventorySlot.BOTH_HANDS);
        
        System.out.println(alter);

    }
}
