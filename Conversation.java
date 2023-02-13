/*
 * Course: CSC 120 (section 2)
 * Author: Seyeon Lim
 * Date: February 14, 2023
 * Description: a simple chatbot code for assignment 3 that mirrors user's sentences by 
 *              replacing pronouns and prints out a random canned phrase when there are 
 *              no words to replace.
 */

import java.util.Scanner;
import java.util.Random;


public class Conversation {

    // Making canned phrases
    private static String[] cannedPhrases = {
        "I see.",
        "That's interesting!",
        "Mmm-hm.",
        "Ah-ha.",
        "Uh-huh.",
        "I understand.",
        "OK."
    };

    // Changes pronouns in user's input
    private static String getResponse(String input) {
        String response = input.replace("i am", "You are");
        response = response.replace("I am", "You are");
        response = response.replace("i'm", "You're");
        response = response.replace("I'm", "You're");
        response = response.replace("im", "You're");
        response = response.replace("Im", "You're");
        response = response.replace("me", "you");
        response = response.replace("you", "I");
        response = response.replace("my", "TEMPORARY");
        response = response.replace("your", "my");
        response = response.replace("TEMPORARY", "your");
        
        
        // Adding a question mark to response when the response isn't a canned phrase
        if (response.contains("You're") || response.contains("You are") || response.contains("I") || response.contains("your") || response.contains("my")) {
            response = response.substring(0, response.length() - 1) + "?";
        }

        return response;
    }

    public static void main(String[] args) {

        // Making scanner, random, and coversation, a variable for making the transcript
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String conversation = "";

        // Asks user for number of rounds and scans the input
        System.out.print("Choose a number of rounds of conversation.\n");
        int rounds = scanner.nextInt();
        scanner.nextLine();

        // Printing a greeting message and adding that to conversation
        System.out.println("Hi there! What's on your mind?");
        conversation += "Hi there! What's on your mind?\n";

        // for statement to make the conversation run only for a given number of rounds
        for (int i = 0; i < rounds; i++) {
            String input = scanner.nextLine();
            conversation += input + "\n";

            // Printing the response that ends with a question mark,
            // which means that the response isn't a canned phrase.
            // Use random index to print out a random canned phrase.
            String response = getResponse(input);
            if (response.endsWith("?")) {
                System.out.println(response);
                conversation += response + "\n";
            } else {
                int index = random.nextInt(cannedPhrases.length);
                System.out.println(cannedPhrases[index]);
                conversation += cannedPhrases[index] + "\n";
            }
        }

        // Print transcript.
        System.out.println("Goodbye! Here is a transcript of our conversation:\n==========\nTRANSCRIPT\n==========\n" + conversation);
    }
}
