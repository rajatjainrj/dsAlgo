package xyz.rajatjain.data.structures.linkedlists.singly;

/**
 * @author rajatjain on - 29-12-2021
 * @project dsAlgo
 */
public class LinkedList<T> {

    public LinkedList() {
        SIZE = 0;
    }

    public LinkedList(Node<T> head) {
        this();
        this.head = head;
        SIZE++;
    }

    private Node<T> head;
    private int SIZE;

    public int size() {
        return SIZE;
    }

    public void add(T data) {
        Node<T> currentNode = head;
        Node<T> node = new Node<>();
        node.setData(data);
        if (head == null) {
            head = node;
            return;
        }
        while (currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(node);
        SIZE++;
    }

    public void addFirst(T data) {
        Node<T> node = new Node<>();
        node.setData(data);
        node.setNext(head);
        head = node;
        SIZE++;
    }

    public void add(int index, T data) {
        Node<T> currentNode = head;
        Node<T> node = new Node<>();
        node.setData(data);
        if (index == 0) {
            node.setNext(head);
            head = node;
            return;
        }
        int i = 0;
        while (i < index - 1) {
            if (currentNode == null || currentNode.getNext() == null) {
                System.out.println("Invalid Index");
                return;
            }
            currentNode = currentNode.getNext();
            i++;
        }
        Node<T> temp = currentNode;
        node.setNext(temp.getNext());
        temp.setNext(node);
        currentNode.setNext(node);
        SIZE++;
    }

    public void print() {
        Node<T> currentNode = head;
        System.out.print("HEAD ");
        int i = 0;
        while (currentNode.getNext() != null) {
            System.out.print(i + "[" + currentNode.getData() + "]->");
            currentNode = currentNode.getNext();
            i++;
        }
        System.out.println(i + "[" + currentNode.getData() + "]->null");
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addFirst(56);
        linkedList.print();
        linkedList.addFirst(57);
        linkedList.print();
        linkedList.add(90);
        linkedList.print();
        linkedList.add(100);
        linkedList.print();
        linkedList.add(2, 104);
        linkedList.print();
        linkedList.add(4, 101);
        linkedList.print();
    }
}
