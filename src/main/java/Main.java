import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        //Create List of fdibamons
        List<Fdibamon> fdibamons = createFdibamonList();

        //Create User Interface
        UserIO userIO = new UserIO();
        List<Fdibamon> fdibamonSelection = userIO.fdibamonSeclection(fdibamons);

        System.out.printf("Creating arena...:%nFighter N1: %s%nFighter N2: %s",
                fdibamonSelection.get(0).getName(),
                fdibamonSelection.get(1).getName());
    }

    private static List<Fdibamon> createFdibamonList() {
        List<Fdibamon> fdibamons = new ArrayList<>();
        fdibamons.add(new Fdibamon("Torud", 50, 20));
        fdibamons.add(new Fdibamon("Morzith", 40, 50));
        fdibamons.add(new Fdibamon("Unoth", 60, 30));
        fdibamons.add(new Fdibamon("Gandalf", 50, 40));
        fdibamons.add(new Fdibamon("Mordekeiser", 70, 70));
        return fdibamons;
    }
}