package exercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Program to exercise arrays
 * <p>
 * See:
 * - Loops (for-loop only)
 * - ArrayBasics
 */
public class Ex4Arrays {

    public static void main(String[] args) {
        new Ex4Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    private void program() {

    int [] numbers = new int[5];
    out.print("Enter 5 integers, space in between, then enter-> ");
    for (int i=0; i<numbers.length; i++){
        numbers[i]= sc.nextInt(); }

    out.println("Array is : " + Arrays.toString(numbers));
    out.print("Input a value to find ->");

    int count = 0;
    int value = sc.nextInt();
    for ( int i = 0; i < numbers.length; i++){
        if (numbers[i]== value){
                out.println("Index for value " + value + " is " + i);
                count++;
                break;
        }
    }
    if (count == 0){
        out.print("Value not found");
        }
    }

}
