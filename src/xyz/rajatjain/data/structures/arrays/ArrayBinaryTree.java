package xyz.rajatjain.data.structures.arrays;

import xyz.rajatjain.utils.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author rajatjain on - 13-01-2022
 * @project dsAlgo
 */
public class ArrayBinaryTree {

    private final int[] tree;
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
                    System.out.println(tree.getLeftChildNodeForPosition(value));
                    break;
                case 4:
                    value = inputValue(scanner, "Position");
                    System.out.println(tree.getRightChildNodeForPosition(value));
                    break;
                case 5:
                    value = inputValue(scanner, "Value");
                    System.out.println(tree.getParentNodeForValue(value));
                    break;
                case 6:
                    value = inputValue(scanner, "Value");
                    System.out.println(tree.getLeftChildNodeForValue(value));
                    break;
                case 7:
                    value = inputValue(scanner, "Value");
                    System.out.println(tree.getRightChildNodeForValue(value));
                    break;
                case 8:
                    tree.printValues();
                    break;
                case 9:
                    value = inputValue(scanner, "Value");
                    System.out.println(tree.deleteValueFromTree(value));
                    break;
                case 10:
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
        System.out.println("8. Print Tree Array");
        System.out.println("9. Delete Value from Tree");
        System.out.println("10. Exit");
    }

    private int findPositionOfValue(int value) {
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

    public int getLeftChildNodeForPosition(int position) {
        if (position > noOfNodes || position <= 0) {
            System.out.println("Node does not exists");
            return 0;
        } else {
            int leftChildNodeIndex = (2 * position);
            if (leftChildNodeIndex > noOfNodes) {
                System.out.println("No Left Child");
                return 0;
            }
            return tree[leftChildNodeIndex];
        }
    }

    public int getLeftChildNodeForValue(int value) {
        int position = findPositionOfValue(value);
        if (position == 0) {
            System.out.println("Value not found in tree");
            return 0;
        }
        return getLeftChildNodeForPosition(position);
    }

    public int getRightChildNodeForPosition(int position) {
        if (position > noOfNodes || position <= 0) {
            System.out.println("Node does not exists");
            return 0;
        } else {
            int rightChildNodeIndex = (2 * position + 1);
            if (rightChildNodeIndex > noOfNodes) {
                System.out.println("No Left Child");
                return 0;
            }
            return tree[rightChildNodeIndex];
        }
    }

    public int getRightChildNodeForValue(int value) {
        int position = findPositionOfValue(value);
        if (position == 0) {
            System.out.println("Value not found in tree");
            return 0;
        }
        return getRightChildNodeForPosition(position);
    }

    public int getParentNodeForPosition(int position) {
        if (position > noOfNodes || position <= 0) {
            System.out.println("Node does not exists");
            return 0;
        } else {
            return tree[(position / 2)];
        }
    }

    public int getParentNodeForValue(int value) {
        int position = findPositionOfValue(value);
        if (position == 0) {
            System.out.println("Value not found in tree");
            return 0;
        }
        return getParentNodeForPosition(position);
    }

    public int getRootNode() {
        return tree[1];
    }

    public boolean deleteValueFromTree(int value) {
        int position = findPositionOfValue(value);
        if (position == 0) {
            System.out.println("Value not found in Tree");
            return false;
        }
        return deleteValueFromTreeByPosition(position);
    }

    private boolean deleteValueFromTreeByPosition(int position) {
        if (position > noOfNodes || position <= 0) {
            System.out.println("Node does not exists");
            return false;
        }
        ArrayUtils.swapValuesByIndex(tree, position, noOfNodes);
        tree[noOfNodes] = 0;
        noOfNodes--;
        return true;
    }

    private void printValues() {
        System.out.print("The Tree is - ");
        System.out.println(Arrays.toString(tree));
    }


}
