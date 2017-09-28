package calc;

import java.util.*;

import static java.lang.Double.NaN;
import static java.lang.Double.valueOf;
import static java.lang.Math.pow;


/*
 *   A calculator for rather simple arithmetic expressions
 *
 *   NOTE:
 *   - No negative numbers implemented
 */
public class Calculator {

    // Error messages (more on static later)
    final static String MISSING_OPERAND = "Missing or bad operand";
    final static String DIV_BY_ZERO = "Division with 0";

    // Definition of operators
    final String OPERATORS = "+-*/^";
    final String PARENTHESES = "()";
    // Method used in REPL
    double eval(String expr) {
        if (expr.length() == 0) {
            return NaN;
        }
        List<String> tokens = tokenize(expr);      // <---------------- HERE are the methods!!!!
        List<String> postfix = infix2Postfix(tokens);
        Deque<String>stack = new ArrayDeque<>();
        return evalPostfix(postfix, stack);
    }

    // ------  Evaluate RPN expression -------------------

   double evalPostfix (List<String>postfix, Deque<String>stack) {
        for ( int i = 0; i < postfix.size();i++) {
            if (OPERATORS.contains(postfix.get(i))){
                double operand_1 = valueOf(stack.pop());
                if (stack.isEmpty()){
                    throw new IllegalArgumentException(MISSING_OPERAND);
                }
                double operand_2 = valueOf(stack.pop());
                String operator = postfix.get(i);
                double result = applyOperator(operator, operand_1, operand_2);
                stack.push(String.valueOf(result));

            }else if (!OPERATORS.contains(postfix.get(i))) {
                stack.push(postfix.get(i));

            }

        }
        if (stack.size()>1){
            throw new IllegalArgumentException(MISSING_OPERATOR);
        }
        double result = valueOf(stack.pop());
        return result;
   }

    double applyOperator(String op, double d1, double d2) {
        switch (op) {
            case "+":
                return d1 + d2;
            case "-":
                return d2 - d1;
            case "*":
                return d1 * d2;
            case "/":
                if (d1 == 0) {
                    throw new IllegalArgumentException(DIV_BY_ZERO);
                }
                return d2 / d1;
            case "^":
                return pow(d2, d1);
        }
        throw new RuntimeException(OP_NOT_FOUND);
    }

    // ------- Infix 2 Postfix ------------------------

    // Error messages
    final static String MISSING_OPERATOR = "Missing operator or parenthesis";
    final static String OP_NOT_FOUND = "Operator not found";

    List<String>infix2Postfix(List<String>tokens){

        List<String>postfix = new ArrayList<>();
        Deque<String>stack = new ArrayDeque<>();

        while (!tokens.isEmpty()){
            String temp = tokens.get(0);
            tokens.remove(0);
            algorithm(postfix, stack, temp);
        }

        while (!stack.isEmpty()){
            if ( stack.peek().equals("(")){
                stack.pop();

            }else{
                postfix.add(stack.pop());
            }

        }

        return postfix;

    }

    void algorithm(List<String>postfix, Deque<String>stack, String temp){
        if (Character.isDigit(temp.charAt(0))){
            postfix.add(temp);
        }else if (OPERATORS.contains(temp)){
            if (stack.isEmpty()) {
                stack.push(temp);
            }else{
                while((!stack.isEmpty()) && (!PARENTHESES.contains(stack.peek())) &&
                        (getPrecedence(stack.peek()) >= getPrecedence(temp)) && (getAssociativity(temp)==Assoc.LEFT)){
                    postfix.add(stack.pop());
                }
                stack.push(temp);
            }
        }else if (temp.equals("(")){
            stack.push(temp);
        }else if ( temp.equals(")")){
            while (!stack.isEmpty() && !stack.peek().equals("(")){
                postfix.add(stack.pop());
            }
            try{stack.pop();}
            catch (NoSuchElementException e){
                throw new IllegalArgumentException(MISSING_OPERATOR);
            }
        }
    }

    int getPrecedence(String op) {
        if ("+-".contains(op)) {
            return 2;
        } else if ("*/".contains(op)) {
            return 3;
        } else if ("^".contains(op)) {
            return 4;
        } else {
            throw new RuntimeException(OP_NOT_FOUND);
        }
    }

    Assoc getAssociativity(String op) {
        if ("+-*/".contains(op)) {
            return Assoc.LEFT;
        } else if ("^".contains(op)) {
            return Assoc.RIGHT;
        } else {
            throw new RuntimeException(OP_NOT_FOUND);
        }
    }

    enum Assoc {
        LEFT,
        RIGHT
    }

    // ---------- Tokenize -----------------------
    List<String> tokenize(String expr) {

        List<String> tokens = new ArrayList<>();

        char[] expression = expr.toCharArray();



        for (int i = 0; i < expression.length; ) {

            if (Character.isDigit(expression[i])){

                i = readNumber(tokens, expr, i);

            }else if (OPERATORS.contains(Character.toString(expression[i]))){

                tokens.add(Character.toString(expression[i]));

                i++;

            }else if(PARENTHESES.contains(Character.toString(expression[i]))){

                tokens.add(Character.toString(expression[i]));

                i++;

            }else {

                i++;

            }

            //use readnumber to add to list and get next index

            //if next char is operand, i++

        }
        return tokens;

    }



    int readNumber(List<String>tokens,String toRead, int startIndex){

        char [] array = toRead.toCharArray();

        int indexOfLastFoundDigit=0;

        String addToList = "";

        int i = startIndex;



        while ( i < array.length && Character.isDigit(array[i])){

            addToList = addToList + array[i];

            indexOfLastFoundDigit=(i+1);

            i++;

        }
        tokens.add(addToList);

        return indexOfLastFoundDigit;

    }
}

