package calc;

import java.util.*;

import static java.lang.Double.NaN;
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
        // List<String> tokens = tokenize(expr);       <---------------- HERE are the methods!!!!
        // List<String> postfix = infix2Postfix(tokens);
        return 0; // 0 just for now, should be: return evalPostfix(postfix);
    }

    // ------  Evaluate RPN expression -------------------

    // TODO

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

    List<String>infix2postfix(List<String>tokens){
        List<String>postfix = new ArrayList<>();
        Deque<String>stack = new ArrayDeque<>();
        while (!tokens.isEmpty()){
            String temp = tokens.get(0);
            tokens.remove(0);
            algorithm(postfix, stack, temp);

        }


        return postfix;
    }
    void algorithm(List<String>postfix, Deque<String>stack, String temp){
        if (Character.isDigit(temp.charAt(0))){
            postfix.add(temp);
        }else if (OPERATORS.contains(temp)){
            if (stack.isEmpty()){
                stack.push(temp);
            }else{

            }
        }
    }


    /*while there are tokens to be read:
    read a token.
	if the token is a number, then push it to the output queue.
	if the token is an operator, then:
            while there is an operator at the top of the operator stack with
    greater than or equal to precedence and the operator is left associative:
    pop operators from the operator stack, onto the output queue.
    push the read operator onto the operator stack.
            if the token is a left bracket (i.e. "("), then:
    push it onto the operator stack.
            if the token is a right bracket (i.e. ")"), then:
            while the operator at the top of the operator stack is not a left bracket:
    pop operators from the operator stack onto the output queue.
    pop the left bracket from the stack.
		/* if the stack runs out without finding a left bracket, then there are
		mismatched parentheses. */
    /*if there are no more tokens to read:
            while there are still operator tokens on the stack:
    /* if the operator token on the top of the stack is a bracket, then
    there are mismatched parentheses. */
    //pop the operator onto the output queue.
      //      exit.*/


    // Error messages
    final static String MISSING_OPERATOR = "Missing operator or parenthesis";
    final static String OP_NOT_FOUND = "Operator not found";

    // TODO

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
    }}