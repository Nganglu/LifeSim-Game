package com.bqtn.controllers;

import java.util.List;

import com.bqtn.items.Item;

public class TradeController {
    Character proposer;
    Character recipient;

    List<Item> proposedItems;
    int proposedMoney;
    
    List<Item> wantedItems;
    int wantedMoney;

    public TradeController(List<Item> proposedItems,int proposedMoney,List<Item> wantedItems,int wantedMoney){
        this.proposedItems = proposedItems;
        this.proposedMoney = proposedMoney;
        this.wantedItems = wantedItems;
        this.wantedMoney = wantedMoney;
    }
}
