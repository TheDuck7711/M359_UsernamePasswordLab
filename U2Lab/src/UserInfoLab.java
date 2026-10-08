import java.util.Scanner;

public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your first name");
        String firstName = scan.nextLine();
        System.out.println("Enter your last name");
        String lastName = scan.nextLine();

        String username = generateUsername(firstName, lastName);

        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:
        System.out.println("Enter a password");
        boolean validPassword = validatePassword(scan.nextLine());

        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.
        String creditCardnumber = "";
        if(validPassword){
            System.out.println("Enter your credit card number");
            creditCardnumber = scan.nextLine();
            creditCardnumber = maskCreditCard(creditCardnumber);

        }
        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing
        if(validPassword && !(creditCardnumber.equals("NaN"))){
            System.out.println("Final Details:");
            System.out.println("Username:   " + username);
            System.out.println("Credit Card: " + creditCardnumber);
        }

    }

    public static String generateUsername(String firstName, String lastName) {
        // Fill in this method and return an appropriate username
        int a = 3;
        int b = 3;
        if(firstName.length()<3){
            a = firstName.length();
        }
        if(lastName.length()<3){
            b = lastName.length();
        }
        String output = firstName.substring(0,a).toLowerCase() + lastName.substring(0,b).toLowerCase();
        return output;
    }

    public static boolean validatePassword(String password) {
        // Fill in this method and return true/false if the password is valid
        if(password.length() < 8){
            System.out.println("Password under 8 characters");
            return false;
        }
        if(password.toLowerCase().equals(password)){
            System.out.println("Password does not contain an uppercase");
            return false;
        }
        if(!(containsDigit(password))){
            System.out.println("Password does not contain a digit");
        }
        return true;
    }

    public static String maskCreditCard(String creditCardNumber) {
        // Fill in this method and if the credit card is valid, return a masked CC
        if(creditCardNumber.length() != 16){
            return "NaN";
        }

        return ("**** **** **** " + creditCardNumber.substring(11));
    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}
