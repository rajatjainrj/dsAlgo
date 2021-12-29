package xyz.rajatjain.data.structures.arrays;

import java.util.ArrayList;

public class Stack<T> {

    private final int MAX_SIZE;
    private int TOP_OF_STACK;
    private final ArrayList<T> stack;

    public Stack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        stack = new ArrayList<>();
        TOP_OF_STACK = -1;
    }

    public Stack() {
        this(1000);
    }

    public boolean isFull() {
        return TOP_OF_STACK >= MAX_SIZE - 1;
    }

    public boolean isEmpty() {
        return TOP_OF_STACK < 0;
    }

    public boolean push(T item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            stack.add(++TOP_OF_STACK, item);
            System.out.println(item + " Pushed into Stack");
            return true;
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        } else {
            T item = stack.get(TOP_OF_STACK);
            stack.remove(TOP_OF_STACK);
            TOP_OF_STACK--;
            System.out.println(item + " popped from Stack");
            return item;
        }
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return null;
        } else {
            return stack.get(TOP_OF_STACK);
        }
    }

    public void printStack() {
        if (TOP_OF_STACK == -1) {
            System.out.println("Empty Stack - []");
            return;
        }
        System.out.print("[");
        for (int i = 0; i <= TOP_OF_STACK; i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.printStack();

        System.out.println("Is Empty - " + integerStack.isEmpty());

        integerStack.push(300);
        integerStack.push(302);
        integerStack.push(301);
        integerStack.push(303);
        integerStack.push(304);
        integerStack.push(305);

        integerStack.printStack();

        System.out.println("Is Empty - " + integerStack.isEmpty());
        System.out.println("Is Full - " + integerStack.isFull());

        integerStack.pop();
        integerStack.pop();
        integerStack.pop();
        integerStack.pop();

        integerStack.printStack();

        integerStack.push(307);
        integerStack.push(308);

        integerStack.printStack();

        System.out.println("TOS (PEEK)- " + integerStack.peek());

        integerStack.pop();
        integerStack.pop();
        integerStack.pop();
        integerStack.pop();
        integerStack.pop();

    }

}
