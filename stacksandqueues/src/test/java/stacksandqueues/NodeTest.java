package stacksandqueues;

import org.junit.Test;

import static org.junit.Assert.*;

public class NodeTest {
    @Test public void testNewNode() {
        Node node = new Node(3);
        assertNotNull("a new Node should exist", node);
    }

    @Test public void testGetValue() {
        Node node = new Node(3);
        assertEquals("should return value field", 3, node.getValue());
        Node node2 = new Node(4);
        assertEquals("should return value field", 4, node2.getValue());
    }

    @Test public void testSetValue() {
        Node node = new Node(3);
        node.setValue(1);
        assertEquals("should return newly set value field", 1, node.getValue());
        Node node2 = new Node(4);
        node2.setValue(8);
        assertEquals("should return newly set value field", 8, node2.getValue());
    }

    @Test public void testGetNext() {
        Node node = new Node(3);
        Node node2 = new Node(4);
        assertNull("next field should be null", node.getNext());
        assertNull("next field should be null", node2.getNext());
    }

    @Test public void testSetNext() {
        Node node = new Node(3);
        Node node2 = new Node(4);
        node.setNext(node2);
        assertEquals("next field should point to exact object set", node2, node.getNext());
        Node node3 = new Node(5);
        node.setNext(node3);
        assertEquals("next field should be updated", node3, node.getNext());
    }

    @Test public void testToString() {
        Node node = new Node(3);
        assertEquals("should pretty print", "{3}", node.toString());
        node.setValue(4);
        assertEquals("should pretty print", "{4}", node.toString());
    }
}
