package dataStructures.myDataStructures;

import dataStructures.interfaces.StackI;

public class Stack implements StackI {
    private int[] stack;
    private int size;
    private int top;
    private int DEFAULT_SIZE = 10;

    public Stack() {
        this(-1);
    }

    public Stack(int size) {
        this.size = 0;
        this.stack = size > 0 ? new int[size] : new int[DEFAULT_SIZE];
        this.top = -1;
    }

    public void push(int x) {
        top = top + 1;

        try {
            if (top == stack.length)
                throw new IllegalAccessException("Stack is full.");
        } catch (IllegalAccessException e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
        } finally {
            this.stack[top] = x;
            this.size++;
        }
    }

    public int pop() {
        if (this.isEmpty()) 
            throw new NullPointerException("Stack is empty");
        
        top = top - 1;
        this.size--;
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