package DataStructures.linkedList;

public class LinkedList {

    public Node head = null;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (this.head != null) {
            newNode.setNext(this.head);
        }
        this.head = newNode;
    }

    public String toString() {
        if (this.head == null) {
            return "NULL";
        }
        String output = String.format("{%s}", this.head.toString());
        Node nextNode = this.head.getNext();
        while (nextNode != null) {
            output += String.format(" -> {%s}", nextNode.toString());
            nextNode = nextNode.getNext();
        }
        output += " -> NULL";
        return output;
    }

    public boolean includes(int value) {
        if (this.head == null) {
            return false;
        }
        if (this.head.getValue() == value) {
            return true;
        }
        Node nextNode = this.head.getNext();
        while (nextNode != null) {
            if (nextNode.getValue() == value) {
                return true;
            }
            nextNode = nextNode.getNext();
        }
        return false;
    }

    public void append(int newValue) {
        if (this.head == null) {
            head = new Node(newValue);
            return;
        }

        Node nextToCheck = head;

        do {
            if (nextToCheck.getNext() == null) {
                Node newNode = new Node(newValue);
                nextToCheck.setNext(newNode);
                break;
            } else {
                nextToCheck = nextToCheck.getNext();
            }
        } while (nextToCheck != null);
    }

    public void insertBefore(int searchValue, int newValue) throws Exception {
        if (head.getValue() == searchValue) {
            insert(newValue);
        } else {
            Node previousChecked = head;
            do {
                if (previousChecked.getNext() == null) {
                    throw new Exception("Value not found.");
                }
                if (previousChecked.getNext().getValue() == searchValue) {
                    Node newNode = new Node(newValue);
                    newNode.setNext(previousChecked.getNext());
                    previousChecked.setNext(newNode);
                    return;
                } else {
                    previousChecked = previousChecked.getNext();
                }
            } while (previousChecked != null);

        }
    }

    public void insertAfter(int searchValue, int newValue) throws Exception {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getValue() == searchValue) {
                Node newNode = new Node(newValue);
                newNode.setNext(currentNode.getNext());
                currentNode.setNext(newNode);
                return;
            }
            currentNode = currentNode.getNext();
        }
        throw new Exception("Value not found.");
    }

    public int kthFromEnd(int k) throws Exception {
        if (this.head == null) {
            throw new Exception("The linked list is empty");
        }
        if (k < 0) {
            throw new Exception("input must be greater than or equal to 0");
        }
        Node node = this.head;
        int listSize = 0;
        int returnValue = node.getValue();

        while (node != null) {
            node = node.getNext();
            listSize++;
        }

        if (listSize <= k) {
            throw new NullPointerException("k input is out of bounds");
        }
        node = this.head;
        for (int i = 0; i < listSize - k; i++) {
            returnValue = node.getValue();
            node = node.getNext();
        }

        return returnValue;
    }

    public static LinkedList zipLists(LinkedList ll1, LinkedList ll2) throws Exception {
        if (ll1.head == null && ll2.head == null) {
            throw new Exception("At least one linked list must contain a value");
        }
        if (ll1.head == null) {
            return ll2;
        }
        if (ll2.head == null) {
            return ll1;
        }

        Node current1 = ll1.head;
        Node current2 = ll2.head;
        Node temp1 = current1.getNext();
        Node temp2 = current2.getNext();

        while (temp1 != null && temp2 != null) {
            current1.setNext(current2);
            current2.setNext(temp1);
            current1 = temp1;
            current2 = temp2;
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }

        current1.setNext(current2);
        if (temp1 != null) {
            current2.setNext(temp1);
        }

        return ll1;
    }
}
