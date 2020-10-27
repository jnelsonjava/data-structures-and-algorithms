package utilities;

import tree.BinaryTree;
import tree.Node;

import java.util.HashSet;

public class TreeIntersection {
    public static HashSet<Integer> treeIntersection(BinaryTree treeA, BinaryTree treeB) {
        HashSet<Integer> setA = new HashSet<>();
        HashSet<Integer> setB = new HashSet<>();
        fillSetFromTree(treeA.getRoot(), setA);
        fillSetFromTree(treeB.getRoot(), setB, setA);
        return setB;
    }

    private static void fillSetFromTree(Node treeNode, HashSet<Integer> set) {
        if (treeNode != null) {
            set.add(treeNode.getValue());
            fillSetFromTree(treeNode.getLeft(), set);
            fillSetFromTree(treeNode.getRight(), set);
        }
    }

    private static void fillSetFromTree(Node treeNode, HashSet<Integer> set, HashSet<Integer> checkSet) {
        if (treeNode != null) {
            if (checkSet.contains(treeNode.getValue())) set.add(treeNode.getValue());
            fillSetFromTree(treeNode.getLeft(), set, checkSet);
            fillSetFromTree(treeNode.getRight(), set, checkSet);
        }
    }
}
