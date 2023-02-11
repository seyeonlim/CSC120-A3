import java.util.Scanner;
import java.util.Random;

class Conversation {

  public static void main(String[] arguments) 
  {
  
    Scanner input = new Scanner(System.in);
    Random random = new Random(); //generates random numbers

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
    input.nextLine();
    System.out.println("Hi there! What's on your mind?");

    String[] transcript = new String[2 * numOfRounds + 1];
    transcript[0] = "Hi there! What's on your mind?";
    int nextIndex = 1;

    for (int i = 1; i <= numOfRounds; i++)
    {
      String userInput = input.nextLine();
      // userInput = userInput.replace(".", "?");
      String response = "";

      if (userInput.contains("I am"))
      {
        response = userInput.replaceFirst("I am", "You are");
      }
      else if (userInput.contains("I'm"))
      {
        response = userInput.replaceFirst("I'm", "You're");
      }
      else if (userInput.contains("I"))
      {
        response = userInput.replaceFirst("I", "You");
      }
      else if (userInput.contains("me"))
      {
        response = userInput.replaceFirst("me", "you");
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
        int randomIndex = random.nextInt(cannedPhrases.length);
        response = cannedPhrases[randomIndex];
      }


      System.out.println(response.substring(0, response.length() - 1) + "?");
      transcript[nextIndex] = userInput;
      nextIndex++;
      transcript[nextIndex] = response.substring(0, response.length() - 1) + "?";
      nextIndex++;

    }

    System.out.println("Goodbye! Here is a transcript of our conversation:");
    for (int n = 0 ; n < transcript.length; n++) 
    {
      System.out.println(transcript[n]);
    }
    input.close();
  }
}
