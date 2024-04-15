package com.bqtn.lifesim.game;

import com.bqtn.lifesim.game.enums.EntityType;

import java.util.HashMap;
import java.util.Map;

public class Entity {
    private static Map<String, Integer> nextIdMap = new HashMap<>();
    private final EntityType type;
    private int id;

    public Entity(EntityType type) {
        this.type = type;
        this.id = nextIdMap.getOrDefault(type.getIdShort(), 0);
        nextIdMap.put(type.getIdShort(), id + 1);
    }

    public String getId() {
        return type.getIdShort() + "_" + id;
    }
}