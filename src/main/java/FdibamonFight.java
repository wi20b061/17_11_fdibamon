import java.util.List;

public class FdibamonFight {
    static Fdibamon firstFdibamon;
    static Fdibamon secondFdibamon;
    static UserIO userIO = new UserIO();

    //Constructor
    public FdibamonFight(List<Fdibamon> fdibamonSelection) {
        if (fdibamonSelection != null && fdibamonSelection.size() == 2) {
            firstFdibamon = fdibamonSelection.get(0);
            secondFdibamon = fdibamonSelection.get(1);
        }
    }

    //fight: each fdibamon is a defender and an attacker at the same time, so the attack goes both ways
    //       fight goes on until on fdibamon has 0 HP
    public void fight() {
        int round = 0;
        int winner = 0;
        //fight round with changes of fighters HP
        while (winner == 0) {
            round++;
            fightRound();
            //print current fight round
            userIO.printFightRound(round, firstFdibamon, secondFdibamon);
            //check if there is a winner
            winner = checkwinner();
        }
        userIO.printEndOfGame();
        if (winner == 3) {
            userIO.printDraw(firstFdibamon, secondFdibamon);
        } else if (winner == 1) {
            userIO.printWinner(winner, firstFdibamon, secondFdibamon);
        } else if (winner == 2) {
            userIO.printWinner(winner, secondFdibamon, firstFdibamon);
        }
    }

    private int checkwinner() {
        //both have 0 HP -> it's a draw
        if (firstFdibamon.getHitPoints() == 0 && secondFdibamon.getHitPoints() == 0) {
            return 3;
        }
        //fighter 1 has 0 HP -> fighter 2 wins
        else if (firstFdibamon.getHitPoints() == 0) {
            return 2;
        }
        //fighter 2 hast 0 HP -> fighter 1 wins
        else if (secondFdibamon.getHitPoints() == 0) {
            return 1;
        }
        //both fighters have HP > 0 -> fight continuous
        return 0;
    }

    //both fdibamons attack the other one
    private void fightRound() {
        firstFdibamon.setHitPoints(firstFdibamon.getHitPoints() - secondFdibamon.getAttackPower());
        secondFdibamon.setHitPoints(secondFdibamon.getHitPoints() - firstFdibamon.getAttackPower());
    }

}
