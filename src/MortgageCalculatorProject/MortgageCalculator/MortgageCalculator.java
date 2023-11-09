package MortgageCalculatorProject.MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {

    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private int years;

    public MortgageCalculator(int principal, float annualInterest, int years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(int numberOfPaymentsMade) {
        float monthlyInterest = getMonthlyInterest();
        int totalNumberOfPayments = getTotalNumberOfPayments();

        double balance = principal * (Math.pow(1 + monthlyInterest, totalNumberOfPayments) - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1 + monthlyInterest, totalNumberOfPayments) - 1);

        return balance;
    }

    public double calculateMortgage() {
        float monthlyInterest = getMonthlyInterest();
        int totalNumberOfPayments = getTotalNumberOfPayments();

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, totalNumberOfPayments))
                / (Math.pow(1 + monthlyInterest, totalNumberOfPayments) - 1);

        return mortgage;
    }

    public void printPaymentSchedule() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("Payment Schedule:");
        System.out.println("Month\t\tPayment\t\tPrincipal\t\tInterest\t\tBalance");

        int totalNumberOfPayments = getTotalNumberOfPayments();
        for (int month = 1; month <= totalNumberOfPayments; month++) {
            double balance = calculateBalance(month);
            double interest = (balance * getMonthlyInterest());
            double principalPayment = calculateMortgage() - interest;

            System.out.printf("%-6s\t%-15s\t%-15s\t%-15s\t%-15s\n", month + ".", currency.format(calculateMortgage()),
                    currency.format(principalPayment), currency.format(interest), currency.format(balance));
        }
    }

    private int getTotalNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    public static void main(String[] args) {
        int principal;
        float annualInterest;
        int years;

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter the principal: ");
            principal = scanner.nextInt();

            if (principal < 1000 || principal > 1000000) {
                System.out.println("Principal should be between 1000 and 1000000.");
            }
        } while (principal < 1000 || principal > 1000000);

        do {
            System.out.print("Enter the annual interest: ");
            annualInterest = scanner.nextFloat();

            if (annualInterest < 0 || annualInterest > 30) {
                System.out.println("Annual interest should be greater than 0 and less than 30");
            }
        } while (annualInterest < 0 || annualInterest > 30);

        do {
            System.out.print("Enter the period (Years): ");
            years = scanner.nextInt();

            if (years < 1 || years > 30) {
                System.out.println("Years should be greater than 1 and less than 30");
            }
        } while (years < 1 || years > 30);

        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterest, years);
        double mortgage = calculator.calculateMortgage();
        System.out.println("Monthly Mortgage Payment: " + NumberFormat.getCurrencyInstance().format(mortgage));

        calculator.printPaymentSchedule();
    }
}
