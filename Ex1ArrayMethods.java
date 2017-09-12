package exercises;

import java.util.Arrays;
import java.util.Random;

import static java.lang.StrictMath.round;
import static java.lang.System.*;

/*
 *  Methods with array params and/or return value. Implement methods.
 *
 *  See:
 *  - MathMethods
 *  - ArrayMethods
 */
public class Ex1ArrayMethods {

    public static void main(String[] args) {
        new Ex1ArrayMethods().program();
    }

    final static Random rand = new Random();

    void program() {
        int[] arr = {1, 2, 2, 5, 3, 2, 4, 2, 7};  // Hard coded test data

        // Count occurrences of some element in arr
        out.println(count(arr, 2) == 4);      // There are four 2's
        out.println(count(arr, 7) == 1);

        // Generate array with 100 elements with 25% distribution of -1's and 1's (remaining will be 0)
        arr = generateDistribution(100, 0.25, 0.25);
        //out.println(Arrays.toString(arrGenerated));
        out.println(count(arr, 1) == 25);
        out.println(count(arr, -1) == 25);
        out.println(count(arr, 0) == 50);

        // Generate array with 14 elements with 40% 1's and 30% -1's
        arr = generateDistribution(14, 0.4, 0.3);
        out.println(count(arr, 1) == 6);
        out.println(count(arr, -1) == 4);

        /*
        for (int i = 0; i < 100000; i++) {
            // Random reordering of arr, have to check by inspecting output
            shuffle(arr);
            out.println(Arrays.toString(arr));  // Does it look random?
        }
        */
    }


    // ---- Write methods below this ------------
    int count(int [] arr, int num){
        int counter = 0;
        for ( int i=0; i<arr.length; i++){
            if (arr[i]==num){
                counter++;
            }
        }return counter;
    }
    int [] generateDistribution(int elements, double percentOne, double percentMinusOne){
        int numberofOnes = (int)Math.round(percentOne*elements);
        int numberofMinusOnes = (int)Math.round(percentMinusOne*elements);
        int [] arr = new int[elements];

        for (int i=0; i < numberofOnes;){
            int randomLocation=rand.nextInt(elements-1);
            if (arr[randomLocation]==0){
                arr[randomLocation]=1;
                i++;
            }
        }
        for (int i=0; i< numberofMinusOnes;){
            int randomLocation=rand.nextInt(elements-1);
            if (arr[randomLocation]==0){
                arr[randomLocation]=-1;
                i++;
            }
        }
        return arr;
    }





}
