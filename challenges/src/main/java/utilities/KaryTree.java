package utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KaryTree<T> {
    KaryNode<T> root = null;

    public KaryTree() {}

    public KaryTree(KaryNode<T> root) { this.root = root; }

    public KaryNode<T> getRoot() { return root; }

    public void setRoot(KaryNode<T> root) { this.root = root; }

    static class KaryNode<T> {
        private T value;
        private List<KaryNode<T>> children = new ArrayList<>();

        public KaryNode(T value) { this.value = value; }

        public boolean addChild(KaryNode<T> child) { return this.children.add(child); }

        public T getValue() { return value; }

        public List<KaryNode<T>> getChildren() { return children; }
    }
}
