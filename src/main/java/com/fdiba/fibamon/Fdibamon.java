package com.fdiba.fibamon;

import com.fdiba.fibamon.attackpowers.Attackpower;
import com.fdiba.fibamon.attackpowers.Jedihealing;

public class Fdibamon {
    private String name;
    private int hitPoints;
    private int attackPower;
    //private String specialPower;
    private SpecialPowerStrategy specialPower;

    public Fdibamon(String name, int hitPoints, int attackPower) {
        this.setName(name);
        this.setHitPoints(hitPoints);
        this.setAttackPower(attackPower);
    }

    public Fdibamon(String name, int hitPoints, int attackPower, String specialPower) {
        this.setName(name);
        this.setHitPoints(hitPoints);
        this.setAttackPower(attackPower);
        this.setSpecialPower(specialPower);
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public SpecialPowerStrategy getSpecialPower() {
        return specialPower;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return;
        }
        this.name = name;
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints >= 0) {
            this.hitPoints = hitPoints;
        } else {
            this.hitPoints = 0;
        }
    }

    public void setAttackPower(int attackPower) {
        if (attackPower > 0) {
            this.attackPower = attackPower;
        }
    }

    public void setSpecialPower(String specialPower) {
        if(specialPower.equals("JEDIHEALING")) {
            this.specialPower = new Jedihealing();
        }else if(specialPower.equals("ATTACKPOWER")){
            this.specialPower = new Attackpower();
        }
    }

    @Override
    public String toString() {
        return "com.fdiba.fibamon.Fdibamon{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", attackPower=" + attackPower +
                '}';
    }
}
