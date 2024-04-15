package com.bqtn.lifesim.game;

import com.bqtn.lifesim.game.components.*;
import com.bqtn.lifesim.game.enums.BodyPart;
import com.bqtn.lifesim.game.enums.CharacterArchetype;
import com.bqtn.lifesim.game.enums.EntityType;
import com.bqtn.lifesim.game.enums.PhysicialDamageType;
import com.bqtn.lifesim.game.systems.*;

import java.util.ArrayList;
import java.util.List;

public class World {
    static EntityManager entityManager;
    static CharacterFactory characterFactory;
    static DamageSystem damageSystem;
    static EquipementManager equipementManager;
//    GameMaster gameMaster;

    public static void main(String[] args) {
        entityManager = new EntityManager();
        characterFactory = new CharacterFactory(entityManager);
        damageSystem = new DamageSystem(entityManager);
        equipementManager = new EquipementManager(entityManager);

        GameMaster gm = new GameMaster();
        gm.init();

        String alterId = entityManager.createEntity(EntityType.CHARACTER);
        characterFactory.initCharacter(alterId);
        equipementManager.initInventory(alterId);
        characterFactory.setIdentity(alterId,"Benjamin","Nguyen", "Male");

        Health alterHealth = entityManager.getComponentByType(alterId, Health.class);
        Identity alterIdentity = entityManager.getComponentByType(alterId, Identity.class);

        characterFactory.setAttributes(alterId,50,65,50,50,80);

        characterFactory.initHealth(alterId);
        System.out.println(alterHealth.getHp());

        System.out.println(damageSystem.getDamage(alterId));

        String itemId = entityManager.createEntity(EntityType.ITEM);
        entityManager.addComponent(itemId, new Wearable());
        entityManager.addComponent(itemId, new Weapon());

        Weapon weapon = entityManager.getComponentByType(itemId,Weapon.class);
        Wearable wearable = entityManager.getComponentByType(itemId,Wearable.class);

        List<BodyPart> wearableSlots = new ArrayList<>();
        wearableSlots.add(BodyPart.BOTH_HANDS);

        wearable.setWearableSlotList(wearableSlots);
        weapon.setBaseDamage(150);
        weapon.setDamageType(PhysicialDamageType.PIERCING);

        equipementManager.wearItem(alterId,itemId,BodyPart.BOTH_HANDS);
        System.out.println(damageSystem.getDamage(alterId));

    }
}
