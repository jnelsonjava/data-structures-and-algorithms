package DataStructures.linkedList;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test public void testNewLinkedList() {
        LinkedList testList = new LinkedList();
        assertEquals("an empty linked list is instantiated", "NULL", testList.toString());
    }

    @Test public void testInsert() {
        LinkedList testList = new LinkedList();
        testList.insert(2);
        testList.insert(5);
        testList.insert(5);
        testList.insert(5);
        assertEquals("should return string representing all nodes", "{5} -> {5} -> {5} -> {2} -> NULL", testList.toString());
        testList.insert(-4);
        assertEquals("should now start with -4", "{-4} -> {5} -> {5} -> {5} -> {2} -> NULL", testList.toString());
    }

    @Test public void testIncludes() {
        LinkedList testList = new LinkedList();
        testList.insert(2);
        testList.insert(5);
        testList.insert(5);
        assertTrue("Should return true", testList.includes(5));
        assertFalse("Should return false", testList.includes(3));
    }

    @Test public void testAppend() {
        LinkedList testList = new LinkedList();
        testList.append(2);
        testList.insert(5);
        testList.insert(5);
        testList.insert(5);
        assertEquals("should return string representing all nodes", "{5} -> {5} -> {5} -> {2} -> NULL", testList.toString());
        testList.append(-4);
        assertEquals("should now end with -4", "{5} -> {5} -> {5} -> {2} -> {-4} -> NULL", testList.toString());
    }

    @Test public void testInsertBefore() throws Exception {
        LinkedList testList = new LinkedList();
        testList.append(2);
        testList.insert(5);
        testList.insert(5);
        testList.insert(5);
        assertEquals("should return string representing all nodes", "{5} -> {5} -> {5} -> {2} -> NULL", testList.toString());
        testList.insertBefore(2, 6);
        assertEquals("should now start include 6 before 2", "{5} -> {5} -> {5} -> {6} -> {2} -> NULL", testList.toString());
    }

    @Test public void testInsertAfter() throws Exception {
        LinkedList testList = new LinkedList();
        testList.append(2);
        testList.insert(5);
        testList.insert(5);
        testList.insert(5);
        assertEquals("should return string representing all nodes", "{5} -> {5} -> {5} -> {2} -> NULL", testList.toString());
        testList.insertAfter(5, 6);
        assertEquals("should now start include 6 after the first 5", "{5} -> {6} -> {5} -> {5} -> {2} -> NULL", testList.toString());
        testList.insertAfter(6, 0);
        assertEquals("should now start include 6 after the first 5", "{5} -> {6} -> {0} -> {5} -> {5} -> {2} -> NULL", testList.toString());
    }

    @Test public void testKthFromEnd() throws Exception {
        LinkedList testList = new LinkedList();
        testList.insert(4);
        assertEquals("linked list of size 1", 4, testList.kthFromEnd(0));

        testList.insert(3);
        testList.insert(2);
        testList.insert(1);
        assertEquals("should return value of node k from end", 2, testList.kthFromEnd(2));

        assertThrows(Exception.class, () -> testList.kthFromEnd(7));

        assertThrows("should throw an error when k is size of list", Exception.class, () -> testList.kthFromEnd(4));
        assertThrows("should throw an error when given negative input", Exception.class, () ->testList.kthFromEnd(-2));
    }

    @Test public void testZipLists() throws Exception {
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        assertThrows("both lists being empty should throw exception",
                Exception.class,
                () -> LinkedList.zipLists(ll1, ll2));

        ll1.insert(1);
        assertEquals("should return first list when second is empty", ll1, LinkedList.zipLists(ll1, ll2));
        assertEquals("should return second list when first is empty", ll1, LinkedList.zipLists(ll2, ll1));

        ll1.append(2);
        ll2.append(11);
        ll2.append(22);

        LinkedList outputList = new LinkedList();
        outputList.insert(1);
        outputList.append(11);
        outputList.append(2);
        outputList.append(22);

        assertEquals("lists should be zipped into one at equal length",
                outputList.toString(),
                LinkedList.zipLists(ll1, ll2).toString());

        LinkedList ll3 = new LinkedList();
        LinkedList ll4 = new LinkedList();
        ll3.insert(1);
        ll3.append(2);
        ll4.append(11);
        ll4.append(22);
        ll4.append(33);

        outputList.append(33);

        assertEquals("lists should be zipped into one with varying lengths",
                outputList.toString(),
                LinkedList.zipLists(ll3, ll4).toString());

        LinkedList ll5 = new LinkedList();
        LinkedList ll6 = new LinkedList();
        ll5.insert(1);
        ll5.append(2);
        ll5.append(3);
        ll5.append(4);
        ll6.append(11);
        ll6.append(22);
        ll6.append(33);

        LinkedList secondOutputList = new LinkedList();
        secondOutputList.insert(1);
        secondOutputList.append(11);
        secondOutputList.append(2);
        secondOutputList.append(22);
        secondOutputList.append(3);
        secondOutputList.append(33);
        secondOutputList.append(4);

        assertEquals("lists should be zipped into one with varying lengths",
                secondOutputList.toString(),
                LinkedList.zipLists(ll5, ll6).toString());
    }
}
