package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test public void testNewStack() {
        Stack stack = new Stack();
        assertNotNull("stack should exist", stack);
        assertNull("top field should instantiate as null", stack.top);
    }

    @Test public void testPush() {
        Stack stack = new Stack();
        stack.push(3);
        assertEquals("top field should have a node with given value", 3, stack.top.getValue());

        stack.push(4);
        assertEquals("top field should have a node with given value", 4, stack.top.getValue());
        assertEquals("top field should have a node with a next field pointing to the previous top node",
                3,
                stack.top.getNext().getValue());
    }

    @Test public void testIsEmpty() {
        Stack stack = new Stack();
        assertTrue("a new stack should return as empty", stack.isEmpty());

        stack.push(3);
        assertFalse("a stack with an existing node should return as not empty", stack.isEmpty());
    }

    @Test public void testPeek() {
        Stack stack = new Stack();
        assertThrows("peeking and empty stack should throw a null pointer exception",
                NullPointerException.class,
                () -> stack.peek());

        stack.push(3);
        assertEquals("should return top node's value", 3, stack.peek());
        stack.push(4);
        assertEquals("should return top node's value", 4, stack.peek());
    }

    @Test public void testPop() {
        Stack stack = new Stack();
        assertThrows("peeking and empty stack should throw a null pointer exception",
                NullPointerException.class,
                () -> stack.pop());

        stack.push(3);
        stack.push(4);
        assertEquals("should return value of top node", 4, stack.pop());
        assertEquals("top node should have been removed by pop", 3, stack.top.getValue());
        assertEquals("should return value of top node", 3, stack.pop());
        assertNull("both nodes should be removed to create empty stack", stack.top);
    }

    @Test public void testToString() {
        Stack stack = new Stack();
        assertEquals("NULL", stack.toString());

        stack.push(3);
        assertEquals("{3} -> NULL", stack.toString());

        stack.push(4);
        assertEquals("{4} -> {3} -> NULL", stack.toString());
    }
}
