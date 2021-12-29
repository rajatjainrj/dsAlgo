package xyz.rajatjain.data.structures.arrays;

import java.util.ArrayList;

/**
 * @author rajatjain on - 29-12-2021
 * @project dsAlgo
 */
public class Queue<T> {

    private int FRONT;
    private int REAR;
    private int MAX_SIZE;
    private ArrayList<T> queue;

    public Queue(int size) {
        this.FRONT = -1;
        this.REAR = -1;
        this.MAX_SIZE = size;
        this.queue = new ArrayList<>();
    }

    public boolean isFull() {
        return REAR == MAX_SIZE - 1;
    }

    public boolean isEmpty() {
        return FRONT == -1;
    }

    public boolean enqueue(T data) {
        if (!isFull()) {
            REAR++;
            queue.add(REAR, data);
            if (FRONT == -1) {
                FRONT = 0;
            }
            System.out.println(data + " inserted");
            return true;
        } else {
            System.out.println("Queue Overflow");
            return false;
        }
    }

    public boolean dequeue() {
        if (!isEmpty()) {
            System.out.println(queue.get(FRONT) + " deleted");
        } else {
            System.out.println("Queue Underflow");
        }
        if (FRONT == REAR) {
            FRONT = -1;
            REAR = -1;
        } else {
            FRONT++;
        }
        return !isEmpty();
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Empty Queue - []");
            return;
        }
        System.out.print("Queue - FRONT = " + FRONT + " [");
        for (int i = FRONT; i <= REAR; i++) {
            System.out.print(queue.get(i) + " ");
        }
        System.out.println("] REAR = " + REAR);
    }

    public int getFRONT() {
        return FRONT;
    }

    public int getREAR() {
        return REAR;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public ArrayList<T> getQueue() {
        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(4);

        queue.enqueue(69);
        queue.enqueue(76);
        queue.enqueue(778);
        queue.printQueue();

        queue.enqueue(778);
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();

        queue.enqueue(34);
        queue.printQueue();

        queue.enqueue(45);
        queue.enqueue(88);
        queue.printQueue();

        queue.dequeue();
        queue.printQueue();
    }
}
