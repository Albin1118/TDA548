package exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *
 *  Use a stack to check parentheses, balanced and nesting
 *  The parentheses are: (), [] and {}
 *
 *  See:
 *  - UseAStack
 *
 */
public class Ex4CheckParen {


    public static void main(String[] args) {
        new Ex4CheckParen().program();
    }

    void program() {
        // All should be true
        /*char i = '(';
        char value = matching(i);
        out.println();*/
        //test();
        out.println(checkParentheses("()"));
        out.println(checkParentheses("(()())"));
        out.println(!checkParentheses("(()))")); // Unbalanced
        out.println(!checkParentheses("((())")); // Unbalanced

        out.println(checkParentheses("({})"));
        out.println(!checkParentheses("({)}"));  // Bad nesting
        out.println(checkParentheses("({} [()] ({}))"));
        out.println(!checkParentheses("({} [() ({)})"));  // Unbalanced and bad nesting
    }

    // Can handle {}, () and []
    boolean checkParentheses(String expr) {
        char[]array = expr.toCharArray();

        Deque<Character> stack = new ArrayDeque<>();

        if (checkBalance(stack,array) && checkNesting(stack,array)){
            return true;
        }else{
            return false;
        }

    }

    // This is interesting because have to return, but what if no match?!?
    /*char matching(char ch) {
        //char c =  must initialize but to what?!
        switch (ch) {
            case ')':
                return '(';  // c = '('
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                 return ch;
                //throw new IllegalArgumentException("No match found");
        }
    }*/

    boolean checkBalance (Deque<Character> stack, char [] array ){
        for (char ch: array){
            stack.push(ch);
        }
        int par = 0;
        int hak = 0;
        int vinge = 0;
        char temp;

        for ( int i =0; i < stack.size();){

            temp=stack.pop();

            if(temp=='('){
                par++;
            }else if(temp==')'){
                par--;
            }else if ( temp == '{'){
                vinge++;
            }else if (temp =='}'){
                vinge--;
            }else if (temp=='['){
                hak++;
            }else if ( temp == ']'){
                hak--;
            }
        }
        if (par == 0 && hak == 0 && vinge == 0 ){
            return true;
        }else{
            return false;
        }

    }
    boolean checkNesting (Deque<Character> stack, char [] array){
        for (int i = (array.length-1); i >= 0; i--){
            stack.push(array[i]);
        }
        char current;
        char next;
        for ( int i =0; i < stack.size();){

            current=stack.pop();
            next = stack.peek();
            if (current=='(' && (next==']' || next=='}')){
                return false;
            }else if ( current=='[' && (next==')' || next=='}')){
                return false;
            }else if ( current== '{' && (next==')' || next==']')){
                return false;
            }else {
                return true;
            }


            }
        return true;
    }
    void test(){
        char [] ch = {'(',')','[',']', '{', '}'};
        Deque<Character>stack = new ArrayDeque<>();
        out.println(checkBalance(stack,ch));
    }


}

