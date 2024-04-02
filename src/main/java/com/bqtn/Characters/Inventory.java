package com.bqtn.Characters;
import com.bqtn.Items.Item;

import java.util.Map;
import java.util.HashMap;

public class Inventory {
    
    private int money; // in cents
    private Map<InventorySlot,Item> inventorySlot;

    protected Inventory(int money){
        this.money = money;
        this.inventorySlot = new HashMap<>();
        for (InventorySlot slot : InventorySlot.values()) {
            this.inventorySlot.put(slot, null);
        }
    }

    protected Inventory(){
        this(0);
    }

    public String toString(){
        String inventoryString = "== Inventory Content ==\n\n";
        for (InventorySlot slot : inventorySlot.keySet()) {
            if(inventorySlot.get(slot) != null){
                Item item = inventorySlot.get(slot);
                inventoryString += item + "\n";
            }
        }
        inventoryString += "\n-----------------------\n";
        return inventoryString;
    }

    protected void wearItemOnSlot(Item item, InventorySlot slot) {
        if (item.getWearableSlot() == slot){
            if (this.inventorySlot.get(slot) == null){
                this.inventorySlot.put(slot, item);
                item.setIsBeingWorn();
            } else {
                System.out.println(slot + " is already occupied");
            }
        } else {
            System.out.println(slot+" is not a valid slot to wear a "+item.getName()+"...");
        }
    }

    protected void removeItemFromSlot(InventorySlot slot) {
        Item removedItem = this.inventorySlot.get(slot);
        if (removedItem != null){
            removedItem.unsetIsBeingWorn();
            this.inventorySlot.put(slot, null);
        }
    }

    protected Item getItemFromSlot(InventorySlot slot) {
        return this.inventorySlot.get(slot);
    }

    protected Item retrieveItemFromSlot(InventorySlot slot) {
        this.removeItemFromSlot(slot);
        return this.inventorySlot.get(slot);
    }

    protected int getMoney(){
        return this.money;
    }

    protected void setMoney(int money){
        this.money = money;
    }

    protected void changeMoneyBy(int money){
        this.money += money;
    }
}
