package xyz.rajatjain.algebraic.notations;

/**
 * @author rajatjain on - 18-12-2021
 * @project dsAlgo
 */
public class InfixToPrefix {

    private final String input;
    private final InfixToPostfix infixToPostfix;

    public InfixToPrefix(String input) {
        this.input = input;
        this.infixToPostfix = new InfixToPostfix(reverseInfixExpression(input));
    }

    private String reverseInfixExpression(String input) {
        return reverseParentheses(reverseString(input));
    }

    private String reverseParentheses(String reversedInput) {
        char[] charArray = reversedInput.toCharArray();
        for (int i=0; i<charArray.length; i ++) {
            if (charArray[i] == '(') {
                charArray[i] = ')';
            }else if(charArray[i] == ')'){
                charArray[i] = '(';
            }
        }
        return new String(charArray);
    }

    private String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    private String convertToPostFix() {
        String reversedInfixToPostFix = infixToPostfix.convert();
        System.out.println("Reversed Infix to Post Fix Expression - " + reversedInfixToPostFix);
        return reverseString(reversedInfixToPostFix);
    }

    public static void main(String[] args) {
        InfixToPrefix infixToPrefix = new InfixToPrefix("2*4/(2-1)+6*4");
        System.out.println("Reversed Infix Expression - " + infixToPrefix.infixToPostfix.getInput());
        System.out.println("Final Infix to Pre Fix Expression - " + infixToPrefix.convertToPostFix());
    }


}
