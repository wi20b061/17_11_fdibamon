import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserIO {
    public static List<String> consoleOut = new ArrayList<>();

    public List<Fdibamon> fdibamonSeclection(List<Fdibamon> fdibamons) {
        List<Fdibamon> fdibamonSelection = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int input;
        int selectedFdibamons = 0;
        int upperBound;

        while (selectedFdibamons < 2) {
            printCurrentFdibamonList(fdibamons);
            upperBound = fdibamons.size();
            System.out.printf("%nEnter your Fdibamon #%d: ", selectedFdibamons + 1);
            try {
                input = Integer.parseInt(bufferedReader.readLine());
                if (input <= 0 || input > upperBound) {
                    throw new IllegalArgumentException();
                }

                if (selectedFdibamons == 0) {
                    fdibamonSelection.add(getFdibamonFromListAndPrintIt(fdibamons, input));
                    fdibamons.remove(input - 1);
                    ++selectedFdibamons;
                    continue;
                }
                fdibamonSelection.add(getFdibamonFromListAndPrintIt(fdibamons, input));
                ++selectedFdibamons;
            } catch (IllegalArgumentException ex) {
                System.out.printf("%nInvalid input, try again.%n%n");
            } catch (IOException io) {
                io.printStackTrace();
            }

        }
        printSelectedFdibamons(fdibamonSelection);
        return fdibamonSelection;
    }

    private Fdibamon getFdibamonFromListAndPrintIt(List<Fdibamon> fdibamons, int input) {
        Fdibamon fdibamon = fdibamons.get(input - 1);
        System.out.printf("%n%s selected!%n%n", fdibamon.getName());
        return fdibamon;
    }

    private void printCurrentFdibamonList(List<Fdibamon> fdibamons) {
        int counter = 1;
        for (Fdibamon fdibamon : fdibamons) {
            System.out.printf("ID: %d. | Name: ", counter++);
            printFdibamon(fdibamon);
        }
    }

    private void printSelectedFdibamons(List<Fdibamon> fdibamonSelection) {
        System.out.printf("Your Selected Fighters:%nFighter 1: ");
        printFdibamon(fdibamonSelection.get(0));
        consoleOut.add(String.format("Your Selected Fighters:%nFighter 1: %s", printFdibamon(fdibamonSelection.get(0))));

        System.out.print("Fighter 2: ");
        printFdibamon(fdibamonSelection.get(1));
        consoleOut.add(String.format("Fighter 2: %s", printFdibamon(fdibamonSelection.get(1))));
    }

    private String printFdibamon(Fdibamon fdibamon) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%15s | HP %7d | Attack Points %7d%n",
                fdibamon.getName(),
                fdibamon.getHitPoints(),
                fdibamon.getAttackPower()));
        System.out.print(sb);
        return sb.toString();
    }

    public void printFightRound(int round, Fdibamon firstFdibamon, Fdibamon secondFdibamon) {
        System.out.printf("Round %d:%n", round);
        consoleOut.add(String.format("Round %d:%n", round));
        consoleOut.add(printFdibamon(firstFdibamon));
        consoleOut.add(printFdibamon(secondFdibamon));
    }

    public void printEndOfGame() {
        System.out.printf("%n -------------- The Game has Ended! -------------- %n");
        consoleOut.add(String.format("%n -------------- The Game has Ended! -------------- %n"));
    }

    public void printDraw(Fdibamon firstFdibamon, Fdibamon secondFdibamon) {
        System.out.printf("%nIt's a Draw! Both Fighters are at 0 HP%n");
        consoleOut.add("%nIt's a Draw! Both Fighters are at 0 HP%n");
        consoleOut.add(printFdibamon(firstFdibamon));
        consoleOut.add(printFdibamon(secondFdibamon));
    }

    public void printWinner(int winnerNumber, Fdibamon winnerFdibamon, Fdibamon loserFdibamon) {
        System.out.printf("%nThe Winner is Fighter %d (%s)!%n",
                winnerNumber, winnerFdibamon.getName());
        System.out.print("Winner: ");
        consoleOut.add(String.format("Winner: %s", printFdibamon(winnerFdibamon)));
        System.out.print("Loser:  ");
        consoleOut.add(String.format("Loser: %s", printFdibamon(loserFdibamon)));
        System.out.println();
    }
}
