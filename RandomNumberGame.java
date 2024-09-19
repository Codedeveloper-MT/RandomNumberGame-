package randomnumbers;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int roundsWon = 0;
        boolean playAgain;

        do {
            int min = 1;
            int max = 100;
            int numberToGuess = random.nextInt((max - min) + 1) + min;
            int maxAttempts = 5;
            int attempts = 0;
            boolean isCorrect = false;

            System.out.println("Guess the number between " + min + " and " + max + "!");

            while (attempts < maxAttempts && !isCorrect) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    isCorrect = true;
                    roundsWon++;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

                if (!isCorrect && attempts < maxAttempts) {
                    System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
                }
            }

            if (!isCorrect) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("You won " + roundsWon + " round(s).");
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
