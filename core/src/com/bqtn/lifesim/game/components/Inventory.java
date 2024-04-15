package com.bqtn.lifesim.game.components;

import com.bqtn.lifesim.game.Entity;
import com.bqtn.lifesim.game.enums.BodyPart;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Inventory implements Component {
    Map<BodyPart, List<String>> inventoryMap;
    int money;
    int totalWeight;
    int itemsValue;

    public Map<BodyPart, List<String>> getInventoryMap() {
        return inventoryMap;
    }

    public void setInventoryMap(EnumMap<BodyPart, List<String>> inventoryMap) {
        this.inventoryMap = inventoryMap;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getItemsValue() {
        return itemsValue;
    }

    public void setItemsValue(int itemsValue) {
        this.itemsValue = itemsValue;
    }
}
