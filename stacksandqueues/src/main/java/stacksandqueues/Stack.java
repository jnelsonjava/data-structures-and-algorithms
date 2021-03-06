package stacksandqueues;

public class Stack {
    Node top = null;

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.setNext(top);
        top = newNode;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int pop() throws NullPointerException {
        if (isEmpty()) throw new NullPointerException();
        int output = top.getValue();
        top = top.getNext();
        return output;
    }

    public int peek() throws NullPointerException {
        if (isEmpty()) throw new NullPointerException();
        return top.getValue();
    }

    @Override
    public String toString() {
        return toString(top);
    }

    private String toString(Node node) {
        if (node == null) return "NULL";
        return String.format("%s -> ", node.toString()) + toString(node.getNext());
    }
}
