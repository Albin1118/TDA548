package exercises;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * (this is a multi row comment, no impact on program)
 *
 * Program to calculate a persons BMI
 * See https://en.wikipedia.org/wiki/Body_mass_index
 *
 * Formula is: bmi = weight / height²     (kg/m²)
 *
 * See:
 * - F2C
 * - PrimitiveVariables
 * - IO
 * - Arithmetic
 */
public class Ex1BMI {

    // Don't care about this, must be there, start coding at program
    public static void main(String[] args) {
        new Ex1BMI().program();
    }

    // This connects our program to the keyboard
    final Scanner sc = new Scanner(in);

    void program() {
        // Write your code here
    double weight;
    double height;
    double BMI;

        // --- Input ---------

        out.print("Enter your weight > ");
        weight = sc.nextDouble();
        out.print("Enter your height > ");
        height = sc.nextDouble();

        // --- Process --------
        BMI = weight/(height * height);

        // --- Output ---------
        out.println("Your BMI is: " + BMI);
    }

}
