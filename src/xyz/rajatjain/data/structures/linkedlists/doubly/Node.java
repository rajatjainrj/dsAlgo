package xyz.rajatjain.data.structures.linkedlists.doubly;

/**
 * @author rajatjain on - 29-12-2021
 * @project dsAlgo
 */
public class Node<T> {

    private T data;
    private Node<T> next;
    private Node<T> previous;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }
}
