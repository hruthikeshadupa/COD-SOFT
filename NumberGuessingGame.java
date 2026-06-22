import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        String playAgain;

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {
            int number = random.nextInt(100) + 1; // Random number between 1 and 100
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nI have chosen a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == number) {
                    System.out.println("Congratulations! You guessed the correct number.");

                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;

                    System.out.println("Attempts taken: " + attempts);
                    System.out.println("Score earned: " + roundScore);

                    guessed = true;
                    break;
                } else if (guess > number) {
                    System.out.println("Too High!");
                } else {
                    System.out.println("Too Low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessed) {
                System.out.println("\nYou have used all your attempts.");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n===== GAME OVER =====");
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thank you for playing!");

        sc.close();
    }
}