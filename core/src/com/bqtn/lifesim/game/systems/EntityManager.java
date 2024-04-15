package com.bqtn.lifesim.game.systems;

import com.bqtn.lifesim.game.Entity;
import com.bqtn.lifesim.game.enums.EntityType;
import com.bqtn.lifesim.game.components.*;
import com.bqtn.lifesim.game.components.Component;

import java.util.*;

public class EntityManager {
    private Map<String, Entity> entities;
    private Map<String,List<Component>> components;

    public EntityManager(){
        this.entities = new HashMap<>();
        this.components = new HashMap<>();
    }

    public void addEntity(Entity entity) {
        String entityId = entity.getId();
        if (this.entities.containsKey(entityId)) {
            throw new IllegalArgumentException("Entity with ID " + entityId + " already exists");
        }
        this.entities.put(entityId, entity);
        this.components.put(entityId, new ArrayList<>()); // Initialize components list for the entity
    }

    public String createEntity(EntityType type){
        Entity entity = new Entity(type);
        addEntity(entity);
        String entityId = entity.getId();

        switch (type){
            case CHARACTER:
                this.addComponent(entityId,new Identity());
                this.addComponent(entityId,new Attributes());
                this.addComponent(entityId,new Body());
                this.addComponent(entityId,new Measurements());
                this.addComponent(entityId,new Health());
                this.addComponent(entityId,new Inventory());
                break;
            case ITEM:
                break;
            case NONE:
        }
        return entityId;
    }

    public String createEntity(){
        return createEntity(EntityType.NONE);
    }

    public Entity getEntity(String entityId) {
        return this.entities.get(entityId);
    }

    public <T extends Component> void addComponent(String entityId,T component){
        if(!this.entities.containsKey(entityId)){
            throw new IllegalArgumentException("Entity does not exist");
        }
        this.components.computeIfAbsent(entityId, k -> new ArrayList<>()).add(component);
    }

    public <T extends Component> T getComponentByType(String entityId, Class<T> componentClass) {
        List<Component> entityComponents = this.components.get(entityId);
        if (entityComponents.isEmpty()) {
            System.out.println("Entity has no components.");
            return null;
        }

        for (Component component : entityComponents) {
            if (componentClass.isInstance(component)) {
                return componentClass.cast(component);
            }
        }
        System.out.println("Component of type "+componentClass+" not found.");
        return null;
    }

    public <T extends Component> List<T> getComponentsByType(String entityId, Class<T> componentClass) {
        List<Component> entityComponents = this.components.get(entityId);
        if (entityComponents == null) {
            System.out.println("Entity has no components.");
            return Collections.emptyList();
        }

        List<T> matchingComponents = new ArrayList<>();
        for (Component component : entityComponents) {
            if (componentClass.isInstance(component)) {
                matchingComponents.add(componentClass.cast(component));
            }
        }
        return matchingComponents;
    }
}
