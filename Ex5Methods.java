package exercises;

import static java.lang.System.out;

/*
 *  Implement methods to make program produce correct output (print true)
 *
 * See:
 * - Methods
 */
public class Ex5Methods {

    public static void main(String[] args) {
        new Ex5Methods().program();
    }

    void program() {
        // All, except last,  should print true
        out.println(sumTo(5) == 15);     // 1 + 2 + ... + 5 = 15
        out.println(sumTo(23) == 276);
        out.println(factorial(3) == 6);    // 3 * 2 * 1 = 6
        out.println(factorial(5) == 120);
        out.println(digitSum(1111) == 4);   // 1 + 1 + 1 + 1 = 4
        out.println(digitSum(12345) == 15);

        int[] arr = {10, 20, 30, 40, 50};
        out.println(next(arr, 2) == 40);   // Find *next* value given index (in a circular fashion)
                                                  // Index 2 is 30 so next is 40.
        out.println(next(arr, 4) == 10);    // Index 4 is 50 so next is 10 (circular).

        // A special case, should print: "Winner is Olle" (or whatever name)
        //winnerMsg("Olle");
    }

    // ------ Write methods below this  -----------
    int sumTo(int number){
        int sum =0;
        for (int i =1; i<=number; i++){
            sum = sum + i;
        }return sum;
    }
    int factorial (int number){
        int factors = 1;
        for (int i = number; i > 1; i --){
            factors = factors * i;
        }return factors;
    }
    int digitSum (int number){
        int sum = 0;
        while (number > 0){
            sum = sum + number % 10;
            number = number /10;
        }return sum;
    }
    int next ( int [] arr, int index){
        if (index == arr.length - 1){
            index = 0;
        }else{
            index++; }
        return arr[index];
    }


}
