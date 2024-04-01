package com.bqtn;
import java.time.*;
import java.util.Map;

import com.bqtn.Characters.Body;
import com.bqtn.Characters.Character;
import com.bqtn.Characters.InventorySlot;
import com.bqtn.Items.Item;
import com.bqtn.Items.ItemTypes.Backpack;

public class SimulationController {
    Map<String,Item> itemCatalog;
    Map<String,Character> characterCatalog;
    
    public static void main(String[] args) {
        World world = new World(2024, 1, 1);
        Character alter = new Character("Benjamin", "Nguyen", "male", LocalDate.of(1996,01,31), 22*365,29);
        world.addCharacter(alter);

        Backpack bp = new Backpack("bp", "It's a backpack", 100, 100, 2500);
        Backpack bp2 = new Backpack("bp2", "It's a small backpack", 50, 20, 1000);
        Item item = new Item("Massive Dildo", "It's big... like REALLY big!", 5000, 5000);
        
        alter.wearItemOnSlot(bp, InventorySlot.BACKPACK);
        
        bp.addItem(bp2);
        
        Item retrieved = alter.getItemInSlot(InventorySlot.BACKPACK);
        bp.removeItem(bp2);
        
        System.out.println(bp);
        System.out.println(retrieved);

    }
}
