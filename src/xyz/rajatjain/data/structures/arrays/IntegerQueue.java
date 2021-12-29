package xyz.rajatjain.data.structures.arrays;

/**
 * @author rajatjain on - 29-12-2021
 * @project dsAlgo
 */
public class IntegerQueue {

    int FRONT;
    int REAR;
    int MAX_SIZE;
    int[] queue;

    public IntegerQueue(int size) {
        this.FRONT = -1;
        this.REAR = -1;
        this.MAX_SIZE = size;
        this.queue = new int[MAX_SIZE];
    }

    public boolean isFull() {
        return REAR == MAX_SIZE - 1;
    }

    public boolean isEmpty() {
        return FRONT == -1;
    }

    public boolean enqueue(int data) {
        if (!isFull()) {
            REAR++;
            queue[REAR] = data;
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
            System.out.println(queue[FRONT] + " deleted");
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
            System.out.print(queue[i] + " ");
        }
        System.out.println("] REAR = " + REAR);
    }

    public static void main(String[] args) {
        IntegerQueue queue = new IntegerQueue(4);

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
