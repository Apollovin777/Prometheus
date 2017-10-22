package com.task7;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Application {

    public static boolean checkString(String string) {
        try {
            Double.parseDouble(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static double parse(String rpnString) {
        LinkedList<Double> stack = new LinkedList<>();
        if(rpnString==null)
            throw new RPNParserException();

        String[] array = rpnString.split(" ");

        for (String s : array) {
            if(checkString(s)){
                stack.push(Double.parseDouble(s));
            }
            else {
                try {
                    Double op2 = stack.pop();
                    Double op1 = stack.pop();
                    if (Double.isNaN(op1) || Double.isInfinite(op1)||Double.isNaN(op2) || Double.isInfinite(op2)){
                        throw new ArithmeticException();
                    }
                    switch (s) {
                        case "+":
                            stack.push(op1 + op2);
                            break;
                        case "-":
                            stack.push(op1 - op2);
                            break;
                        case "*":
                            stack.push(op1 * op2);
                            break;
                        case "/":
                            Double res = op1 / op2;
                            if (Double.isNaN(res) || Double.isInfinite(res))
                                throw new ArithmeticException();
                            else
                                stack.push(res);
                            break;
                        default:
                            throw new RPNParserException();
                    }
                }
                catch (NoSuchElementException e){
                    throw new RPNParserException();
                }

            }
        }
        Double result = stack.pop();
        if (stack.size()==0)
            return result;
        else
            throw new RPNParserException();
    }

    public static void main(String[] args) {
        String test = "10 20 + 30 40 +";
        System.out.println(parse(test));
    }
}
