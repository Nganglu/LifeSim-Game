package com.bqtn.lifesim.game.enums;

public enum EntityType {
    CHARACTER("character","CHAR"),
    ITEM("item","ITEM"),
    NONE("none","404");

    private final String name;
    private final String idShort;

    private EntityType(String name,String idShort){
        this.name = name;
        this.idShort = idShort;
    }

    public String getName(){
        return name;
    }

    public String getIdShort(){
        return idShort;
    }
}
