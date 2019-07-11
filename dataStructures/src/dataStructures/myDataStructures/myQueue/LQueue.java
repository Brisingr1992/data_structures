package dataStructures.myDataStructures.myQueue;

public class LQueue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data) {
            this.data = data;
        }
    }

    QueueNode<T> head;
    QueueNode<T> tail;

    public void add(T temp) {
        QueueNode<T> newNode = new QueueNode<T>(temp);
        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;
        if (head == null) {
            head = tail;
        }
    }

    public T poll() {
        try {
            if (this.isEmpty()) {
                throw new NullPointerException("Queue is empty!");
            }
        } catch (NullPointerException e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
        } finally {
            T temp = head.data;
            head = head.next;

            if (head == null) tail = head;
            return temp;
        }
    }

    public T peek() {
        try {
            if (this.isEmpty()) {
                throw new NullPointerException("Queue is empty!");
            }
        } catch (NullPointerException e) {
            System.err.println("[Exception Caught]: " + e.getMessage());
			e.printStackTrace();
			System.exit(1);
        } finally {
            return head.data;
        }
    }

    public boolean isEmpty() {
        if (head == null) return true;

        return false;
    }
}