import java.util.Scanner;
import java.util.Random;

class Conversation {

  public static void main(String[] arguments) 
  {
  
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    String[] cannedPhrases =
    {
      "I see.",
      "That's interesting!",
      "Mmm-hm.",
      "Ah-ha.",
      "Uh-huh.",
      "I understand.",
      "OK."
    };

    System.out.println("Choose a number of rounds of conversation.");
    int numOfRounds = input.nextInt();

    System.out.println("Hi there! What's on your mind?");
    

    for (int i = 1; i <= numOfRounds; i++)
    {
      String userInput = input.nextLine();
      userInput = userInput.replace(".", "?")
      String response = "";

      if (userInput.contains("I"))
      {
        response = userInput.replaceFirst("I", "You");
      }
      else if (userInput.contains("me"))
      {
        response = userInput.replaceFirst("me", "you");
      }
      else if (userInput.contains("am"))
      {
        response = userInput.replaceFirst("am", "are");
      }
      else if (userInput.contains("you"))
      {
        response = userInput.replaceFirst("you", "I");
      }
      else if (userInput.contains("my"))
      {
        response = userInput.replaceFirst("my", "your");
      }
      else if (userInput.contains("your"))
      {
        response = userInput.replaceFirst("your", "my");
      }
      else
      {

      }
    }

    input.close();
  }
}
