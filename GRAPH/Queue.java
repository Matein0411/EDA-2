// Queue.java
// Class to implement the queue used in BFS (Breadth-First Search)
////////////////////////////////////////////////////////////////
public class Queue {
    private final int SIZE = 20;
    private char[] queArray;
    private int front;
    private int rear;

    // Constructor
    public Queue() {
        queArray = new char[SIZE];
        front = 0;
        rear = -1;
    }

    /**
     * Insert an item into the queue.
     * @param value the item to be inserted into the queue
     */
    public void insert(char value) {
        if (rear == SIZE - 1)
            rear = -1;
        queArray[++rear] = value;
        System.out.println("Inserted: " + value);
    }

    /**
     * Remove an item from the queue.
     * @return the item removed from the queue
     */
    public char remove() {
        char value = queArray[front++];
        if (front == SIZE)
            front = 0;
        System.out.println("Removed: " + value);
        return value;
    }

    /**
     * Peek at the front item of the queue without removing it.
     * @return the front item of the queue
     */
    public char peek() {
        return queArray[front];
    }

    /**
     * Check if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return (rear + 1 == front || (front + SIZE - 1 == rear));
    }
}