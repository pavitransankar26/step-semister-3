import java.util.Scanner;

public class PracticeQuestion5 {

    public static String reverseCustomerName(String customerName) {

        String reversedName = "";

        for (int i = customerName.length() - 1; i >= 0; i--) {
            reversedName += customerName.charAt(i);
        }

        return reversedName;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        scanner.close();
    }
}
