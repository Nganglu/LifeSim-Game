package com.bqtn;
import java.time.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import com.bqtn.Characters.Character;
import com.bqtn.Events.EventScheduler;
import com.bqtn.Items.Item;
import com.bqtn.Items.ItemTypes.Backpack;
import com.bqtn.World.World;

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

        World world = new World(2024, 1, 1);
        Character alter = new Character("Benjamin", "Nguyen", "male", LocalDate.of(1996,01,31), 22*365,29,13,12,15,11);

        Backpack bp = new Backpack("bp", "It's a backpack", 100, 100, 5000);
        Backpack bp2 = new Backpack("bp2", "It's a small backpack", 50, 20, 1000);
        Item item = new Item("Massive Dildo", "It's big... like REALLY big!", 5000, 2000);
        
        world.addCharacter(alter);

        System.out.println(alter);
        System.out.println(
            alter.getCharacterSheet().toString()
        );

        Random random = new Random();
        GameMaster gm = new GameMaster(random);

    }
}
