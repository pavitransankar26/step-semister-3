import java.util.Random;
import java.util.Scanner;

public class PracticeQuestion1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"Rock", "Paper", "Scissors"};

        System.out.println("Rock Paper Scissors Game");

        System.out.print("Enter your choice (Rock/Paper/Scissors): ");
        String userChoice = scanner.nextLine();

        String computerChoice = choices[random.nextInt(3)];

        System.out.println("Computer chose: " + computerChoice);

        if (userChoice.equalsIgnoreCase(computerChoice)) {
            System.out.println("It's a Draw!");
        } 
        else if (
            (userChoice.equalsIgnoreCase("Rock") && computerChoice.equals("Scissors")) ||
            (userChoice.equalsIgnoreCase("Paper") && computerChoice.equals("Rock")) ||
            (userChoice.equalsIgnoreCase("Scissors") && computerChoice.equals("Paper"))
        ) {
            System.out.println("You Win!");
        } 
        else {
            System.out.println("Computer Wins!");
        }

        scanner.close();
    }
}
