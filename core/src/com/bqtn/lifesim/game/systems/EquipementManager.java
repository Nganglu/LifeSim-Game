package com.bqtn.lifesim.game.systems;

import com.bqtn.lifesim.game.components.Inventory;
import com.bqtn.lifesim.game.components.Wearable;
import com.bqtn.lifesim.game.enums.BodyPart;

import java.sql.Array;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class EquipementManager {
    EntityManager manager;

    public EquipementManager(EntityManager manager){
        this.manager = manager;
    }

    public void initInventory(String characterId){
        Inventory inventory = this.manager.getComponentByType(characterId,Inventory.class);
        if (inventory.getInventoryMap() != null) {
            throw new IllegalStateException("Inventory component has already been initialized");
        }
        EnumMap<BodyPart, List<String>> inventoryMap = new EnumMap<>(BodyPart.class);
        for (BodyPart bodyPart:BodyPart.values()){
            inventoryMap.put(bodyPart, new ArrayList<String>());
        }
        inventory.setInventoryMap(inventoryMap);

        inventory.setMoney(0);
        inventory.setTotalWeight(0);
        inventory.setItemsValue(0);
    }

    public void wearItem(String characterId,String itemId,BodyPart bodyPart){
        Inventory inventory = this.manager.getComponentByType(characterId,Inventory.class);
        Wearable wearable = this.manager.getComponentByType(itemId,Wearable.class);

        if (wearable.getWearableSlotList() != null){
            for (int i = 0; i < wearable.getWearableSlotList().size(); i++) {
                if (wearable.getWearableSlotList().get(i) == bodyPart){
                    inventory.getInventoryMap().get(bodyPart).add(itemId);
                    wearable.setWearerId(characterId);
                    return;
                }
            }
        } else {
            System.out.println(itemId+" is not wearable.");
        }
    }
//! CAN'T JUST REMOVE. Store? Drop?
//    public void removeItem(String characterId,String itemId,BodyPart bodyPart){
//        Inventory inventory = this.manager.getComponentByType(characterId,Inventory.class);
//        Wearable wearable = this.manager.getComponentByType(itemId,Wearable.class);
//        List<String> slotContentList = inventory.getInventoryMap().get(bodyPart);
//
//        if (!slotContentList.isEmpty()){
//            for (int i = 0; i < slotContentList.size(); i++) {
//                if (slotContentList.get(i).equals(itemId)){
//                    slotContentList.remove(i);
//                    wearable.setWearerId(null);
//                }
//            }
//        } else {
//            System.out.println("Slot: "+bodyPart+" is empty");
//        }
//    }

}
