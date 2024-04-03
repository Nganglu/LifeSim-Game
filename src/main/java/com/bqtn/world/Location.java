package com.bqtn.world;
import java.util.ArrayList;
import java.util.List;

import com.bqtn.items.Item;

public class Location {
    String name;
    String description;
    LocationType type;
    Character owner;

    List<Character> characterList;
    List<Item> itemList;

    public Location(String name,String description,LocationType type,Character owner){
        this.name = name;
        this.description = description;
        this.type = type;
        this.owner = owner;
        this.characterList = new ArrayList<>();
        this.itemList = new ArrayList<>();
    }

    public void addCharacter(Character character){
        if (character != null) this.characterList.add(character);
    }

    public void addCharacterList(List<Character> characterList){
        for (Character character : characterList) {
            this.addCharacter(character);
        }
    }
    
    public void removeCharacter(Character character){
        if (character != null && characterList.contains(character)){
            for (Character currentChar : this.characterList) {
                if (character == currentChar){
                    characterList.remove(currentChar);
                    return;
                }
            }
        }
    }

    public void addItem(Item item){
        if (item != null) this.itemList.add(item);
    }
    
    public void addItemList(List<Item> itemList){
        for (Item item : itemList) {
            this.addItem(item);
        }
    }

    public void removeItem(Item item){
        if (item != null && itemList.contains(item)){
            for (Item currentChar : this.itemList) {
                if (item == currentChar){
                    itemList.remove(currentChar);
                    return;
                }
            }
        }
    }

}
