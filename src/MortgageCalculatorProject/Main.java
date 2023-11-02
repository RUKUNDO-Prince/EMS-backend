package MortgageCalculatorProject;

import java.text.NumberFormat;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main (String[] args) {
        long principle = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Mortgage Calculator!");
//        System.out.print("Principal ($1K - $1M): ");
//        long inputValue = scanner.nextLong();
//        if (inputValue < 1000 || inputValue > 1000000) {
//            System.out.println("Enter a number between 1,000 and 1,000, 000");
//        } else {
//            principle = inputValue;
//        }
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            long inputValue = scanner.nextLong();
            if (inputValue < 1000 || inputValue > 1000000) {
                System.out.println("Enter a number between 1,000 and 1,000,000");
            } else {
                principle = inputValue;
                break; // Exit the loop if a valid value is provided
            }
        }
        System.out.println(principle);
        System.out.print("Annual interest rate: ");
        float rate = scanner.nextFloat();
        System.out.print("Period(years): ");
        int period = scanner.nextInt();
        float r = (rate / 12)/100;
        int n = period * 12;
        float mortgage = (float)(principle * ((r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1)));
        String formatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("The Mortgage is: " + formatted);
    }
}
