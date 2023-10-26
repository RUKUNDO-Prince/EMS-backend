package variables;

import java.util.Scanner;

public class ReadingInput {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte age = scanner.nextByte();
        System.out.println("You are " + age + " years old");
    }
}
