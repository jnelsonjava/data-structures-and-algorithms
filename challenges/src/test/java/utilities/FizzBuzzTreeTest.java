package utilities;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FizzBuzzTreeTest {
    static KaryTree<Integer> makeInputTree() {
        KaryTree.KaryNode<Integer> rootNode = new KaryTree.KaryNode<>(1);
        KaryTree.KaryNode<Integer> childA = new KaryTree.KaryNode<>(3);
        KaryTree.KaryNode<Integer> childB = new KaryTree.KaryNode<>(5);
        KaryTree.KaryNode<Integer> childC = new KaryTree.KaryNode<>(15);
        KaryTree.KaryNode<Integer> childAA = new KaryTree.KaryNode<>(2);
        KaryTree.KaryNode<Integer> childBA = new KaryTree.KaryNode<>(4);
        KaryTree.KaryNode<Integer> childBB = new KaryTree.KaryNode<>(9);
        KaryTree.KaryNode<Integer> childBC = new KaryTree.KaryNode<>(10);
        KaryTree.KaryNode<Integer> childBD = new KaryTree.KaryNode<>(8);
        KaryTree.KaryNode<Integer> childCA = new KaryTree.KaryNode<>(8);
        rootNode.addChild(childA);
        rootNode.addChild(childB);
        rootNode.addChild(childC);
        childA.addChild(childAA);
        childB.addChild(childBA);
        childB.addChild(childBB);
        childB.addChild(childBC);
        childB.addChild(childBD);
        childC.addChild(childCA);
        return new KaryTree<>(rootNode);
    }

    @Test
    public void testRootNodeConvertedIntToString() {
        KaryTree<Integer> inputTree = makeInputTree();
        KaryTree<String> outputTree = FizzBuzzTree.fizzBuzzTree(inputTree);
        assertEquals("root value 1 should convert to '1'", "1", outputTree.getRoot().getValue());
        List<KaryTree.KaryNode<String>> childSet = outputTree.getRoot().getChildren();
        System.out.println(childSet.size());
        System.out.println(outputTree.getRoot().getChildren());
    }

    @Test
    public void testChildNodesContainAllFizzBuzzCombos() {
        KaryTree<Integer> inputTree = makeInputTree();
        KaryTree<String> outputTree = FizzBuzzTree.fizzBuzzTree(inputTree);
        List<KaryTree.KaryNode<String>> childList = outputTree.getRoot().getChildren();

        assertEquals("child set should have 3 values", 3, childList.size());
        assertEquals("should contain 'Fizz'", "Fizz", childList.get(0).getValue());
        assertEquals("should contain 'Buzz'", "Buzz", childList.get(1).getValue());
        assertEquals("should contain 'FizzBuzz'", "FizzBuzz", childList.get(2).getValue());
    }

    @Test
    public void testGrandChildNodes() {
        KaryTree<Integer> inputTree = makeInputTree();
        KaryTree<String> outputTree = FizzBuzzTree.fizzBuzzTree(inputTree);
        List<KaryTree.KaryNode<String>> childList = outputTree.getRoot().getChildren();
        List<KaryTree.KaryNode<String>> gChildA = childList.get(0).getChildren();
        List<KaryTree.KaryNode<String>> gChildB = childList.get(1).getChildren();
        List<KaryTree.KaryNode<String>> gChildC = childList.get(2).getChildren();
        assertEquals("should contain '2'", "2", gChildA.get(0).getValue());
        assertEquals("should contain '4'", "4", gChildB.get(0).getValue());
        assertEquals("should contain 'Fizz'", "Fizz", gChildB.get(1).getValue());
        assertEquals("should contain 'Buzz'", "Buzz", gChildB.get(2).getValue());
        assertEquals("should contain '8'", "8", gChildB.get(3).getValue());
        assertEquals("should contain '8'", "8", gChildC.get(0).getValue());
    }
}
