package exercises;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Using classes for compound data of different types that in some sense belongs together
 *  (may be same type).
 *  Here we describe a "hero" using a class.
 *
 * See:
 * - ClassBasics
 */
public class Ex6Classes {

    public static void main(String[] args) {
        new Ex6Classes().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {

        Hero [] heroes = {new Hero(), new Hero()};
        for (int i=0; i<heroes.length; i ++){
           out.print("What's the name of Hero " + (i+1) + "  > ");
           heroes[i].name= sc.nextLine();
           out.print("How strong is " + heroes[i].name + "  > ");
           heroes[i].strength = sc.nextInt();
           sc.nextLine();
        }
        if (heroes[0].strength > heroes[1].strength){
            out.println(heroes[0].name + " is stronger");
        }else{
            out.println(heroes[1].name + " is stronger");
        }



    }

    // ------ The class to use  -----------
    // A class for variables that describes a Hero
    class Hero {
        String name;
        int strength;
    }


}
