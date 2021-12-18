package xyz.rajatjain.data.structures;

import java.util.Scanner;

/**
 * @author rajatjain on - 18-12-2021
 * @project dsAlgo
 */
public class StackMin {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Please Input the size of the stack - ");
        int size = in.nextInt();
        System.out.println("Please Input the size of the stack operations/queries - ");
        int queries = in.nextInt();
        int i = 0;

        Stack stack = new Stack(size);

        System.out.println("Please Input operations/queries one by one- ");
        while (i++ < queries) {
            switch (in.next()) {
                case "push":
                    stack.push(in.nextInt());
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "min":
                    System.out.println(stack.getMin());
            }
        }
    }

}
