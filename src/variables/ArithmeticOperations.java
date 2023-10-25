package variables;

public class ArithmeticOperations {
    public static void main (String args) {
        int result = 10 + 3;
        int result2 = 10 - 3;
        int result3 = 10 * 3;
        double result4 = (double)10 / (double)3;  // Casting them to doubles
        System.out.println(result4);

        // INCREMENT AND DECREMENT
        int x = 1;
        x++; // Evaluates to 2
        int y = x++; // y = 2 while x = 3
        int z = ++x; // z = 4 while x = 4 as well
        // Decrement is also the same
        System.out.println(z);
    }
}