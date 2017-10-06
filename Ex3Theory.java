package exercises;

import static java.lang.Math.*;
import static java.lang.System.out;

/*
 *  More classes and classes (objects) connected
 *
 *  See
 *  - MoreClasses
 */
public class Ex3Theory {

    public static void main(String[] args) {
        new Ex3Theory().program();
    }

    void program() {
        //1. What will be printed? Why?
        Pt p1 = new Pt();
        Pt p2 = new Pt();
        Pt p3;

        p1.x = 1;
        p1.y = 2;
        p2.x = 2 * p1.x;//2
        p2.y = 2 * p1.y;//4
        p3 = p1;//p3 pekar på samma objekt som p1 (1,2)
        p1 = p2;//p1 pekar nu på samma objekt som p2 (2,4)

        out.println(p1 == p2);//true (referensen p1 pekar på samma sak som p2)
        out.println(p2 == p3);//false (p3 pekar på [1,2], p2 pekar på[2,4]
        out.println(p1 == p3);//false (p1[2,4], p3[1,2]

        out.println(p1.x == p2.x);//true (p1.x=2, p2.x=2)
        out.println(p2.x == p3.x);//false(p2.x=2, p3.x=1)
        out.println(p3.y == p1.y);//false(p3.y=2, p1.y=4)

        // 2. What will be printed? Why? See Mth class below
        Mth m = new Mth(3); //Skapar en Mth med int i=3
        m.op(1.5); // m.i = i + (int)1.5 = 4
        m.op(); // m.i = 2 * i = 8
        m.op(2); // m.i = i + 2 = 10
        out.println(m.i); //Skriver ut 10

        // 3. What will be printed? Why? How many objects are involved?
        Cainc cc = new Cainc(5);
        out.println(cc.doIt().doIt().doIt().doIt().i); //5 objekt involverade, för varje doIT ökar i med 1, i=9

        // 4. What will be printed? Why? How many objects are involved?
        CCtor c = new CCtor(new CCtor(new CCtor(8))); //Börjar i innersta parentesen, i=8, värdet kopieras, objekt 3st
        out.println(c.i); //Skriver ut 8


        // 5. Some rows will give errors. Explain!

        //A.a = A.b;              // 1.Det finns inget b att ta värdet från, a är statisk och kan därför användas
        A.a = new A().b;        // 2.Här skapas ett objekt först, värdet av o.b kopieras
        //A.b = A.a;              // 3. b är inte statisk och kan inte tilldelas ett värde
        new A().b = A.a;        // 4
        new A().a = new A().b;  // 5
        new A().b = new A().a;  // 6
        A a = null;             // 7
        out.println(a.a);       // 8

    }

    // ---------- Classes ----------------------------

    // "static" before class A has nothing to do with the problems
    static class A {
        static int a;
        int b;
    }


    class Pt {
        int x;
        int y;
    }

    class Mth {
        int i;

        Mth(int i) {
            this.i = i;
        }

        void op() {
            i = 2 * i;
        }

        void op(double d) {
            i = i + (int) d;
        }

        void op(int i) {
            this.i += i;
        }
    }

    class Cainc {
        final int i;

        Cainc(int i) {
            this.i = i;
        }

        Cainc doIt() {
            return new Cainc(i + 1);
        }

    }

    class CCtor {
        int i;

        CCtor(int i) {
            this.i = i;
        }

        CCtor(CCtor o) {
            i = o.i;
        }
    }
}
