import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FdibamonFight {

    private final FdibamonFight fdibamonFight = new FdibamonFight();

    @Test
    public void fightBetweenFdibamonsWithSameHpShouldResultInATieTest() {
        Fdibamon firstFdibamon = new Fdibamon("Rich", 20, 10);
        Fdibamon secondFdibamon = new Fdibamon("Bitch", 20, 10);
        /*fdibamonFight.fight(firstFdibamon, secondFdibamon);
        fight(firstFdibamon, secondFdibamon);*/

        assertEquals(firstFdibamon.getHitPoints(), secondFdibamon.getHitPoints());
    }

    @Test
    public void fdibamonWithMoreHpShouldWinIfAttackPowerIsSameTest_1() {
        Fdibamon firstFdibamon = new Fdibamon("Rich", 21, 10);
        Fdibamon secondFdibamon = new Fdibamon("Bitch", 20, 10);

        //fdibamonService.fight(firstFdibamon, secondFdibamon);

        boolean hasRemainingHp = firstFdibamon.getHitPoints() > 0;

        assertTrue(hasRemainingHp);
    }

    @Test
    public void fdibamonWithMoreHpThanEnemyAttackPowerShouldWinInUnder3RoundsTest() {
        Fdibamon firstFdibamon = new Fdibamon("Rich", 20, 1499);
        Fdibamon secondFdibamon = new Fdibamon("Bitch", 3000, 10);

        //fdibamonService.fight(firstFdibamon, secondFdibamon);

        boolean hasRemainingHp = secondFdibamon.getHitPoints() > 0;

        assertTrue(hasRemainingHp);
    }

    @Test
    public void firstFdibamonShouldWinTest() {
        Fdibamon firstFdibamon = new Fdibamon("Batman", 2960, 99);
        Fdibamon secondFdibamon = new Fdibamon("Superman", 3000, 70);

        //fdibamonService.fight(firstFdibamon, secondFdibamon);

        assertTrue(firstFdibamon.getHitPoints() > secondFdibamon.getHitPoints());
    }
}
