package exercises;

import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;

/*
 *   Program to calculate the day number for same day in a given year.
 *   - You should use methods and functional decomposition.
 *   - To check solution, see http://mistupid.com/calendar/dayofyear.htm
 *
 *
 * See:
 * - FuncDecompLCR
 */
public class Ex8FuncDecompDayNumber {

    public static void main(String[] args) {
        new Ex8FuncDecompDayNumber().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        //test();                // <--------- Uncomment to test only

        // -- In ----------------
        out.print("Input a year > ");
        int year = sc.nextInt();
        out.print("Input a month number > ");
        int month = sc.nextInt();
        out.print("Input a day number > ");
        int day = sc.nextInt();

        // --- Process ---------


        // ---- Out ----


    }





    void printResult(int year, int month, int day, int numberOfDay) {
        // Use this
    }

    void test(){
        out.println("Start testing");

        // TODO test any method you discover here

        exit(0);
    }


}
