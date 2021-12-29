package xyz.rajatjain.data.structures.arrays;

public class IntegerStack {

    int MAX_SIZE;
    int TOP_OF_STACK;
    int[] stack;

    public IntegerStack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        stack = new int[MAX_SIZE];
        TOP_OF_STACK = -1;
    }

    public IntegerStack() {
        this(1000);
    }

    public boolean isFull() {
        if (TOP_OF_STACK >= MAX_SIZE - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (TOP_OF_STACK < 0) {
            return true;
        }
        return false;
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            stack[++TOP_OF_STACK] = item;
            System.out.println(item + " Pushed into Stack");
            return true;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int item = stack[TOP_OF_STACK--];
            System.out.println(item + " popped from Stack");
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return stack[TOP_OF_STACK];
        }
    }

    public void printStack() {
        if (TOP_OF_STACK == -1) {
            System.out.println("Empty Stack - []");
            return;
        }
        System.out.print("[");
        for (int i = 0; i <= TOP_OF_STACK; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        IntegerStack integerStack = new IntegerStack();
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

    public int getMin() {
        if(isEmpty()){
            System.out.println("Stack Underflow");
        }

        int min = stack[0];
        for (int i = 0; i <= TOP_OF_STACK; i++) {
            if(min > stack[i]){
                min = stack[i];
            }
        }
        return min;
    }

}
