# Trees

Creating tree data structures.

## Challenge

Create binary tree and binary search tree classes. The binary tree class should have methods for retrieving all values from the tree in pre-order, in-order, and post-order formats. The binary search tree should extend those methods and also include the ability to add a value and check if a value is contained in the tree.

## Approach & Efficiency

For an underlying structure, I created a Node class that carries a value and points at its left and right children. And a Tree class that points to its root node.

The BinaryTree class extends the Tree class and adds methods for searching a binary tree structure. They preOrder() method walks the left nodes then right nodes and returns an array with values in the order they are first encountered. The inOrder() method walks the tree left to right and returns an array with values ordered left to right. The postOrder() method walks the tree left to right and returns an array prioritizing child node values first.

The BinarySearchTree class extends the BinaryTree class and adds methods to add values and check if a value exists in the tree. The add() method checks the value against each node recursively and looks for an empty space to create a new node with that value such that it is greater than all nodes left of it and less than all nodes right of it. If the value is already in the tree, it throws an exception expressing that.
The contains() method recursively searches the tree for the value given by checking that value relative to each node and choosing to search left or right. It returns boolean true if it is found and false if it is not.

Time Efficiency:
  - preOrder : O(n)
  - inOrder : O(n)
  - postOrder : O(n)
  - add : O(h) (where h is the height of the tree)
  - contains : O(h)

Space Efficiency:
  - preOrder : O(h)
  - inOrder : O(h)
  - postOrder : O(h)
  - add : O(h)
  - contains : O(h)

## API

  - preOrder : Takes in a Node and an empty Integer ArrayList and returns an Integer ArrayList including all values in the tree.
  - inOrder : Takes in a Node and an empty Integer ArrayList and returns an Integer ArrayList including all values in the tree.
  - postOrder : Takes in a Node and an empty Integer ArrayList and returns an Integer ArrayList including all values in the tree.
  - add : Takes in an Integer and adds it to the tree in sorted order. Throws an Exception if the value already exists in the tree.
  - contains : Takes in an Integer and returns true if it is in the tree, false if not.
