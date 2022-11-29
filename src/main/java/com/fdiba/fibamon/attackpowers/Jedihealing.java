package com.fdiba.fibamon.attackpowers;

import com.fdiba.fibamon.Fdibamon;
import com.fdiba.fibamon.SpecialPowerReturnValues;
import com.fdiba.fibamon.SpecialPowerStrategy;

public class Jedihealing implements SpecialPowerStrategy {
    @Override
    public void useSpecialPower(Fdibamon attacker, Fdibamon defender) {
        SpecialPowerReturnValues specialPowerReturnValues = new SpecialPowerReturnValues(attacker, defender);
        specialPowerReturnValues.setNewAttackerHP(attacker.getHitPoints() + (3 * attacker.getAttackPower()));
    }

    @Override
    public String toString() {
        return "JEDIHEALING";
    }
}
