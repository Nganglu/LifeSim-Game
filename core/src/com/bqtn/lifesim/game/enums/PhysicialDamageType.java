package com.bqtn.lifesim.game.enums;

public enum PhysicialDamageType {
    BLUNT(1.0,false),
    CUTTING(1.5,true),
    PIERCING(2.0,true);

    final double damageModifier;
    final boolean causesBleeding;

    PhysicialDamageType(double damageModifier,boolean causesBleeding){
        this.damageModifier = damageModifier;
        this.causesBleeding = causesBleeding;
    }

    public double getDamageModifier() {
        return damageModifier;
    }

    public boolean causesBleeding() {
        return causesBleeding;
    }
}
