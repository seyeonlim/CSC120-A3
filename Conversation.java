import java.util.Scanner;
import java.util.Random;

public class Conversation {
    private static String[] cannedPhrases = {
        "I see.",
        "That's interesting!",
        "Mmm-hm.",
        "Ah-ha.",
        "Uh-huh.",
        "I understand.",
        "OK."
    };

    private static String getResponse(String input) {
        String response = input.replace("i am", "You are");
        response = response.replace("I am", "You are");
        response = response.replace("i'm", "You're");
        response = response.replace("I'm", "You're");
        response = response.replace("im", "You're");
        response = response.replace("Im", "You're");
        response = response.replace("me", "you");
        response = response.replace("you", "I");
        response = response.replace("my", "your");
        response = response.replace("your", "my");

        if (response.contains("You're") || response.contains("You are") || response.contains("I") || response.contains("your") || response.contains("my")) {
            response = response.substring(0, response.length() - 1) + "?";
        }

        return response;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String conversation = "";

        System.out.print("Choose a number of rounds of conversation.\n");
        int rounds = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Hi there! What's on your mind?");
        conversation += "Hi there! What's on your mind?\n";

        for (int i = 0; i < rounds; i++) {
            String input = scanner.nextLine();
            conversation += input + "\n";

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

        System.out.println("Goodbye! Here is a transcript of our conversation:\n==========\nTRANSCRIPT\n==========\n" + conversation);
    }
}
