package utilities;

public class AnimalShelter {
    Node front;
    Node back;

    // If shelter is empty, adds Animal node as front
    // If there's a front but no back, adds Animal node as back and sets front node to point at back node
    // Otherwise adds Animal node to the back
    public void enqueue(Animal animal) {
        if (front == null) {
            front = new Node(animal);
        } else if (front.next == null) {
            back = new Node(animal);
            front.next = back;
        } else {
            back.next = new Node(animal);
            back = back.next;
        }
    }

    // returns the first dog or cat based on given pref
    // if the preferred animal type is not in the shelter, returns null
    // if the preferred animal is not a dog or cat, returns null
    // if the shelter is empty, returns null
    public Animal dequeue(String pref) {
        if (!pref.equals("dog") && !pref.equals("cat")) return null;
        if (front == null) return null;
        if (front.value.type.equals(pref)) {
            Node temp = front;
            front = front.next;
            return temp.value;
        }
        return recursiveSearch(front.next, front, pref);
    }

    // recursively checks nodes for given preference and returns the correct type if found
    // also sets the previous node's next field to point at the returned node's next to keep queue intact
    // returns null if the preferred type is not found
    private Animal recursiveSearch(Node node, Node prevNode, String pref) {
        if (node == null) return null;
        if (node.value.type.equals(pref)) {
            prevNode.next = node.next;
            return node.value;
        }
        return recursiveSearch(node.next, node, pref);
    }

    @Override
    public String toString() {
        return toString(front);
    }

    private String toString(Node node) {
        if (node == null) return "NULL";
        return String.format("{%s} -> %s", node.value.toString(), toString(node.next));
    }

    // helper class for managing data within animal shelter
    private static class Node {
        Animal value;
        Node next = null;

        public Node(Animal value) {
            this.value = value;
        }
//
//        public Node(Animal value, Node next) {
//            this.value = value;
//            this.next = next;
//        }
    }
}
