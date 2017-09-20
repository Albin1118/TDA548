package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *   Extract numbers form Strings
 *
 *   See:
 *  - UseCharacter
 *  - UseString
 *  - UseStringBuilder
 *  - UseAList
 */
public class Ex3ReadNumber {

    public static void main(String[] args) {
        new Ex3ReadNumber().program();
    }

    void program() {
        // Argument 0 is index to start looking for digits.
        // Return value is index directly after last read digit
        // The number should be in the list numbers (method should add number to list)

        List<String> numbers = new ArrayList<>();

        out.println(readNumber(numbers, "1", 0) == 1);
        out.println(numbers.contains("1"));
        numbers.clear();
        out.println(readNumber(numbers, "123", 0) == 3);
        out.println(numbers.contains("123") && !numbers.contains("1"));
        numbers.clear();
        out.println(readNumber(numbers, "123abc", 0) == 3);
        out.println(numbers.contains("123"));
        numbers.clear();
        out.println(readNumber(numbers, "12345abc", 0) == 5);
        out.println(numbers.contains("12345"));
        numbers.clear();
        out.println(readNumber(numbers, "abc123abc", 3) == 6);
        out.println(numbers.contains("123"));

        // Empty string is not accepted will throw exception
        try {
            out.println(readNumber(numbers, "", 0) == 0);
        } catch (IllegalArgumentException e) {
            out.println(e.getMessage());
        }
    }
       /*int readNumber(List<String>numbers,String toRead, int startIndex){
           char [] array = toRead.toCharArray();
            int indexOfLastFoundDigit=0;
            String addToList = "";
            for ( int i =startIndex; i< array.length; i++){
                if (Character.isDigit(array[i])){
                    addToList = addToList + array[i];
                    indexOfLastFoundDigit=(i+1);
                }
            }
            numbers.add(addToList);
            return indexOfLastFoundDigit;

       }*/
       int readNumber(List<String>numbers,String toRead, int startIndex){
           char [] array = toRead.toCharArray();
           int indexOfLastFoundDigit=0;
           String addToList = "";
           int i = startIndex;

           while ( i < array.length && Character.isDigit(array[i])){
               addToList = addToList + array[i];
               indexOfLastFoundDigit=(i+1);
               i++;
           }

           numbers.add(addToList);
           return indexOfLastFoundDigit;


        }
}
