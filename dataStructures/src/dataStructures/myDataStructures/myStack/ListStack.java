package dataStructures.myDataStructures.myStack;

public class ListStack<T> {
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;
    private int size;

    public void push(T data) {
        StackNode<T> newNode = new StackNode<T>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        try {
            if (top == null)
                throw new NullPointerException("Stack is empty");
        } catch (NullPointerException e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
        } finally {
            T temp = top.data;
            top = top.next;
            return temp;
        }
    }

    public T peek() {
        try {
            if (top == null)
                throw new NullPointerException("Stack is empty");
        } catch (NullPointerException e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
        } finally {
            return top.data;
        }
    }

    public boolean isEmpty() {
        if (top == null) return true;

        return false;
    }
}