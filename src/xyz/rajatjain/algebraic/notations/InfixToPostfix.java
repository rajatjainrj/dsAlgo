package xyz.rajatjain.algebraic.notations;

import xyz.rajatjain.data.structures.arrays.Stack;

import java.util.Scanner;

/**
 * @author rajatjain on - 18-12-2021
 * @project dsAlgo
 */
public class InfixToPostfix {

    private final Stack<Character> operatorStack;
    private final StringBuilder output;
    private final String input;

    public InfixToPostfix(String input) {
        this.input = input;
        operatorStack = new Stack<>(input.length());
        output = new StringBuilder();
    }

    public String convert() {
        char[] characters = input.toCharArray();
        for (Character character : characters) {
            if (isOperand(character)) {
                output.append(character);
            } else if (isOpeningBracket(character)) {
                operatorStack.push(character);
            } else if (isClosingBracket(character)) {
                while (!isOpeningBracket(operatorStack.peek())) {
                    output.append(operatorStack.pop());
                }
                operatorStack.pop();
            } else if (isOperator(character)) {
                handleOperator(character);
            }
            System.out.println("Stack - ");
            operatorStack.printStack();
            System.out.println("Output - " + output.toString());
        }
        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop());
        }
        return output.toString();
    }

    private void handleOperator(Character character) {
        if (operatorStack.isEmpty() ||
                isOpeningBracket(operatorStack.peek()) ||
                hasHigherPrecedenceThanTOS(character)) {
            operatorStack.push(character);
        } else {
            output.append(operatorStack.pop());
            handleOperator(character);
        }
    }

    private boolean hasHigherPrecedenceThanTOS(Character character) {
        Character topOfStack = operatorStack.peek();
        switch (character) {
            case '/':
            case '*':
                if (topOfStack == '-' || topOfStack == '+') {
                    return true;
                }
                break;
            case '^':
                if (topOfStack == '-' || topOfStack == '+' || topOfStack == '*' || topOfStack == '/') {
                    return true;
                }
                break;
        }
        return false;
    }

    private boolean isOperator(Character character) {
        return character == '*' || character == '+' || character == '/' || character == '-' || character == '^';
    }

    private boolean isClosingBracket(Character character) {
        return character == ')';
    }

    private boolean isOpeningBracket(Character character) {
        return character == '(';
    }

    private boolean isOperand(Character character) {
        return !isOpeningBracket(character) && !isClosingBracket(character) && !isOperator(character);
    }

    public String getOutput() {
        return output.toString();
    }

    public String getInput() {
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the infix expression - ");
        InfixToPostfix infixToPostfix = new InfixToPostfix(scanner.nextLine());
        System.out.println("Postfix Expression - " + infixToPostfix.convert());
//        InfixToPostfix infixToPostfix = new InfixToPostfix("(Z+B/C*(D+E)-F)");
//        System.out.println("Postfix Expression - " + infixToPostfix.convert());
//        InfixToPostfix infixToPostfix2 = new InfixToPostfix("2*4/(2-1)+6*4");
//        System.out.println("Postfix Expression - " + infixToPostfix2.convert());

    }

}
