package exercises.ex4hangman;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The very well known Hangman game (in a text version)
 *  This is the main program i.e. game logic and the text based IO.
 *
 *  Run this to run the game
 *
 */
public class HangMan {

    public static void main(String[] args) {
        new HangMan().program();
    }

    private final Scanner sc = new Scanner(in);
    private final Random rand = new Random();

    // Parts of the hanging man (\n is the new line character)
    private final String[] parts = {
            "---|\n",
            "   |\n",
            "   O\n",
            "  /",
            "|",
            "\\\n",   // This is \\ (2 backslash) and a new line (= escaping), see web
            "  /",
            " \\\n",
    };

    private int nGuess = 0;
    private Result result;

    private void program() {
        List<String> words;
        try {
            Path path = Paths.get("src/exercises/ex4hangman/words.txt");
            words = FileService.readFile(path);
        } catch (IOException e) {
            out.println(e.getMessage());
            return;
        }

        // TODO Game logic here
        int listLength = words.size();
        int listIndex = rand.nextInt(listLength-1); //Gets a random index in the list
        String word = words.get(listIndex); //Chooses a word from the list
        Secret secret = new Secret(word); //Creates a 'Secret' object with the random word

        welcometoHangMan(secret.numberofChars()); //Welcome message for the player
        plotMask(secret.maskedWord);


       // result = null;
        // while (!(result==Result.WIN || result==Result.LOSE)){}

    }

    // ---- IO don't belong to other classes, put it here ---------------
    private void welcometoHangMan(int nchars){
        out.println("Welcome to Hangman, try to guess the word!  It is " + nchars + " chars long.");
    }
    private char guessCharacter() {
        String input;
        while( true ){
            out.print("Enter a char > ");
            input = sc.nextLine();
            if( input.length() == 1 && Character.isLetter(input.charAt(0))){
                break;
            }
        }
        return input.charAt(0);
    }

    private void plotMask(String mask) {   //Prints out the word, undiscovered letters with _ , otherwise the letter
        for (char ch : mask.toCharArray()) {
            out.print(ch + " ");
        }
        out.println();
    }

    private void plotMan(int nParts) {  // nParts = Number of stringparts to print out. Increases with each incorrect letter
        for( int i = 0  ; i < nParts ; i++){
            out.print(parts[i]);
        }
    }
}
