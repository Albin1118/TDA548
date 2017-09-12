package exercises;

import static java.lang.System.*;

import java.util.Scanner;

/*
 *  Program to calculate easter Sunday for some year (1900-2099)
 *  https://en.wikipedia.org/wiki/Computus (we use a variation of
 *  Gauss algorithm, scroll down)
 *
 *  To check your result: http://www.wheniseastersunday.com/
 *
 *  See:
 *  - LogicalAndRelationalOps
 *  - IfStatement
 *
 *
 */
public class Ex2EasterDay {

    public static void main(String[] args) {
        new Ex2EasterDay().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {

        int a, b, c, d, e, s, t;   // Avoid on same line (acceptable here)
        int date;
        int year;
        int month;

        // ---- Input --------------
        out.print("Input a year (1900-2099) > ");
        year = sc.nextInt();

        // ----- Process -----------
        a = year % 19;     // Don't need to understand, Gauss did understand
        b = year % 4;
        c = year % 7;
        s = 19 * a + 24;
        d = s % 30;
        t = 2 * b + 4 * c + 6 * d + 5;
        e = t % 7;
        date = 22 + d + e;

        // TODO Now you continue ..
        /*
            If date is less than 32, then date is found and month is march.
            Else: Date is set to D + E - 9 and month is april ...
            ... but with two exceptions
            If date is 26 easter is on 19 of april.
            If date is 25 and a is 16 and d is 28 then date is 18 of april.
         */
        if (date==26){
            date=26;month=4;
        }
        if (date==25 && a==16 && d==28){
            date=18;month=4;

        }
        else if(date<32){
            month=3;
        }else{
            date=(d+e-9);month=4;
        }

        // --------- Output -----------
        out.println("Easter day: " +  date + "-" + month + "-" + year);

    }
}
