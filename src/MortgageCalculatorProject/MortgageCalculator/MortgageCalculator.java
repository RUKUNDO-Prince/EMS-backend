package MortgageCalculatorProject.MortgageCalculator;

import java.text.NumberFormat;

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
        System.out.println("Month\tPayment\tPrincipal\tInterest\tBalance");

        int totalNumberOfPayments = getTotalNumberOfPayments();
        for (int month = 1; month <= totalNumberOfPayments; month++) {
            double balance = calculateBalance(month);
            double interest = (balance * getMonthlyInterest());
            double principalPayment = calculateMortgage() - interest;

            System.out.println(month + "\t" + currency.format(calculateMortgage()) + "\t"
                    + currency.format(principalPayment) + "\t" + currency.format(interest) + "\t" + currency.format(balance));
        }
    }

    private int getTotalNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    public static void main(String[] args) {
        MortgageCalculator calculator = new MortgageCalculator(100000, 5.5f, 1);
        double mortgage = calculator.calculateMortgage();
        System.out.println("Monthly Mortgage Payment: " + NumberFormat.getCurrencyInstance().format(mortgage));

        calculator.printPaymentSchedule();
    }
}
