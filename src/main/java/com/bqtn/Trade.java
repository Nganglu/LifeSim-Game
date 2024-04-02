package com.bqtn;

import java.util.List;

import com.bqtn.Items.Item;

public class Trade {
    Character proposer;
    Character recipient;

    List<Item> proposedItems;
    int proposedMoney;
    
    List<Item> wantedItems;
    int wantedMoney;

    public Trade(List<Item> proposedItems,int proposedMoney,List<Item> wantedItems,int wantedMoney){
        this.proposedItems = proposedItems;
        this.proposedMoney = proposedMoney;
        this.wantedItems = wantedItems;
        this.wantedMoney = wantedMoney;
    }
}
