package exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.*;
import static java.lang.System.*;

/*
 * Using a single class for rationals (below)
 *
 * See:
 * - UseAClass
 */
public class Ex1UseAClass {

    public static void main(String[] args) {
        new Ex1UseAClass().program();
    }

    void program() {
        // As usual, all output should print true

        Rational r = new Rational(2);
        out.println(r.num == 2 && r.denom == 1);
        r = new Rational(4, 9);
        out.println(r.num == 4 && r.denom == 9);
        r = new Rational(49, 168);
        out.println(r.num == 7 && r.denom == 24);  // Always as shorted
        r = new Rational(20, 4);
        out.println(r.num == 5 && r.denom == 1);
        r = new Rational(0, 1);
        out.println(r.num == 0 && r.denom == 1);
        r = new Rational(-49, 168);
        out.println(r.num == -7 && r.denom == 24);
        r = new Rational(49, -168);
        out.println(r.num == -7 && r.denom == 24);
        r = new Rational(-49, -168);
        out.println(r.num == 7 && r.denom == 24);

        Rational r1 = new Rational(1, 4);
        Rational r2 = new Rational(1, 2);
        out.println();
        out.println(r1.add(r2).equals(new Rational(3, 4)));//toString
        out.println(r1.sub(r2).equals(new Rational(-1, 4)));
        out.println(r1.mul(r2).equals(new Rational(1, 8)));
        out.println(r1.div(r2).equals(new Rational(1, 2)));

        Rational r3 = (Rational)r1;
        out.println(r3.equals(r1));
        out.println(!r3.lessThan(r1));
        out.println(r3.toDouble());
        out.println(abs(r3.toDouble() - 0.25) < 0.000001);

        List<Rational> rList = new ArrayList<>();
        rList.add(new Rational(2, 3));
        out.println(rList.contains(new Rational(2, 3)));

        Map<Rational, String> complexMsg = new HashMap<>();
        complexMsg.put(new Rational(1,1), "one");
        out.println(complexMsg.get(new Rational(1,1)).equals("one"));

        out.println(new Rational(6, 1).toString().equals("6 / 1"));

    }


    // -- Write your class below this line -------------------------

    public class Rational {
        int num;
        int denom;

        Rational(int numerator, int denominator){
            if (denominator==0){
                throw new RuntimeException("Denominator is zero");
            }
            int g = gcd(numerator, denominator);
            num = numerator/g;
            denom = denominator/g;

            if (denom < 0){
                denom= -denom;
                num = -num;
            }

        }
        Rational(int numerator){
            num = numerator;
            denom = 1;
        }
        Rational add(Rational b){
            int numerator = (this.num * b.denom) + (this.denom * b.num);
            int denominator = (this.denom * b.denom);
            int g = gcd(numerator, denominator);

            numerator = numerator/g;
            denominator = denominator/g;
            return  new Rational (numerator, denominator);
        }
        Rational sub(Rational b){
            int numerator = (this.num * b.denom) - (this.denom * b.num);
            int denominator = (this.denom * b.denom);
            int g = gcd(numerator, denominator);

            numerator = numerator/g;
            denominator = denominator/g;
            return  new Rational (numerator, denominator);
        }
        Rational mul(Rational b){
            int numerator = (this.num * b.num);
            int denominator = (this.denom * b.denom);
            int g = gcd(numerator, denominator);

            numerator = numerator/g;
            denominator = denominator/g;
            return  new Rational (numerator, denominator);
        }
        Rational div(Rational b){
            int numerator = (this.num / b.num);
            int denominator = (this.denom / b.denom);
            int g = gcd(numerator, denominator);

            numerator = numerator/g;
            denominator = denominator/g;
            return  new Rational (numerator, denominator);
        }
        Rational abs(){
            int numerator = this.num;
            int denominator = this.denom;
            if (numerator<0){
                numerator=-(numerator);
            }
            if (denominator<0){
                denominator=-(denominator);
            }
            return new Rational(numerator, denominator);
        }
        public boolean equals (Object other){
            if (this == other){
                return true;
            }
            if (other == null || getClass() != other.getClass()){
                return false;
            }
            Rational rational = (Rational) other;

            return Integer.compare(rational.num, num)==0 &&
            Integer.compare(rational.denom, denom)==0;
        }
        public boolean lessThan (Object other){
            if (this==other) return false;
            if (other == null || getClass() != other.getClass()) return false;
            Rational rational = (Rational) other;
            return Integer.compare(rational.num, num)<0 && Integer.compare(rational.denom, denom)<0;


        }
        public double toDouble(){
            return ((double)(this.num)/(this.denom));
        }
        public int hashCode() {
            int result;
            long temp;
            temp = Integer.toUnsignedLong(num);
            result = (int) (temp ^ (temp >>> 32));
            temp = Integer.toUnsignedLong(denom);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
        public String toString(){
           return (this.num + " / " + this.denom);

        }






    }
    int gcd(int a, int b){
        if (b==0){
            return a;
        }else{
            return gcd(b, a % b);
        }

    }










}
    


