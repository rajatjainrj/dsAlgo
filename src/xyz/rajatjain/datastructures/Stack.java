package xyz.rajatjain.datastructures;

public class Stack {

    int MAX_SIZE;
    int currentPointer;
    int[] stack;

    public Stack(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        stack = new int[MAX_SIZE];
        currentPointer = -1;
    }

    public Stack() {
        this(1000);
    }

    public boolean isFull() {
        if (currentPointer >= MAX_SIZE - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (currentPointer < 0) {
            return true;
        }
        return false;
    }

    public boolean push(int item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            stack[++currentPointer] = item;
            System.out.println(item + " Pushed into Stack");
            return true;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int item = stack[currentPointer--];
            System.out.println(item + " popped from Stack");
            return item;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            return stack[currentPointer];
        }
    }

    public void printStack() {
        if(currentPointer == -1){
            System.out.println("Empty Stack - []");
            return;
        }
        System.out.print("[");
        for (int i = 0; i <= currentPointer; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printStack();

        System.out.println("Is Empty - " + stack.isEmpty());

        stack.push(300);
        stack.push(302);
        stack.push(301);
        stack.push(303);
        stack.push(304);
        stack.push(305);

        stack.printStack();

        System.out.println("Is Empty - " + stack.isEmpty());
        System.out.println("Is Full - " + stack.isFull());

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        stack.printStack();

        stack.push(307);
        stack.push(308);

        stack.printStack();

    }

}
