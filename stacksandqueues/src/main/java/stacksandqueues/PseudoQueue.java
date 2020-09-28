package stacksandqueues;

public class PseudoQueue {
    Stack inputStack = new Stack();
    Stack outputStack = new Stack();

    public void enqueue(int value) {
        inputStack.push(value);
    }

    // used as reference for catch parameter https://www.w3schools.com/java/java_try_catch.asp
    public int dequeue() throws NullPointerException {
        try {
            // pops the output value unless stack is empty
            return outputStack.pop();
        } catch (NullPointerException e) {
            // runs the stack swap method and throws an error if input stack is empty
            stackSwap();
            return outputStack.pop();
        }
    }

    private void stackSwap() throws NullPointerException {
        // throws exception if input stack has nothing to swap
        inputStack.peek();

        try {
            while (true) {
                outputStack.push(inputStack.pop());
            }
        } catch (NullPointerException ignored) {
            // intellij suggested adding ignored
        }
    }
}
