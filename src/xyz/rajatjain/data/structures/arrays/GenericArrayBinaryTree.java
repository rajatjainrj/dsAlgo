package xyz.rajatjain.data.structures.arrays;

import xyz.rajatjain.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author rajatjain on - 13-01-2022
 * @project dsAlgo
 */
public class GenericArrayBinaryTree<T> {

    private final ArrayList<T> tree;
    private int noOfNodes;


    public GenericArrayBinaryTree() {
        this.tree = new ArrayList<>();
        tree.add(0, null);
        noOfNodes = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GenericArrayBinaryTree<Integer> tree = new GenericArrayBinaryTree<>();

        runMenuProgram(scanner, tree);

    }

    private static void runMenuProgram(Scanner scanner, GenericArrayBinaryTree<Integer> tree) {
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
                    value = inputValue(scanner, "Value");
                    tree.insertValue(value);
                    break;
                case 11:
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
        System.out.println("10. Insert Value");
        System.out.println("11. Exit");
    }

    private int findPositionOfValue(T value) {
        for (int i = 1; i <= noOfNodes; i++) {
            if (tree.get(i).equals(value)) {
                return i;
            }
        }
        return 0;
    }

    private static int inputValue(Scanner scanner, String type) {
        System.out.println("Enter " + type);
        return scanner.nextInt();
    }

    public T getLeftChildNodeForPosition(int position) {
        if (position > noOfNodes || position <= 0) {
            System.out.println("Node does not exists");
            return null;
        } else {
            int leftChildNodeIndex = (2 * position);
            if (leftChildNodeIndex > noOfNodes) {
                System.out.println("No Left Child");
                return null;
            }
            return tree.get(leftChildNodeIndex);
        }
    }

    public T getLeftChildNodeForValue(T value) {
        int position = findPositionOfValue(value);
        if (position == 0) {
            System.out.println("Value not found in tree");
            return null;
        }
        return getLeftChildNodeForPosition(position);
    }

    public T getRightChildNodeForPosition(int position) {
        if (position > noOfNodes || position <= 0) {
            System.out.println("Node does not exists");
            return null;
        } else {
            int rightChildNodeIndex = (2 * position + 1);
            if (rightChildNodeIndex > noOfNodes) {
                System.out.println("No Left Child");
                return null;
            }
            return tree.get(rightChildNodeIndex);
        }
    }

    public T getRightChildNodeForValue(T value) {
        int position = findPositionOfValue(value);
        if (position == 0) {
            System.out.println("Value not found in tree");
            return null;
        }
        return getRightChildNodeForPosition(position);
    }

    public T getParentNodeForPosition(int position) {
        if (position > noOfNodes || position <= 0) {
            System.out.println("Node does not exists");
            return null;
        } else {
            return tree.get((position / 2));
        }
    }

    public T getParentNodeForValue(T value) {
        int position = findPositionOfValue(value);
        if (position == 0) {
            System.out.println("Value not found in tree");
            return null;
        }
        return getParentNodeForPosition(position);
    }

    public T getRootNode() {
        if (noOfNodes == 0) {
            System.out.println("The tree is empty");
            return null;
        }
        return tree.get(1);
    }

    public boolean deleteValueFromTree(T value) {
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
        tree.set(position, tree.get(noOfNodes));
        tree.set(noOfNodes, null);
        noOfNodes--;
        return true;
    }

    public void insertValue(T value) {
        tree.add(++noOfNodes, value);
    }

    private void printValues() {
        System.out.print("The Tree is - [");
        for (int i = 1; i <= noOfNodes; i++) {
            System.out.print(tree.get(i));
            if (i == noOfNodes) {
                System.out.println("]");
            } else {
                System.out.print(",");
            }
        }
    }


}
