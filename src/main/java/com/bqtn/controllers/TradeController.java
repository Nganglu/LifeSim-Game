package com.bqtn.controllers;

import java.util.List;

import com.bqtn.items.Item;

public class TradeController {
    Character proposer;
    Character recipient;

    List<Item> offeredItems;
    int offeredMoney;
    int offeredValue;
    
    List<Item> requestedItems;
    int requestedMoney;
    int requestedValue;

    public TradeController(List<Item> offeredItems,int offeredMoney,List<Item> requestedItems,int requestedMoney){
        this.offeredItems = offeredItems;
        this.offeredMoney = offeredMoney;
        this.requestedItems = requestedItems;
        this.requestedMoney = requestedMoney;
        updateOfferedValue();
        updateRequestedValue();
    }

    public void addRequestedItem(Item item){
        this.requestedItems.add(item);
        updateRequestedValue();
    }

    public void removeRequestedItem(Item item){
        if (item != null && this.requestedItems.contains(item)){
            this.requestedItems.add(item);
            updateRequestedValue();
        }
    }

    public void addOfferedItem(Item item){
        this.offeredItems.add(item);
        updateOfferedValue();
    }

    public void removeOfferedItem(Item item){
        if (item != null && this.offeredItems.contains(item)){
            this.offeredItems.add(item);
            updateOfferedValue();
        }
    }

    public void addRequestedMoney(int money){
        this.requestedMoney += money;
        this.requestedValue += money;
    }

    public void addOfferedMoney(int money){
        this.offeredMoney += money;
        this.offeredValue += money;
    }

    public void updateOfferedValue(){
        this.offeredValue = this.getItemsValue(this.offeredItems) + this.offeredMoney;
    }

    public void updateRequestedValue(){
        this.requestedValue = this.getItemsValue(this.requestedItems) + this.requestedMoney;
    }

    public int getItemsValue(List<Item> itemList){
        int itemsValue = 0;
        for (int i = 0; i < this.offeredItems.size(); i++) {
            itemsValue += this.offeredItems.get(i).getBaseValue();
        }
        return itemsValue;
    }

    public int getOfferedValue(){
        return this.offeredValue;
    }

    public int getRequestedValue(){
        return this.requestedValue;
    }

    public int getTradeValue(){
        return this.requestedValue - this.offeredValue;
    }

    public void finalizeTrade(){
        //enforce trade validation?
    }
}
