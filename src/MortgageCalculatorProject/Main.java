package MortgageCalculatorProject;

import java.text.NumberFormat;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main (String[] args) {
        long principle = 0;
        float rate = 0;
        int period = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Mortgage Calculator!");
//        CHECKING THE PRINCIPLE
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            long inputValue = scanner.nextLong();
            if (inputValue < 1000 || inputValue > 1000000) {
                System.out.println("Enter a number between 1,000 and 1,000,000");
            } else {
                principle = inputValue;
                break;
            }
        }
//        CHECKING THE INTEREST RATE
        while (true) {
            System.out.print("Annual interest rate: ");
            float inputValue = scanner.nextFloat();
            if (inputValue < 0 || inputValue > 30) {
                System.out.println("Enter a value greater than 0 and less than or equal to 30");
            } else {
                rate = inputValue;
                break;
            }
        }
//        CHECKING THE PERIOD
        while (true) {
            System.out.print("Period (Years): ");
            int inputValue = scanner.nextInt();
            if (inputValue < 1 || inputValue > 30) {
                System.out.println("Enter a value between 1 and 30");
            } else {
                period = inputValue;
                break;
            }
        }
        float r = (rate / 12)/100;
        int n = period * 12;
        float mortgage = (float)(principle * ((r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1)));
        String formatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("The Mortgage is: " + formatted);
    }
}
