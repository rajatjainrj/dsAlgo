package xyz.rajatjain.data.structures.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rajatjain on - 13-01-2022
 * @project dsAlgo
 */
public class ArrayBinaryTree {

    private int tree[];
    private int noOfNodes;


    public ArrayBinaryTree(int noOfNodes) {
        this.tree = new int[noOfNodes + 1];
        this.noOfNodes = noOfNodes;
        Arrays.fill(tree, 0);
    }

    public static void main(String[] args) {
        System.out.println("Please enter no of nodes - ");
        Scanner scanner = new Scanner(System.in);
        int noOfNodes = scanner.nextInt();

        ArrayBinaryTree tree = new ArrayBinaryTree(noOfNodes);

        tree.insertTreeValues(scanner);

        runMenuProgram(scanner, tree);

    }

    private static void runMenuProgram(Scanner scanner, ArrayBinaryTree tree) {
        boolean exit = false;
        while (!exit) {
            printOptions();

            int choice = scanner.nextInt();
            int value;
            int position;
            switch (choice) {
                case 1:
                    System.out.println(tree.getRootNode());
                    break;
                case 2:
                    value = inputValue(scanner, "Position");
                    System.out.println(tree.getParentNodeForPosition(value));
                    break;
                case 3:
                    value = inputValue(scanner, "Position");
                    System.out.println(tree.getLeftNodeForPosition(value));
                    break;
                case 4:
                    value = inputValue(scanner, "Position");
                    System.out.println(tree.getRightNodeForPosition(value));
                    break;
                case 5:
                    value = inputValue(scanner, "Value");
                    position = tree.findIndexOfValue(value);
                    System.out.println(tree.getParentNodeForPosition(position));
                    break;
                case 6:
                    value = inputValue(scanner, "Value");
                    position = tree.findIndexOfValue(value);
                    System.out.println(tree.getLeftNodeForPosition(position));
                    break;
                case 7:
                    value = inputValue(scanner, "Value");
                    position = tree.findIndexOfValue(value);
                    System.out.println(tree.getRightNodeForPosition(position));
                    break;
                case 8:
                    exit = true;
                    break;
            }
        }
    }

    private static void printOptions() {
        System.out.println("Please select an operation - ");
        System.out.println("1. Get Root node");
        System.out.println("2. Get Parent node for position");
        System.out.println("3. Get Left Child node for position");
        System.out.println("4. Get Right Child node for position");
        System.out.println("5. Get Parent node for value");
        System.out.println("6. Get Left Child node for value");
        System.out.println("7. Get Right Child node for value");
        System.out.println("8. Exit");
    }

    private int findIndexOfValue(int value) {
        for (int i = 1; i <= noOfNodes; i++) {
            if (tree[i] == value) {
                return i;
            }
        }
        return 0;
    }

    private static int inputValue(Scanner scanner, String type) {
        System.out.println("Enter " + type);
        return scanner.nextInt();
    }

    public void insertTreeValues(Scanner scanner) {
        System.out.println("Enter tree node values - ");
        for (int i = 1; i <= noOfNodes; i++) {
            System.out.println("Enter the value of Node - " + i);
            tree[i] = scanner.nextInt();
        }
        System.out.println("Tree values inserted successfully.");
        printValues();
    }

    public int getLeftNodeForPosition(int position) {
        if (position > noOfNodes || position <= 0) {
            System.out.println("Node does not exists");
            return 0;
        } else {
            int leftChildNodeIndex = (2 * position);
            if(leftChildNodeIndex > noOfNodes){
                System.out.println("No Left Child");
                return 0;
            }
            return tree[leftChildNodeIndex];
        }
    }

    public int getRightNodeForPosition(int position) {
        if (position > noOfNodes || position <= 0) {
            System.out.println("Node does not exists");
            return 0;
        } else {
            int rightChildNodeIndex = (2 * position + 1);
            if(rightChildNodeIndex > noOfNodes){
                System.out.println("No Left Child");
                return 0;
            }
            return tree[rightChildNodeIndex];
        }
    }

    public int getParentNodeForPosition(int position) {
        if (position > noOfNodes || position <= 0) {
            System.out.println("Node does not exists");
            return 0;
        } else {
            return tree[(position / 2)];
        }
    }

    public int getRootNode() {
        return tree[1];
    }

    private void printValues() {
        System.out.print("The Tree is - ");
        System.out.println(Arrays.toString(tree));
    }


}
