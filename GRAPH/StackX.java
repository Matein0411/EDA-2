// StackX.java
// Class to implement the stack used in DFS (Depth-First Search)
////////////////////////////////////////////////////////////////
public class StackX {
    private final int SIZE = 20;
    private char[] stackArray;
    private int top;

    // Constructor
    public StackX() {
        stackArray = new char[SIZE];    // Create array
        top = -1;
    }

    /**
     * Push an item onto the stack.
     * @param value the item to be pushed onto the stack
     */
    public void push(char value) {
        stackArray[++top] = value;
        System.out.println("Pushed: " + value);
    }

    /**
     * Pop an item from the stack.
     * @return the item popped from the stack
     */
    public char pop() {
        char value = stackArray[top--];
        System.out.println("Popped: " + value);
        return value;
    }

    /**
     * Peek at the top item of the stack without removing it.
     * @return the top item of the stack
     */
    public char peek() {
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
}