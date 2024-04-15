package com.bqtn.lifesim.game.components;

public class Health implements Component {
    int hp;
    int maxHealthPoints;
    boolean isBleeding;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHealthPoints(){
        return maxHealthPoints;
    }

    public void setMaxHealthPoints(int maxHealthPoints){
        this.maxHealthPoints = maxHealthPoints;
    }

    public void setBleeding(Boolean bool){
        isBleeding = bool;
    }

    public Boolean isBleeding(){
        return isBleeding;
    }

}
