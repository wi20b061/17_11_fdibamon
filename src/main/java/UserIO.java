import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserIO {

    public List<Fdibamon> fdibamonSeclection(List<Fdibamon> fdibamons){
        List<Fdibamon> fdibamonSelection = new ArrayList<>();

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        int input;
        int selectedFdibamons = 0;
        int upperBound = fdibamons.size();

        while (selectedFdibamons < 2) {
            input = 0;
            printCurrentFdibamonList(fdibamons);
            System.out.printf("%nEnter your Fdibamon #%d: ", selectedFdibamons + 1);
            try {
                input = Integer.parseInt(bufferedReader.readLine());
                if (input <= 0 || input > upperBound) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ex) {
                System.out.printf("%nInvalid input, try again.%n%n");
                continue;
            }catch (IOException io){
                io.printStackTrace();
            }

            if (selectedFdibamons == 0 && input != 0) {
                fdibamonSelection.add(getFdibamonFromList(fdibamons, input));
                fdibamons.remove(input - 1);
                ++selectedFdibamons;
                continue;
            }
            fdibamonSelection.add(getFdibamonFromList(fdibamons, input));
            ++selectedFdibamons;
        }

        return fdibamonSelection;
    }

    public Fdibamon getFdibamonFromList(List<Fdibamon> fdibamons, int input) {
        Fdibamon fdibamon = fdibamons.get(input - 1);
        System.out.printf("%n%s selected!%n%n", fdibamon.getName());
        return fdibamon;
    }

    public void printCurrentFdibamonList(List<Fdibamon> fdibamons) {
        int counter = 1;
        for (Fdibamon fdibamon : fdibamons) {
            System.out.printf("ID: %d. | Name: %15s | HP: %7d | Attack Points: %7d%n",
                    counter++,
                    fdibamon.getName(),
                    fdibamon.getHitPoints(),
                    fdibamon.getAttackPower());
        }
    }
}
