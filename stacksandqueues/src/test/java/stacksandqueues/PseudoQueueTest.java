package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class PseudoQueueTest {
    @Test public void testNewPseudoQueue() {
        PseudoQueue pseudoQueue = new PseudoQueue();
        assertNotNull("pseudoQueue should be instantiated", pseudoQueue);
        assertNotNull("pseudoQueue stacks should be instantiated", pseudoQueue.inputStack);
        assertNotNull("pseudoQueue stacks should be instantiated", pseudoQueue.outputStack);
        assertThrows("stacks should be empty", NullPointerException.class, () -> pseudoQueue.inputStack.peek());
        assertThrows("stacks should be empty", NullPointerException.class, () -> pseudoQueue.outputStack.peek());
    }

    @Test public void testPseudoEnqueue() {
        PseudoQueue pseudoQueue = new PseudoQueue();
        pseudoQueue.enqueue(3);
        assertEquals("value should be added to inputStack", 3, pseudoQueue.inputStack.peek());
        assertThrows("outputStack should still be empty", NullPointerException.class, () -> pseudoQueue.outputStack.peek());
        pseudoQueue.enqueue(4);
        assertEquals("value should be added to inputStack", 4, pseudoQueue.inputStack.peek());
        assertThrows("outputStack should still be empty", NullPointerException.class, () -> pseudoQueue.outputStack.peek());
    }

    @Test public void  testPseudoDequeueBothStacksEmpty() {
        PseudoQueue pseudoQueue = new PseudoQueue();
        assertThrows("if both input and output stacks are empty, throw error",
                NullPointerException.class,
                () -> pseudoQueue.dequeue());
    }

    @Test public void testPseudoDequeueEmptyOutput() {
        PseudoQueue pseudoQueue = new PseudoQueue();
        pseudoQueue.enqueue(3);
        pseudoQueue.enqueue(4);
        pseudoQueue.enqueue(5);
        assertEquals("first value in should return", 3, pseudoQueue.dequeue());
        assertEquals("output stack should have second value in on top", 4, pseudoQueue.outputStack.peek());
        assertThrows("input stack should be empty", NullPointerException.class, () -> pseudoQueue.inputStack.peek());
        assertEquals("second value in should return", 4, pseudoQueue.dequeue());
        assertEquals("output stack should have third value in on top", 5, pseudoQueue.outputStack.peek());
        assertEquals("third value in should return", 5, pseudoQueue.dequeue());
        assertThrows("output stack should be empty", NullPointerException.class, () -> pseudoQueue.outputStack.peek());
    }

    @Test public void testPseudoDequeueMultipleEnqueues() {
        PseudoQueue pseudoQueue = new PseudoQueue();
        pseudoQueue.enqueue(3);
        pseudoQueue.enqueue(4);
        pseudoQueue.enqueue(5); // output stack "NULL" and input stack "{5} -> {4} -> {5} -> NULL"
        pseudoQueue.dequeue(); // output stack "{4} -> {5} -> NULL" and input stack "NULL"
        pseudoQueue.enqueue(10);
        pseudoQueue.enqueue(11);
        assertEquals("input stack should have last value on top", 11, pseudoQueue.inputStack.peek());
        assertEquals("output stack should retain second value on top", 4, pseudoQueue.outputStack.peek());
        assertEquals("should return top of output stack", 4, pseudoQueue.dequeue());
        assertEquals("input stack should be unchanged", 11, pseudoQueue.inputStack.peek());
        assertEquals("output stack will return last value", 5, pseudoQueue.dequeue());
        assertThrows("output stack is empty", NullPointerException.class, () -> pseudoQueue.outputStack.peek());
        assertEquals("should return first value from second round of enqueues", 10, pseudoQueue.dequeue());
        assertEquals("remaining value should be in output stack", 11, pseudoQueue.outputStack.peek());
        assertThrows("input stack should be empty", NullPointerException.class, () -> pseudoQueue.inputStack.peek());
    }
}
