package com.fdiba.fibamon;

import com.fdiba.fibamon.attackpowers.Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserIO {
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
                    //fdibamons.remove(input - 1);
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
        Fdibamon fdibamonCopy = fdibamon.clone();
        System.out.printf("%n%s selected!%n%n", fdibamonCopy.getName());
        return fdibamonCopy;
    }

    private void printCurrentFdibamonList(List<Fdibamon> fdibamons) {
        int counter = 1;
        for (Fdibamon fdibamon : fdibamons) {
            System.out.printf("ID: %d. | Name: ", counter++);
            System.out.print(printFdibamon(fdibamon));
        }
    }

    private void printSelectedFdibamons(List<Fdibamon> fdibamonSelection) {
        Logger.log(String.format("Your Selected Fighters:%nFighter 1: %s", printFdibamon(fdibamonSelection.get(0))));
        Logger.log(String.format("Fighter 2: %s", printFdibamon(fdibamonSelection.get(1))));
    }

    private String printFdibamon(Fdibamon fdibamon) {
        return String.format("%15s | HP %7d | Attack Points %7d | Special Power %15s%n",
                fdibamon.getName(),
                fdibamon.getHitPoints(),
                fdibamon.getAttackPower(),
                fdibamon.getSpecialPower());
    }

    public void printFightRound(int round, Fdibamon firstFdibamon, Fdibamon secondFdibamon) {
        Logger.log(String.format("Round %d:%n%s%s",
                round,
                printFdibamon(firstFdibamon),
                printFdibamon(secondFdibamon)));
    }

    public void printFightRoundWithSpecialPowersUsed(int round, Fdibamon firstFdibamon, Fdibamon secondFdibamon) {

        Logger.log(String.format(
                "Round %d:%n"
                        + "%s%s"
                        + "%n\t\t=====SPECIAL POWERS HAVE BEEN USED=====%n"
                        + "\t\t%s used special power: %s%n"
                        + "\t\t%s used special power: %s%n"
                        + "\t\t=======================================%n",
                round, printFdibamon(firstFdibamon), printFdibamon(secondFdibamon),
                firstFdibamon.getName(), firstFdibamon.getSpecialPower(),
                secondFdibamon.getName(), secondFdibamon.getSpecialPower())
        );
    }

    public void printEndOfGame() {
        Logger.log(String.format("%n -------------- The Game has Ended! -------------- %n"));
    }

    public void printDraw(Fdibamon firstFdibamon, Fdibamon secondFdibamon) {
        Logger.log(String.format("%nIt's a Draw! Both Fighters are at 0 HP%n%s%s",
                printFdibamon(firstFdibamon),
                printFdibamon(secondFdibamon)));
    }

    public void printWinner(int winnerNumber, Fdibamon winnerFdibamon, Fdibamon loserFdibamon) {
        Logger.log(String.format(
                "The Winner is Fighter %d (%s)!%n"
                        + "Winner:%s"
                        + "Loser: %s",
                winnerNumber, winnerFdibamon.getName(), printFdibamon(winnerFdibamon), printFdibamon(loserFdibamon)));
    }

    public void printSpecialPowersUsage(Fdibamon firstFdibamon, Fdibamon secondFdibamon, int specialPowersUsageCounter){
        Logger.log(String.format(
                "%n%s used their special power %d time(s)%n" +
                        "%s used their special power %d time(s)%n",
                firstFdibamon.getName(), specialPowersUsageCounter,
                secondFdibamon.getName(), specialPowersUsageCounter));
    }
}
