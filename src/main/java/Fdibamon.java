public class Fdibamon {
    private String name;
    private int hitPoints;
    private int attackPower;

    public Fdibamon(String name, int hitPoints, int attackPower) {
        this.setName(name);
        this.setHitPoints(hitPoints);
        this.setAttackPower(attackPower);
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

    @Override
    public String toString() {
        return "Fdibamon{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", attackPower=" + attackPower +
                '}';
    }

}
