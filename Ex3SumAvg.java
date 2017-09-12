package exercises;

import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Program to calculate sum and average for non-negative integers
 *
 * See:
 * - Loops (while only)
 * - LoopAndAHalf
 *
 */
public class Ex3SumAvg {

    public static void main(String[] args) {
        new Ex3SumAvg().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Write your code here
        int sum=0;
        int count=0;
        double average=0;
        // -- Input (and bookkeeping)
        out.print("Enter a positive integer, (-1 to quit)\n");
        while (true){
            out.print("-> ");
            int a = sc.nextInt();
            if ( a<0){
                break;
            }
            sum = sum + a;
            count++;

        }

        // -- Process---
        average = sum/count;

        // -- Output ----
        out.println("The average of your numbers is: " + average);
    }

}
