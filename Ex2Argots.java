package exercises;

import java.util.Arrays;

import static java.lang.System.out;

/*
 *  Argots, silly secret languages
 *  See https://en.wikipedia.org/wiki/Argot
 *
 *  See:
 *  - UseCharacter
 *  - UseString
 * -  UseStringBuilder
 */
public class Ex2Argots {

    public static void main(String[] args) {
        new Ex2Argots().program();
    }

    void program() {
        out.println(robberLanguage("Jag talar rövarspråket")
                .equals("JoJagog totalolaror rorövovarorsospoproråkoketot"));

        out.println(robberLanguage("I speak robber language")
                .equals("I sospopeakok rorobobboberor lolanongoguagoge"));

        /*out.println(toPigLatin("My name is Eric")
                .equals("yMay amenay isway Ericway"));
                */
        out.println(robberLanguage("Jag talar"));
        String s = "abc";
        char [] letters = s.toCharArray();
        out.println(Arrays.toString(letters));

        /*for (int i = 0 ; i < s.length(); i++){
            out.println(s.charAt(i));
        }

        for ( int i = 0 ; i < letters.length; i++){
            out.println(letters[i]);
        }
        for (char ch: s.toCharArray()){
            out.println(ch);
        }*/
        out.println(isVowelorSpace('a'));
        out.println(isVowelorSpace('ö'));






    }

    // ---------- Methods --------------------
    String robberLanguage(String input){
        String robber = "";
        for (char ch: input.toCharArray()){
            if (isVowelorSpace(ch)){
              robber = robber + ch;
            }else if(isVowelorSpace(ch)==false) {
                robber = robber + ch + "o" + ch ;
            }
        }return robber;


    }
    boolean isVowelorSpace(char letter){
        char []vowels = {'A','a','U','u','Å','å','E','e','I','i','Y','y','Ä','ä','Ö','ö', ' '};
        for (char ch: vowels){
            if (letter ==ch){
                return true;

            }
        }return false;

    }



}
