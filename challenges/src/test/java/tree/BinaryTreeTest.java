package tree;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BinaryTreeTest {
    static Node makeTree() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);
        four.setLeft(two);
        four.setRight(six);
        two.setLeft(one);
        two.setRight(three);
        six.setLeft(five);
        six.setRight(seven);
        return four;
    }

    @Test public void testPreOrder() {
        ArrayList<Integer> testArray = new ArrayList<>();
        BinaryTree tree = new BinaryTree(new Node(1));
        assertEquals("check that returns given array list", testArray, tree.preOrder(tree.getRoot(), testArray));
    }

    @Test public void testPreOrderOutput() {
        Node rootNode = makeTree();
        BinaryTree tree = new BinaryTree(rootNode);

        System.out.println(tree.preOrder(tree.getRoot(), new ArrayList<Integer>()));
        assertEquals("should add values of nodes as they are encountered",
                "[4, 2, 1, 3, 6, 5, 7]",
                tree.preOrder(tree.getRoot(), new ArrayList<Integer>()).toString());
    }

    @Test public void testInOrderOutput() {
        Node rootNode = makeTree();
        BinaryTree tree = new BinaryTree(rootNode);

        System.out.println(tree.inOrder(tree.getRoot(), new ArrayList<Integer>()));
        assertEquals("should add values of nodes as they are encountered",
                "[1, 2, 3, 4, 5, 6, 7]",
                tree.inOrder(tree.getRoot(), new ArrayList<Integer>()).toString());
    }

    @Test public void testPostOrderOutput() {
        Node rootNode = makeTree();
        BinaryTree tree = new BinaryTree(rootNode);

        System.out.println(tree.postOrder(tree.getRoot(), new ArrayList<Integer>()));
        assertEquals("should add values of nodes as they are encountered",
                "[1, 3, 2, 5, 7, 6, 4]",
                tree.postOrder(tree.getRoot(), new ArrayList<Integer>()).toString());
    }

    @Test public void testFindMaxValue() throws Exception {
        BinaryTree tree = new BinaryTree();
        assertThrows("an empty tree should return an exception",
                Exception.class,
                () -> tree.findMaximumValue());

        Node rootNode = makeTree();
        BinaryTree tree2 = new BinaryTree(rootNode);
        assertEquals("should find the max value all the way right", 7, tree2.findMaximumValue());

        Node seven = new Node(7);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node one = new Node(1);
        four.setLeft(two);
        four.setRight(six);
        two.setLeft(seven);
        two.setRight(three);
        six.setLeft(five);
        six.setRight(one);
        BinaryTree tree3 = new BinaryTree(four);
        assertEquals("should find the max value all the way left", 7, tree3.findMaximumValue());
    }

    @Test public void testAddBreadthFirst() {
        BinaryTree tree = new BinaryTree();
        tree.addBreadthFirst(4);
        System.out.println(tree.inOrder(tree.getRoot(), new ArrayList<Integer>()));
        tree.addBreadthFirst(2);
        System.out.println(tree.inOrder(tree.getRoot(), new ArrayList<Integer>()));
        tree.addBreadthFirst(6);
        System.out.println(tree.inOrder(tree.getRoot(), new ArrayList<Integer>()));
        tree.addBreadthFirst(1);
        System.out.println(tree.inOrder(tree.getRoot(), new ArrayList<Integer>()));
        tree.addBreadthFirst(3);
        System.out.println(tree.inOrder(tree.getRoot(), new ArrayList<Integer>()));
        tree.addBreadthFirst(5);
        System.out.println(tree.inOrder(tree.getRoot(), new ArrayList<Integer>()));
        tree.addBreadthFirst(7);
        System.out.println(tree.inOrder(tree.getRoot(), new ArrayList<Integer>()));
    }
}
