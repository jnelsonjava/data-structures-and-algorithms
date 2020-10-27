package utilities;

import org.junit.Test;
import tree.BinaryTree;
import tree.Node;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TreeIntersectionTest {
    static Node makeTreeA() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setRight(six);
        return one;
    }

    static Node makeTreeB() {
        Node one = new Node(1);
        Node eightA = new Node(8);
        Node eightB = new Node(8);
        Node three = new Node(3);
        Node fourA = new Node(4);
        Node fourB = new Node(4);
        Node six = new Node(6);
        one.setLeft(eightA);
        one.setRight(six);
        eightA.setLeft(eightB);
        eightA.setRight(three);
        six.setLeft(fourA);
        six.setRight(fourB);
        return one;
    }

    static Node makeTreeC() {
        Node one = new Node(10);
        Node eightA = new Node(80);
        Node eightB = new Node(80);
        Node three = new Node(30);
        Node fourA = new Node(40);
        Node fourB = new Node(40);
        Node six = new Node(60);
        one.setLeft(eightA);
        one.setRight(six);
        eightA.setLeft(eightB);
        eightA.setRight(three);
        six.setLeft(fourA);
        six.setRight(fourB);
        return one;
    }

    @Test
    public void testBasicTreeIntersection() {
        BinaryTree treeA = new BinaryTree(makeTreeA());
        BinaryTree treeB = new BinaryTree(makeTreeB());
        int[] expectedValues = {1, 4, 3, 6};
        HashSet<Integer> resultSet = TreeIntersection.treeIntersection(treeA, treeB);

        for (int val : expectedValues) {
            assertTrue("value should be in result set", resultSet.contains(val));
        }
        assertEquals("result set should be same length as expected values", expectedValues.length, resultSet.size());
    }

    // Expect empty set since trees have no common values with one empty tree
    @Test
    public void testEmptyTreeA() {
        BinaryTree treeA = new BinaryTree();
        BinaryTree treeB = new BinaryTree(makeTreeB());
        HashSet<Integer> resultSet = TreeIntersection.treeIntersection(treeA, treeB);

        assertEquals("result set should be empty", 0, resultSet.size());
    }

    // Expect empty set since trees have no common values with one empty tree
    @Test
    public void testEmptyTreeB() {
        BinaryTree treeA = new BinaryTree(makeTreeA());
        BinaryTree treeB = new BinaryTree();
        HashSet<Integer> resultSet = TreeIntersection.treeIntersection(treeA, treeB);

        assertEquals("result set should be empty", 0, resultSet.size());
    }

    // Expect empty set since trees have no common values with two empty trees
    @Test
    public void testBothTreeEmpty() {
        BinaryTree treeA = new BinaryTree();
        BinaryTree treeB = new BinaryTree();
        HashSet<Integer> resultSet = TreeIntersection.treeIntersection(treeA, treeB);

        assertEquals("result set should be empty", 0, resultSet.size());
    }

    // Expect empty set since trees have no common values
    @Test
    public void testNoCommonValues() {
        BinaryTree treeA = new BinaryTree(makeTreeA());
        BinaryTree treeC = new BinaryTree(makeTreeC());
        HashSet<Integer> resultSet = TreeIntersection.treeIntersection(treeA, treeC);

        assertEquals("result set should be empty", 0, resultSet.size());
    }
}
