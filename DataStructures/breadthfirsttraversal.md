# Breadth First

From a starting node, traverse a series of nodes and return them in the order they were reversed.

## Challenge

Extend the graph from Code Challenge 35 so that you traverse a set of values in a graph. Do not use any built in methods. Return an object that contains the values in the order that they were traversed in.
Return the first word to occur more than once in that provided string.

## Approach & Efficiency

We used a HashSet to store values as we encountered them. That was used to check if a value had been seen already, and then an ArrayList held values in order as the object for the return output.

- O(n) Time 
- O(n) Space

## Solution

<img src="src/main/resources/whiteboard-ch-36.PNG">
