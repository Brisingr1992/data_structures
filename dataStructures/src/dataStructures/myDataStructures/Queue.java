package dataStructures.myDataStructures;

import dataStructures.interfaces.QueueI;

public class Queue implements QueueI {
    private int[] queue;
    private int size;
    private int head;
    private int tail;
    private int DEFAULT_SIZE = 10;

    public Queue() {
        this(-1);
    }

    public Queue(int size) {
        this.size = size == -1 ? DEFAULT_SIZE : size;;
        this.queue = new int[this.size];
        this.head = 0;
        this.tail = 0;
    }

    public void add(int x) {
        try {
            if (head == tail + 1)
                throw new IllegalAccessException("Queue is full.");
        } catch (IllegalAccessException e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
        } finally {
            queue[tail] = x;

            if (tail == size - 1) tail = 1;
            else tail = tail + 1;

            this.size++;
        }
    }

    public int remove() {
        if (this.isEmpty())
            throw new NullPointerException("Queue is empty");

        int x = queue[head];
        if (head == size - 1)
            head = 1;
        else head = head + 1;

        this.size--;
        return x;
    }

    public int peek() {
        if (this.isEmpty())
            throw new NullPointerException("Queue is empty");

        return queue[head];
    }

    public boolean isEmpty() {
        if (head == tail) return true;

        return false;
    }

    public int size() {
        return this.size;
    }
}