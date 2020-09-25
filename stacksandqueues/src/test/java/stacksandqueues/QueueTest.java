package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    @Test public void testNewQueue() {
        Queue queue = new Queue();
        assertNotNull("queue should exist", queue);
        assertNull("front field should instantiate as null", queue.front);
        assertNull("back field should instantiate as null", queue.back);
    }

    @Test public void testEnqueue() {
        Queue queue = new Queue();
        queue.enqueue(3);
        assertEquals("front field should have a new node", 3, queue.front.getValue());
        assertEquals("back field should have the same node", 3, queue.back.getValue());

        queue.enqueue(4);
        assertEquals("front field should retain pointer to the previous node", 3, queue.front.getValue());
        assertEquals("back field should point to the new node", 4, queue.back.getValue());
    }

    @Test public void testIsEmpty() {
        Queue queue = new Queue();
        assertTrue("newly instantiated queue should return empty", queue.isEmpty());
        queue.enqueue(3);
        assertFalse("with any node in front, queue should return as not empty", queue.isEmpty());
        queue.enqueue(4);
        assertFalse("with multiple nodes, queue should return as not empty", queue.isEmpty());
    }

    @Test public void testDequeue() {
        Queue queue = new Queue();
        assertThrows("should throw null pointer exception with an empty queue",
                NullPointerException.class,
                () -> queue.dequeue());

        queue.enqueue(3); // initial front value 3
        queue.enqueue(4); // initial back value 4
        assertEquals("should return value of front", 3, queue.dequeue());
        assertEquals("should have removed front node and set front to next node", 4, queue.front.getValue());

        assertEquals("should return front nodes value", 4, queue.dequeue());
        assertNull("all nodes should be removed", queue.front);
        assertNull("all nodes should be removed", queue.back);
    }

    @Test public void testPeek() {
        Queue queue = new Queue();
        assertThrows("should throw null pointer exception with an empty queue",
                NullPointerException.class,
                () -> queue.peek());

        queue.enqueue(3); // initial front value 3
        queue.enqueue(4); // initial back value 4
        assertEquals("should peek value of front", 3, queue.peek());

        queue.dequeue(); // new front value 4
        assertEquals("should peek value of front", 4, queue.peek());
    }
}
