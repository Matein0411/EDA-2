// StackX.java
// Class to implement the stack used in DFS (Depth-First Search)
////////////////////////////////////////////////////////////////

public class StackX {
    private final int SIZE = 20;
    private int[] stackArray;
    private int top;

    // Constructor
    public StackX() {
        stackArray = new int[SIZE];    // Create array
        top = -1;
    }

    /**
     * Push an item onto the stack.
     * @param value the item to be pushed onto the stack
     */
    public void push(int value) {
        stackArray[++top] = value;
    }

    /**
     * Pop an item from the stack.
     * @return the item popped from the stack
     */
    public int pop() {
        return stackArray[top--];
    }

    /**
     * Peek at the top item of the stack without removing it.
     * @return the top item of the stack
     */
    public int peek() {
        return stackArray[top];
    }

    /**
     * Check if the stack is empty.
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Display all items in the stack by popping them.
     */
    public void display() {
        while (!isEmpty()) {
            System.out.print(pop() + " ");
        }
    }
}  // end class StackX
////////////////////////////////////////////////////////////////
