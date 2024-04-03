package com.bqtn.characters;
import java.util.Map;

import com.bqtn.items.Item;
import com.bqtn.items.ItemTypes.Backpack;

import java.util.HashMap;

public class Inventory {
    
    private int money; // in cents
    private Map<InventorySlot,Item> inventoryMap;
    private int totalWeight;
    private int itemsValue;

    protected Inventory(int money){
        this.money = money;
        this.inventoryMap = new HashMap<>();
        for (InventorySlot slot : InventorySlot.values()) {
            this.inventoryMap.put(slot, null);
        }
        this.totalWeight = 0;
    }

    protected Inventory(){
        this(0);
    }

    public String toString(){
        String inventoryString = "== Inventory Content ==\n\n";
        for (InventorySlot slot : inventoryMap.keySet()) {
            if(inventoryMap.get(slot) != null){
                Item item = inventoryMap.get(slot);
                inventoryString += item + "\n";
            }
        }
        inventoryString += "\n-----------------------\n";
        return inventoryString;
    }

    protected void wearItemOnSlot(Item item, InventorySlot slot) {
        if (item.getWearableSlot() == slot){
            if (this.inventoryMap.get(slot) == null){
                this.inventoryMap.put(slot, item);
                this.totalWeight += item.getWeight();
                this.itemsValue += item.getBaseValue();
                item.setIsBeingWorn();
            } else {
                System.out.println(slot + " is already occupied");
            }
        } else {
            System.out.println(slot+" is not a valid slot to wear a "+item.getName()+"...");
        }
    }

    protected void removeItemFromSlot(InventorySlot slot) {
        Item removedItem = this.inventoryMap.get(slot);
        if (removedItem != null){
            removedItem.unsetIsBeingWorn();
            this.totalWeight -= removedItem.getWeight();
            this.itemsValue -= removedItem.getBaseValue();
            this.inventoryMap.put(slot, null);
        }
    }

    protected Item getItemFromSlot(InventorySlot slot) {
        return this.inventoryMap.get(slot);
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

    protected void updateTotalWeight(){
        int totalWeight = 0;
        for (InventorySlot slot : InventorySlot.values()) {
            totalWeight += this.inventoryMap.get(slot).getWeight();
        }
        this.totalWeight = totalWeight;
    }

    protected int getTotalWeight(){
        return this.totalWeight;
    }

    protected void updateTotalItemsValue(){
        int itemsValue = 0;
        for (InventorySlot slot : InventorySlot.values()) {
            itemsValue += this.inventoryMap.get(slot).getBaseValue();
            if (slot.equals(InventorySlot.BACKPACK)){
                itemsValue += ((Backpack) this.inventoryMap.get(slot)).getTotalValue();
            }
        }
        this.itemsValue = itemsValue;
    }

    protected int getTotalItemsValue(){
        return this.itemsValue;
    }
}
