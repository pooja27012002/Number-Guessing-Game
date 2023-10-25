import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            playRandomNumberGame(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thank you for playing. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    public static void playRandomNumberGame(Scanner scanner) {
        Random random = new Random();
        int min = 1;
        int max = 100;
        int randomNumber = random.nextInt(max - min + 1) + min;

        int guess;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Random Number Game!");
        System.out.println("I've selected a random number between 1 and 100. Try to guess it.");

        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < min || guess > max) {
                System.out.println("Please enter a number between 1 and 100.");
            } else if (guess < randomNumber) {
                System.out.println("Try a higher number.");
            } else if (guess > randomNumber) {
                System.out.println("Try a lower number.");
            } else {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You guessed the correct number: " + randomNumber);
                System.out.println("Number of attempts: " + attempts);
            }
        }
    }
}
