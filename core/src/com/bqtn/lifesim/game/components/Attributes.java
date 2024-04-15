package com.bqtn.lifesim.game.components;

public class Attributes implements Component {

    private int mental;
    private int vitality;
    private int charisma;
    private int dexterity;
    private int strength;

    public int getMental() {
        return mental;
    }

    public void setMental(int mental) {
        this.mental = mental;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}
