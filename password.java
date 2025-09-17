
import java.util.Scanner;

class pass {

    private String value;

    public String getvalue() {
        return value;
    }

    public boolean setvalue(String value) {

        if (PasswordValidator.isValid(value)) {
            this.value = value;
            return true;
        } else {
            return false;
        }
    }
}

class PasswordValidator {

    private static final int MIN_LENGTH = 6;

    public static boolean isValid(String password) {
        if (password == null || password.length() < MIN_LENGTH) {
            return false;
        }
        boolean hasupper = false, haslower = false, hasdigit = false, hassymboul = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasupper = true;
            } else if (Character.isLowerCase(c)) {
                haslower = true;
            } else if (Character.isDigit(c)) {
                hasdigit = true;
            } else {
                hassymboul = true;
            }

        }
        return hasupper && haslower && hasdigit && hassymboul;
    }

    public static String getRule() {
        return "Password must contain minimum " + MIN_LENGTH
                + " chars, with at least 1 Uppercase, 1 Lowercase, 1 Digit, 1 Symbol.";
    }
}

class PasswordService {

    private final Scanner sc = new Scanner(System.in);
    private final pass p = new pass();

    public String getValidPassword() {
        while (true) {
            System.out.println("Enter a password");
            String input = sc.nextLine();
            if (p.setvalue(input)) {
                return p.getvalue();
            } else {
                System.out.println("❌ Invalid password! " + PasswordValidator.getRule());
                System.out.println("Please try again.\n");
            }

        }

    }

}

public class password {

    public static void main(String[] args) {
        PasswordService service = new PasswordService();
        String validpassword = service.getValidPassword();
        System.out.println(" Password accepted: " + validpassword);
    }
}
