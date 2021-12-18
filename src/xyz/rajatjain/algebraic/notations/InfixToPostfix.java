package xyz.rajatjain.algebraic.notations;

import xyz.rajatjain.data.structures.IntegerStack;
import xyz.rajatjain.data.structures.Stack;

/**
 * @author rajatjain on - 18-12-2021
 * @project dsAlgo
 */
public class InfixToPostfix {

    private Stack<Character> operatorStack;
    private StringBuilder output;
    private String input;

    public InfixToPostfix(String input) {
        this.input = input;
        operatorStack = new Stack<>(input.length());
        output = new StringBuilder();
    }

    public String convert(){

    }

}
