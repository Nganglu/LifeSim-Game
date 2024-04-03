package com.bqtn.world;

public enum LocationType {
    GENERIC("Generic"),
    HOUSE("House"),
    SHOP("Shop");

    private String type;

    LocationType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
