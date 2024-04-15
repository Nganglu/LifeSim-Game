package com.bqtn.lifesim.game.systems;

import com.bqtn.lifesim.game.components.*;
import com.bqtn.lifesim.game.enums.BodyPart;
import com.bqtn.lifesim.game.enums.CharacterArchetype;

import java.util.EnumMap;
import java.util.List;

public class CharacterFactory {
    private final EntityManager manager;

    public CharacterFactory(EntityManager manager){
        this.manager = manager;
    }

    // INIT
    public void initCharacter(String characterId){
        setIdentity(characterId,"","","undefined");
        setAttributes(characterId,50,50,50,50,50);
        setMeasurements(characterId,170,6500); //! in cm and grams
        initBody(characterId);
        initHealth(characterId);
    }

    public void initCharacter(String characterId, CharacterArchetype archetype){
        String[] archetypeData = archetype.getData();
        setIdentity(characterId,archetypeData[0],archetypeData[1],archetypeData[2]);
        setAttributes(characterId,Integer.parseInt(archetypeData[3]),Integer.parseInt(archetypeData[4]),Integer.parseInt(archetypeData[5]),Integer.parseInt(archetypeData[6]),Integer.valueOf(archetypeData[7]));
        setMeasurements(characterId,Integer.parseInt(archetypeData[8]),Integer.parseInt(archetypeData[9])); //! in cm and grams
        initBody(characterId);
        initHealth(characterId);
    }

    public void initBody(String characterId){
        Body body = this.manager.getComponentByType(characterId,Body.class);
        if (body.getBodyMap() != null) {
            throw new IllegalStateException("Body component has already been initialized");
        }
        EnumMap<BodyPart, Health> bodyMap = new EnumMap<>(BodyPart.class);
        for (BodyPart bodyPart:BodyPart.values()){
            Health health = new Health();
            health.setHp(100);
            health.setBleeding(false);

            bodyMap.put(bodyPart,health);
        }
        body.setBodyMap(bodyMap);
    }

    public void initHealth(String characterId){
        Health health = this.manager.getComponentByType(characterId,Health.class);
        Attributes attributes = this.manager.getComponentByType(characterId, Attributes.class);

        health.setMaxHealthPoints(attributes.getStrength()*10);
        health.setHp(health.getMaxHealthPoints());
        health.setBleeding(false);
    }

    public void updateMaxHealth(String characterId){
        this.manager.getComponentByType(characterId,Health.class).setMaxHealthPoints(
            (this.manager.getComponentByType(characterId, Attributes.class).getStrength() * 10 +
            this.manager.getComponentByType(characterId, Attributes.class).getStrength() * 10) /2
        );
    }

    //IDENTITY
    public void setIdentity(String characterId,String firstName,String lastName,String gender){
        setFirstName(characterId,firstName);
        setLastName(characterId,lastName);
        setGender(characterId,gender);
    }

    public void setFirstName(String characterId,String firstName){
        this.manager.getComponentByType(characterId,Identity.class).setFirstName(firstName);
    }

    public void setLastName(String characterId,String lastName){
        this.manager.getComponentByType(characterId,Identity.class).setLastName(lastName);
    }

    public void setGender(String characterId,String gender){
        this.manager.getComponentByType(characterId,Identity.class).setGender(gender);
    }

    // ATTRIBUTES
    public void setAttributes(String characterId,int mental,int vitality,int charisma,int dexterity,int strength){
        setMental(characterId,mental);
        setVitality(characterId,vitality);
        setCharisma(characterId,charisma);
        setDexterity(characterId,dexterity);
        setStrength(characterId,strength);
    }

    public void setMental(String characterId,int mental){
        this.manager.getComponentByType(characterId,Attributes.class).setMental(mental);
    }

    public void setVitality(String characterId,int vitality){
        this.manager.getComponentByType(characterId,Attributes.class).setVitality(vitality);
    }

    public void setCharisma(String characterId,int charisma){
        this.manager.getComponentByType(characterId,Attributes.class).setCharisma(charisma);
    }

    public void setDexterity(String characterId,int dexterity){
        this.manager.getComponentByType(characterId,Attributes.class).setDexterity(dexterity);
    }

    public void setStrength(String characterId,int strength){
        this.manager.getComponentByType(characterId,Attributes.class).setStrength(strength);
        updateMaxHealth(characterId);
    }

    // MEASUREMENTS
    public void setMeasurements(String characterId,int height,int weight){
        Measurements measurements = this.manager.getComponentByType(characterId,Measurements.class);
        measurements.setHeight(height);
        measurements.setWeight(weight);
    }

}
