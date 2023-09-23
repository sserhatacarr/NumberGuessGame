import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int number = rand.nextInt(100);
        // Generate a random number between 0 and 99.

        Scanner input = new Scanner(System.in);
        int right = 0;  // Initialize the right guess count.
        int selected;
        int[] wrong = new int[5];  // Array to store wrong guesses.
        boolean isWin = false;  // Variable to track if the game is won.
        boolean isWrong = false;  // Variable to track if a wrong input is given.

        while (right < 5) {
            System.out.print("Please enter your guess: ");
            // Prompt the user to enter their guess.

            selected = input.nextInt();

            if (selected < 0 || selected > 99) {
                System.out.println("Please enter a value between 0-100.");
                // If the input is out of range, prompt the user to enter a valid value.

                if (isWrong) {
                    right++;
                    System.out.println("You made too many wrong inputs. Remaining attempts: " + (5 - right));
                } else {
                    isWrong = true;
                    System.out.println("Your attempts will be deducted for any further wrong inputs.");
                }
                // If consecutive wrong inputs are given, deduct attempts.

                continue;
            }

            if (selected == number) {
                System.out.println("Congratulations, correct guess! The guessed number is: " + number);
                isWin = true;
                break;
            } else {
                System.out.println("You entered a wrong number!");
                // Inform the user about a wrong input.

                if (selected > number) {
                    System.out.println(selected + " is greater than the secret number.");
                } else {
                    System.out.println(selected + " is less than the secret number.");
                }
                // Provide a hint based on the input.

                wrong[right++] = selected;
                System.out.println("Remaining attempts: " + (5 - right));
                // Store the wrong input and display the remaining attempts.
            }
        }

        if (!isWin) {
            System.out.println("You lost!");
            // If the user couldn't guess the correct number within the attempts, inform about the loss.

            if (!isWrong) {
                System.out.println("Your guesses: " + Arrays.toString(wrong));
                // If there were no wrong inputs, display the guesses made.
            }
        }
    }
}
