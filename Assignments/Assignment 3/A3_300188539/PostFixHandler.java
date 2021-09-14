/*******************************/
/*Student number: 300188539
/*Student full name: Alae Boufarrachene
/*******************************/

import java.util.*;
import java.lang.Math;

public class PostFixHandler {

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static Boolean isNumeric(char c) {
        if (c >= 48 && c <= 57)
            return true;
        else
            return false;
    }

    private static String[] symbolCleanerAndSqrtEvaluator(String expression) throws OperatorNotSupportedException, ArithmeticException {
        String[] expressionArray = expression.split(" ");
        int operatorVerifier=0;
        for (int i=0 ; i<expressionArray.length ; i++ ) {
            if (isNumeric(expressionArray[i])) {
                continue;
            }
            else {
                if (expressionArray[i].equals("plus")) {
                    expressionArray[i] = "+";
                    operatorVerifier++;
                }
                if (expressionArray[i].equals("minus")) {
                    expressionArray[i] = "-";
                    operatorVerifier++;
                }
                if (expressionArray[i].equals("multiply")) {
                    expressionArray[i] = "*";
                    operatorVerifier++;
                }
                if (expressionArray[i].equals("divide")) {
                    expressionArray[i] = "/";
                    operatorVerifier++;
                }
                if (expressionArray[i].equals("squareRoot")) {
                    double temp = Double.parseDouble(expressionArray[i-1]);
                    if (temp<0) {
                        throw new ArithmeticException("Square roots of negative numbers don't exist !");
                    }
                    temp = Math.sqrt(temp);
                    int temp2 = (int) temp;
                    expressionArray[i-1] = String.valueOf(temp2);  
                    operatorVerifier++;
                }
                if (operatorVerifier==0) {
                    throw new OperatorNotSupportedException("You've entered an incorrect operator !");
                }
            }
        }
        return expressionArray;
    }

    public static int processExpression(String expression) throws OperatorNotSupportedException, ArithmeticException {
        
        Stack<Integer> stack = new LinkedStack<Integer>(); //Stack that we'll be using to process the postfix expression 
        String[] cleanExpressionArrayWithExtraChar = symbolCleanerAndSqrtEvaluator(expression);
        List<String> cleanExpressionList = new ArrayList<>();
        for (int i=0 ; i<cleanExpressionArrayWithExtraChar.length ; i++) {
            if (cleanExpressionArrayWithExtraChar[i].equals("squareRoot")) {
                continue;
            }
            else {
                cleanExpressionList.add(cleanExpressionArrayWithExtraChar[i]);
            }
        }
        String newFinalExpression = String.join(" ", cleanExpressionList); //Clean string with evaluated square root

        char[] charArray = newFinalExpression.toCharArray();
        List<Character> charList = new ArrayList<Character>();
        for (int i1=0 ; i1<charArray.length ; i1++) {
            charList.add(charArray[i1]);
        }
        
        for (int i2=0 ; i2<newFinalExpression.length(); i2++) {

            char currentChar = newFinalExpression.charAt(i2);
              
            if (currentChar==' ') { //Base case : Current char element is a separator (space)
                continue;
            }
              
            else if (Character.isDigit(currentChar)) { //Base case : Cuurecent char element is an operand (number)
                int number = 0;

                while (Character.isDigit(currentChar)) {
                    int temp = (int)(currentChar-'0');
                    number = 10*number + temp;
                    i2++;
                    currentChar = newFinalExpression.charAt(i2);
                }
                i2--;
  
                stack.push(number);
            }
              
            else { //Base case : Switches between all operator cases and pushes the result of the corresponding operation in stack
                int firstOperand = stack.pop();
                int secondOperand = stack.pop();
                  
                switch(currentChar) {
                    case '+':
                        stack.push(secondOperand+firstOperand);
                        break;
                      
                    case '-':
                        stack.push(secondOperand-firstOperand);
                        break;
                      
                    case '/':
                        if (firstOperand==0) {
                            System.out.println("java.lang.ArithmeticException: You cannot divide by zero !");
                        }
                        firstOperand = 1;
                        stack.push(secondOperand/firstOperand);
                        break;
                      
                    case '*':
                        stack.push(secondOperand*firstOperand);
                        break;
                }
            }
        }
        return stack.pop(); 
    }
    
}