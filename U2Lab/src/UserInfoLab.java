import java.util.Scanner;

public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter Your first name :");
        String firstName = keyboard.nextLine();

        System.out.print("Enter Your last name :");
        String lastName = keyboard.nextLine();

        String username = generateUsername(firstName, lastName);

        // Part 2
        System.out.print("Enter a Password: ");
        String password = keyboard.nextLine();

        // Part 3
        if (validatePassword(password)) {
            System.out.print("Enter your 16-digit credit card number: ");
            String creditCardNumber = keyboard.nextLine();

            String maskedCard = maskCreditCard(creditCardNumber);

            // Part 4
            if (!maskedCard.equals("N/A")) {
                System.out.println("Username: " + username);
                System.out.println("Password : Valid");
                System.out.println("Credit Card: " + maskedCard);
            }
            else {
                System.out.println("Invalid credit card number: N/A");
            }
        }
    }

    /**
     * Creates a lowercase username using up to three letters from each name.
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @return the generated username
     */
    public static String generateUsername(String firstName, String lastName) {
        if (firstName.length() > 3){
            firstName = firstName.substring(0, 3);
        }

        if (lastName.length() > 3){
            lastName = lastName.substring(0, 3);
        }

        return (firstName + lastName).toLowerCase();
    }

    /**
     * Checks all password rules and prints each failed rule.
     * @param password the password to check
     * @return true if the password meets every rule, otherwise false
     */
    public static boolean validatePassword(String password) {
        boolean valid = true;

        if (password.length() < 8){
            System.out.println("Password should be atleast 8 characters long.");
            valid = false;
        }

        if (password.equals(password.toLowerCase())) {
            System.out.println("Password should contain atleast one uppercase letter.");
            valid = false;
        }

        if (!containsDigit(password)) {
            System.out.println("Password should contain at least one digit.");
            valid = false;
        }

        return valid;
    }

    /**
     * Checks for exactly 16 digits and hides all but the last four.
     * @param creditCardNumber the credit card number to check
     * @return the masked number, or "N/A" if invalid
     */
    public static String maskCreditCard(String creditCardNumber) {
        if (creditCardNumber.length() == 16 && allDigits(creditCardNumber)) {
            return "**** **** **** " + creditCardNumber.substring(12);
        }

        return "N/A";
    }

    /**
     * This method verifies that the string contains at least one numeric digit.
     * @param str the string to check
     * @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical.
     * @param str the string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
}