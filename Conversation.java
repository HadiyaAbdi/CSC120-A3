import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

// this class mirrors a conversation between a user and chatbot. it takes rounds, mirros pronouns, replies to the user, and print a trancript.
class Conversation implements Chatbot {
  //stores conversation between the bot and the user
  private ArrayList<String> transcript = new ArrayList<>();
  private static final String[] repeat = {"Tell me more.", "Intresting", "Sounds Thrilling!", "Why do you say that?", "Mhmm"};
  




  // Attributes 

  /**
   * Constructor 
   */

   
  public Conversation() {
   
    System.out.println("Welcome to the chatpot");
    

  }

  // take in the number of rounds a user want to play
  /**
   * 
   */
  //public static int rounds(){

   // Scanner scanner = new Scanner(System.in);
    //System.out.println("how many rounds?");
    //int n = scanner.nextInt();
    //scanner.close();
   
    //System.out.println("Hello, Welcome");
     // System.out.println("What is on your mind?");
      //for(int i = 0; i < n; i++){
 // }

  /**
   * Starts and runs the conversation with the user
   */
  public void chat() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("how many rounds?");
    int n = scanner.nextInt();
    scanner.nextLine(); 
  
    System.out.println("Hello, Welcome");
    System.out.println("What is on your mind?");
    String user = scanner.nextLine(); //initial user input

    transcript.add("What is on your mind?");
    transcript.add(user);


    for(int i = 0; i < n; i++){ //everytime the forloops runs the trascript adds user input
      user = user.toLowerCase(); //converts the input to lower case

      if(user.contains("i") || user.contains("me") || user.contains("you") || user. contains("my") || user.contains("your"))// looks at the first person pronouns and ignores
      {// have to mirror words from this point
        String[] mirror = user.split(" ");

        for(int j = 0; j < mirror.length; j++){
          if(mirror[i].equals("i") || mirror[j].contains("i'm") || mirror[j].contains("i am")){
            mirror[j] = "you"; // replace i or i'm with you
            mirror[j + 1] = "are";
          }
          else if (mirror[j].equals("me")){
            mirror[j] = "you"; //replace me with you
          }
          else if (mirror[j].equals("you")){
            mirror[j] = "i"; //replace you with i 
          }
          else if(mirror[j].equals("my")){
            mirror[j] = "your"; // replace my with your 
          }}

          String botResponse = String.join(" ", mirror);
          System.out.println(botResponse); //mirrored response
          
          // pick a random phrase from the array: repeat
          int chats = new Random().nextInt(repeat.length);
          String reset = repeat[chats];
          System.out.println(reset);
          transcript.add(reset);

          user = scanner.nextLine();
          transcript.add(user);
        } // space for the response
        else{
          if( i!= n - 1){// if not last round, keep the conversation going by randomising 
            int chats = new Random().nextInt(repeat.length);
            String reset = repeat[chats];
            System.out.println(reset);
            transcript.add(reset); //add random response

            // ask for user input again 
            user = scanner.nextLine();
            transcript.add(user);
        } else{
          System.out.println("Mmmm-hm, see ya!");
          transcript.add("Mmmm-hm, see ya!");

        }}
        //check if the user responds with personal pronouns
          // if(user.equalsIgnoreCase("why do you say that")){
            //  user = scanner.nextLine();
             // transcript.add(user);
            

            //if the user doesnt use personal pronouns
            if(!user.contains("i") && !user.contains("me") && !user.contains("you") && !user.contains("my") && !user.contains("your")){
              System.out.println("Mmmm-hm, see ya!");
             transcript.add("Mmmm-hm, see ya!");
              
            }

      }}
        
      
    
  /**
   * Prints transcript of conversation
   */
  public void printTranscript() {
    System.out.println("Transcript:");
    //iterates the transcript
    for(String tra : transcript){
      System.out.println(tra);
    }

  }

  /**
   * Gives appropriate response (mirrored or canned) to user input
   * @param inputString the users last line of input
   * @return mirrored or canned response to user input  
   */
  public String respond(String inputString) {
    String returnString = ""; 
    return returnString; 
  }

  public static void main(String[] arguments) {

    Conversation myConversation = new Conversation();
    myConversation.chat();
    myConversation.printTranscript();

  }}
  

