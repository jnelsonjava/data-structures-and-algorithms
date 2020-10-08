package utilities;

import org.junit.Test;

import static org.junit.Assert.*;

public class KaryTreeTest {
    @Test
    public void newGenericNodeTest() {
        // testing String type nodes
        KaryTree.KaryNode<String> stringNode = new KaryTree.KaryNode<>("ok");
        assertNotNull("node should be instantiated", stringNode);
        assertEquals("value should return string", "ok", stringNode.getValue());
        assertEquals("child list should be start empty", 0, stringNode.getChildren().size());

        // testing Integer type nodes
        KaryTree.KaryNode<Integer> intNode = new KaryTree.KaryNode<>(3);
        assertNotNull("node should be instantiated", intNode);
        // issue with ambiguous return
        assertEquals("value should return integer", 3, (int) intNode.getValue());
        assertEquals("child list should be start empty", 0, intNode.getChildren().size());
    }

    @Test
    public void addChildNode() {
        KaryTree.KaryNode<String> rootNode = new KaryTree.KaryNode<>("root");
        KaryTree.KaryNode<String> childNode1 = new KaryTree.KaryNode<>("child1");
        KaryTree.KaryNode<String> childNode2 = new KaryTree.KaryNode<>("child2");

        // testing adding a child node
        assertTrue("set's add method should return true for successful add", rootNode.addChild(childNode1));
        assertTrue("child 1 should be in child set", rootNode.getChildren().contains(childNode1));
        assertFalse("child 2 should not be in child set", rootNode.getChildren().contains(childNode2));

        // testing adding the second node
        assertTrue("set's add method should return true for successful add", rootNode.addChild(childNode2));
        assertTrue("child 1 should still be in child set", rootNode.getChildren().contains(childNode1));
        assertTrue("child 2 should also be in child set", rootNode.getChildren().contains(childNode2));

        // testing adding a node already in the child set
        assertFalse("set's add method should return false for adding duplicate child", rootNode.addChild(childNode1));
    }

    @Test
    public void emptyTreeTest() {
        KaryTree tree = new KaryTree();
        assertNotNull("should be instantiated", tree);
        assertNull("root should be empty", tree.getRoot());
    }

    @Test
    public void newTreeWithRoot() {
        KaryTree.KaryNode<String> rootNode = new KaryTree.KaryNode<>("root node");
        KaryTree tree = new KaryTree(rootNode);
        assertNotNull("should be instantiated", tree);
        assertEquals("root should be set with node passed to constructor", rootNode, tree.getRoot());
    }
}
