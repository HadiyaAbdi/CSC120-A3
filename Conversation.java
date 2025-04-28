import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

// this class mirrors a conversation between a user and chatbot. it takes rounds, mirrors pronouns, replies to the user, and prints a transcript.
class Conversation implements Chatbot {
  private ArrayList<String> transcript = new ArrayList<>();
  private static final String[] repeat = {"Tell me more.", "Interesting.", "Sounds thrilling!", "Why do you say that?", "Mhmm."};
  // constructor to initialize the chatbot
  public Conversation() {
    System.out.println("Welcome to the chatbot!");
  }
  // overridden chat to handle the flow of the conversation 
  @Override
  public void chat() {
    Scanner scanner = new Scanner(System.in);
    // ask for number of rounds
    System.out.println("How many rounds?");
    int n = scanner.nextInt();
    scanner.nextLine(); 
    
    //Greet & ask question
    System.out.println("Hello, welcome!");
    System.out.println("What is on your mind?");
    String user = scanner.nextLine(); // initial user input

    // add initial user input to transcript
    transcript.add("What is on your mind?");
    transcript.add(user);

    // main conversation loop
    for (int i = 0; i < n; i++) {
      user = user.toLowerCase(); // not modifying yet

      // check if user input contains any pronouns
      if (user.contains("i") || user.contains("me") || user.contains("you") || user.contains("my") || user.contains("your")) {
        String mirror = respond(user);
        System.out.println(mirror);
        transcript.add(mirror);
      }else { // if no pronouns are found
        // randomly select a response from the repeat array
        int chat = new Random().nextInt(repeat.length);
        String reset = repeat[chat];
        System.out.println(reset);
        transcript.add(reset);
      }

      // new input from the user
        user = scanner.nextLine();
        transcript.add(user);
      
    }
    // end of conversation
    System.out.println("Mmmm-hm, see ya!");
    transcript.add("Mmmm-hm, see ya!");
  }

  // overridden respond to handle the mirroring of pronouns
  @Override
  public String respond(String inputString) {
    String[] word = inputString.split(" ");
    for (int i = 0; i < word.length; i++) {
      switch (word[i]) {
        case "i":
          word[i] = "you";
          break;
        case "me":
          word[i] = "you";
          break;
        case "my":
          word[i] = "your";
          break;
        case "am":
          word[i] = "are";
          break;
        case "you":
          word[i] = "I";
          break;
        case "your":
          word[i] = "my";
          break;
      }
    }
    return String.join(" ", word) + "?";
  }
  // overridden printTranscript to print the conversation transcript
  @Override
  public void printTranscript() {
    System.out.println("Transcript:");
    for (String line : transcript) {
        System.out.println(line);
    }
}

  // main method to run the chatbot
  public static void main(String[] arguments) {
    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();
  }
}
