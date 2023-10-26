package variables;

import java.util.Scanner;

public class ReadingInput {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Provide your name below");
        String name =  scanner.nextLine().trim();
        System.out.println("Provide your age below");
        byte age = scanner.nextByte();
        System.out.println("Your name is " + name + " and you are " + age + " years old");
    }
}