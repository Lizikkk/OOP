package quizes.q2.lizi_zarkua_1.scissors;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CoffeeShop {

    public static void main(String[] args) {
        int pricePerCoffee = 250; // tetri
        int numCoffeeSold = 100;
        int totalCostOfBeans = 15000; // tetri
        int otherExpenses = readExpensesFromFile("expenses.txt");
        
        double profit = calculateProfit(pricePerCoffee, numCoffeeSold, totalCostOfBeans, otherExpenses);
        System.out.println("Profit: " + profit + " Laris");
    }

    public static int readExpensesFromFile(String fileName) {
        int totalExpenses = 0;
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                totalExpenses += scanner.nextInt();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        return totalExpenses;
    }

    public static double calculateProfit(int pricePerCoffee, int numCoffeeSold, int totalCostOfBeans, int otherExpenses) {
        int totalRevenue = pricePerCoffee * numCoffeeSold;
        int totalCost = totalCostOfBeans + otherExpenses;
        double profitInTetri = totalRevenue - totalCost;
        // Convert profit from Tetri to Laris (1 Lari = 100 Tetri)
        double profitInLaris = profitInTetri / 100;
        return profitInLaris;
    }
}
