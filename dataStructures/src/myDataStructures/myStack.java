package dataStructure.myDataStructures;

public class Stack implements StackI {
    private int[] stack;
    private int size;
    private int top;
    private int DEFAULT_SIZE = 10;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public Stack(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1;
    }

    public void push(int x) {
        top = top + 1;

        if (top == stack.length)
            throw new IllegalAccessException("Stack is full.");

        this.stack[top] = x;
    }

    public int pop() {
        if (this.isEmpty()) 
            throw new NullPointerException("Stack is empty");

        top = top - 1;
        return this.stack[top + 1];
    }

    public int peek() {
        if (this.isEmpty()) 
            throw new NullPointerException("Stack is empty");

        return this.stack[top];
    }

    public boolean isEmpty() {
        if (top == -1) return true;

        return false;
    }

    public int size() {
        return this.size;
    }
}