// Queue.java
// Class to implement the queue used in BFS (Breadth-First Search)
////////////////////////////////////////////////////////////////

public class Queue {
    private final int SIZE = 20;
    private int[] queueArray;
    private int front;
    private int rear;

    // Constructor
    public Queue() {
        queueArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    /**
     * Inserts an item into the queue.
     * @param item the item to be inserted
     */
    public void insert(int item) {
        if (rear == SIZE - 1) {
            rear = -1;
        }
        queueArray[++rear] = item;
    }

    /**
     * Removes an item from the queue.
     * @return the removed item
     */
    public int remove() {
        int temp = queueArray[front++];
        if (front == SIZE) {
            front = 0;
        }
        return temp;
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return (rear + 1 == front || (front + SIZE - 1 == rear));
    }
}  // end class Queue
////////////////////////////////////////////////////////////////
