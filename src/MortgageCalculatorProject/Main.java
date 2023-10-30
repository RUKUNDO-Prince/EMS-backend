package MortgageCalculatorProject;

import java.text.NumberFormat;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main (String[] args) {
//        long principal;
//        float rate;
//        int period;
//        float mortgage;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Mortgage Calculator!");
        System.out.print("Principal: ");
        long principle = scanner.nextLong();
        System.out.print("Annual interest rate: ");
        float rate = scanner.nextFloat();
        System.out.print("Period(years): ");
        int period = scanner.nextInt();
        float r = (rate / 12)/100;
        int n = period * 12;
//        float mortgage = principle * ((r*Math.pow(1+r, n))/(Math.pow(1+r, n) - 1));
        float mortgage = (float)(principle * ((r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1)));
        String formatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("The Mortgage is: " + formatted);
    }
}
