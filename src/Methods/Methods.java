package Methods;

public class Methods {
    public static void main (String[] args) {
//        greetUser("Prince", "RUKUNDO");
        String message = greetUser("Prince", "RUKUNDO");
        System.out.println(message);
    }
    public static String greetUser (String firstName, String lastName) {
//        System.out.println("Hello " + firstName + " " + lastName);
        return "Hello " + firstName + " " + lastName;
    }
}
