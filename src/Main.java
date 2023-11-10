public class Main {
    public static void main(String[] args) {
        System.out.printf("%-15s%-10s%-5s%n", "Names", "Gender", "Age");
        String[] names = {"Ange", "John"};
        char[] genders = {'F', 'M'};
        int[] ages = {25, 30};
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-15s%-10c%-5d%n", names[i], genders[i], ages[i]);
        }
    }
}