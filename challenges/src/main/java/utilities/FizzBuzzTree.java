package utilities;

public class FizzBuzzTree {
    public static KaryTree<String> fizzBuzzTree(KaryTree<Integer> inputTree) {
        // initialize the output tree
        KaryTree<String> outputTree = new KaryTree<String>();
        // edge case: If the input tree is empty, return an empty output tree
        if (inputTree.getRoot() == null) return outputTree;
        // assign root from fizzbuzzed tree and return
        outputTree.setRoot(fizzBuzzer(inputTree.getRoot()));
        return outputTree;
    }

    private static KaryTree.KaryNode<String> fizzBuzzer(KaryTree.KaryNode<Integer> current) {
        KaryTree.KaryNode<String> newNode = new KaryTree.KaryNode<>(fizzBuzzConverter(current.getValue()));
        for (KaryTree.KaryNode<Integer> child : current.getChildren()) {
            newNode.addChild(fizzBuzzer(child));
        }
        return newNode;
    }

    private static String fizzBuzzConverter(int value) {
        if (value % 3 == 0 && value % 5 == 0) return "FizzBuzz";
        if (value % 3 == 0) return "Fizz";
        if (value % 5 == 0) return "Buzz";
        return Integer.toString(value);
    }
}
