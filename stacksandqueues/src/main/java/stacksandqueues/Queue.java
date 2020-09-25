package stacksandqueues;

public class Queue {
    Node front = null;
    Node back = null;

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int value) {
        Node node = new Node(value);
        if (isEmpty()) {
            front = node;
            back = node;
            return;
        }
        back.setNext(node);
        back = node;
    }

    public int dequeue() {
        if (isEmpty()) throw new NullPointerException();
        int output = front.getValue();
        front = front.getNext();
        if (front == null) back = null;
        return output;
    }

    public int peek() {
        if (isEmpty()) throw new NullPointerException();
        return front.getValue();
    }

    @Override
    public String toString() {
        return toString(front);
    }

    private String toString(Node node) {
        if (node == null) return "NULL";
        return String.format("%s -> ", node.toString()) + toString(node.getNext());
    }
}
