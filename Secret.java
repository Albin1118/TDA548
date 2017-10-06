package exercises.ex4hangman;

/*
 * This represents the secret word to guess
 */
public class Secret {

    final String secretWord;
    public String maskedWord;

    Secret(String word){
        secretWord = word;

       int chars = secretWord.length();
       char [] masked = new char[chars];
       for (int i = 0 ; i < masked.length;i++){
           masked[i]='_';
       }
       maskedWord=String.valueOf(masked);

    }

    public int numberofChars(){
        int nChars = this.secretWord.length();
        return nChars;
    }
    public boolean isCharinWord(String input){
        if(secretWord.contains(input)){
            return true;
        }else {return false;}
    }
    public int [] indexofLetters(String input){
        char [] secretWordChars = secretWord.toCharArray();
        int countChars=0;
        for( int i = 0; i < secretWordChars.length; i++ ){
            if((String.valueOf(secretWordChars[i])).equals(input)){
                countChars++;
            }
        }
        int [] indexofChars = new int[countChars];
        int arrayIndex = 0;
        for (int i = 0; i < secretWordChars.length; i++){
            if((String.valueOf(secretWordChars[i]).equals(input))){
                indexofChars[arrayIndex]=i;
                arrayIndex++;
            }
        }
        return indexofChars;
    }
    public void updateMaskedWord(){
        //for loop that goes through the array of charIndex and places the input on the right place(_ _ _)-->(_ a _)
    }


}
