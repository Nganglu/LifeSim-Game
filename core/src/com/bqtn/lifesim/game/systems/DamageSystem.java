package com.bqtn.lifesim.game.systems;

import com.bqtn.lifesim.game.Entity;
import com.bqtn.lifesim.game.components.Attributes;
import com.bqtn.lifesim.game.components.Inventory;
import com.bqtn.lifesim.game.components.Weapon;
import com.bqtn.lifesim.game.enums.BodyPart;

import java.util.List;
import java.util.Map;

public class DamageSystem {

    private final EntityManager manager;

    public DamageSystem(EntityManager manager){
        this.manager = manager;
    }
    public int getDamage(String characterId){
        Inventory inventory = manager.getComponentByType(characterId, Inventory.class);
        Map<BodyPart, List<String>> invMap = inventory.getInventoryMap();

        BodyPart[] handSlots = {BodyPart.BOTH_HANDS,BodyPart.R_HAND,BodyPart.L_HAND};

        for (BodyPart handSlot : handSlots) {
            List<String> itemList = invMap.get(handSlot);
            if (itemList != null){
                for (String itemId : itemList) {
                    Weapon weapon = manager.getComponentByType(itemId, Weapon.class);
                    if (weapon != null) {
                        return (int) (weapon.getBaseDamage() * weapon.getDamageType().getDamageModifier() * getStrengthMultiplier(characterId));
                    }
                }
            }
        }
        return (int) (50 * getStrengthMultiplier(characterId));
    }

    public double getStrengthMultiplier(String characterId){
        int charStrength = manager.getComponentByType(characterId, Attributes.class).getStrength();
        if (charStrength < 50){
            return 1.0 - (50 - charStrength)/100.0;
        } else {
            return 1.0 + (charStrength - 50)/50.0;
        }
    }
}
