package com.bqtn.lifesim.game.components;

import com.bqtn.lifesim.game.enums.PhysicialDamageType;

public class Weapon implements Component {
    PhysicialDamageType damageType;
    int baseDamage;

    public PhysicialDamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(PhysicialDamageType damageType) {
        this.damageType = damageType;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }
}
