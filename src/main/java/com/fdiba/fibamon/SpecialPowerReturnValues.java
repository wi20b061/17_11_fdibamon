package com.fdiba.fibamon;

public class SpecialPowerReturnValues {
    private Fdibamon attacker;
    private Fdibamon defender;

    public SpecialPowerReturnValues(Fdibamon attacker, Fdibamon defender){
        this.attacker = attacker;
        this.defender = defender;
    }

    public void setNewAttackerHP(int newAttackerHP) {
        attacker.setHitPoints(newAttackerHP);
    }

    public void setNewDefenerHP(int newDefenerHP) {
        defender.setHitPoints(newDefenerHP);
    }

    public Fdibamon getAttacker() {
        return attacker;
    }

    public void setAttacker(Fdibamon attacker) {
        this.attacker = attacker;
    }

    public Fdibamon getDefender() {
        return defender;
    }

    public void setDefender(Fdibamon defender) {
        this.defender = defender;
    }



}
