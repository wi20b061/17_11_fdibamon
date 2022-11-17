import java.security.InvalidParameterException;

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
        validateName(name);
        this.name = name;
    }

    private void setHitPoints(int hitPoints) {
        validateHitPoints(hitPoints);
        this.hitPoints = hitPoints;
    }

    private void setAttackPower(int attackPower) {
        validateAttackPower(attackPower);
        this.attackPower = attackPower;
    }

    private void validateName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new InvalidParameterException();
        }
    }

    private void validateHitPoints(int hitPoints) {
        if(hitPoints < 0) {
            throw new InvalidParameterException();
        }
    }

    private void validateAttackPower(int attackPower) {
        if(attackPower < 0) {
            throw new InvalidParameterException();
        }
    }
}
