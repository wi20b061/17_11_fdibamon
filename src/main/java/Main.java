import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Logger logger = new Logger();

        //Create User Interface
        UserIO userIO = new UserIO();

        //Create List of fdibamons to choose from
        List<Fdibamon> fdibamons = createFdibamonList();

        //User-Selection-Process for the 2 Player-Fdibamons
        List<Fdibamon> fdibamonSelection = userIO.fdibamonSeclection(fdibamons);
        //Create FdibamonFight Arena
        FdibamonFight fdibamonFight = new FdibamonFight(fdibamonSelection);
        //let the fight begin!
        fdibamonFight.fight();

        try {
            logger.createReport(FdibamonFight.firstFdibamon, FdibamonFight.secondFdibamon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Fdibamon> createFdibamonList() {
        List<Fdibamon> fdibamons = new ArrayList<>();
        fdibamons.add(new Fdibamon("Torud", 450, 20, "JEDIHEALING"));
        fdibamons.add(new Fdibamon("Morzith", 350, 35, "ATTACKPOWER"));
        fdibamons.add(new Fdibamon("Unoth", 150, 45, "JEDIHEALING"));
        fdibamons.add(new Fdibamon("Gandalf", 250, 40, "JEDIHEALING"));
        fdibamons.add(new Fdibamon("Mordekeiser", 350, 25, "ATTACKPOWER"));
        return fdibamons;
    }
}