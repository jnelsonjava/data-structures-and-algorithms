package tree;

import org.junit.Test;

import static org.junit.Assert.*;

public class TreeTest {
    @Test public void testEmptyTree() {
        Tree tree = new Tree();
        assertNotNull("tree should be instantiated", tree);
        assertNull("root should be empty", tree.root);
    }

    @Test public void testTreeWithNode() {
        Tree tree = new Tree(new Node(1));
        assertNotNull("tree should be instantiated", tree);
        assertEquals("root should have input value", 1, tree.getRoot().getValue());
    }
}
